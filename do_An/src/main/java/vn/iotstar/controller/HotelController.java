package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.models.DanhGiaModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IDanhGiaService;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.DanhGiaServiceImpl;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.TienIchServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/khachsan"})
public class HotelController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	public ITienIchService tienIchService = new TienIchServiceImpl();
	public IDanhGiaService danhGiaService = new DanhGiaServiceImpl();
	public IUserServices userService = new UserServiceImpl();
	public IDatPhongService datPhongService = new DatPhongServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String username = null;
		if (session != null && session.getAttribute("account") != null) {
			UserModel user = (UserModel) session.getAttribute("account");
			username = user.getFullname();
		}
		req.setAttribute("username", username);
		session.setAttribute("currentURL", req.getContextPath().toString() + "/khachsan");
		
		String ngayDen = (String) session.getAttribute("ngayDen");
		String ngayDenStr = req.getParameter("ngayDen");
		Date ngayDen1 = null;
		try {
			ngayDen1 = Date.valueOf(ngayDen);
		} catch (IllegalArgumentException e) {
			return;
		}
		if (ngayDenStr != null) {
			try {
				ngayDen1 = Date.valueOf(ngayDenStr);
			} catch (IllegalArgumentException e) {
				return;
			}
			ngayDen = ngayDenStr;
		}
		
		
		String ngayDi = (String) session.getAttribute("ngayDi");
		String ngayDiStr = req.getParameter("ngayTra");
		Date ngayDi1 = null;
		try {
			ngayDi1 = Date.valueOf(ngayDi);
		} catch (IllegalArgumentException e) {
			return;
		}
		if (ngayDiStr != null) {
			try {
				ngayDi1 = Date.valueOf(ngayDiStr);
			} catch (IllegalArgumentException e) {
				return;
			}
			ngayDi = ngayDiStr;
		}
		
		Object idKhachSanObj = session.getAttribute("idKhachSan");
    	
    	int idKhachSan = 0;
        if (idKhachSanObj != null) {
        	idKhachSan = (int) idKhachSanObj;
        } 
        String idKhachSanStr = req.getParameter("id");
        if (idKhachSanStr != null) {
            idKhachSan = Integer.parseInt(idKhachSanStr);
            session.setAttribute("idKhachSan", idKhachSan);
        }
		KhachSanModel khachSan = khachSanService.findById(idKhachSan);
		
		req.setAttribute("ks", khachSan);
		
		List<PhongModel> listPhong = phongService.findByIdKhachSan(idKhachSan);
		for (PhongModel phong : listPhong) {	
			int count  = datPhongService.countPhongDaDat(ngayDen1, ngayDi1, phong.getId());		
			phongService.updateSLPhong(count, phong.getSoPhongTrong(), phong.getSoPhongDaDat(), phong.getId());
		}
		List<PhongModel> listPhong1 = phongService.findByIdKhachSan(idKhachSan);
		List<PhongModel> listPhong2 = new ArrayList<>(); 
		for (PhongModel phong : listPhong1) {	
			
			if (phong.getSoPhongTrong() != 0) {
				listPhong2.add(phong);
			}
		}
		req.setAttribute("listPhong", listPhong2);
		
		String[] strDanhGia = {"Bình thường", "Khá ổn", "Chất lượng", "Sang trọng", "Tuyệt vời", "Xuất sắc"};
		req.setAttribute("strDanhGia", strDanhGia);
		
		List<AnhKhachSanModel> listAnh = anhKhachSanService.findByIdKhachSan(idKhachSan);
		req.setAttribute("listAnh", listAnh);
		
		List<TienIchModel> listTienIch = tienIchService.findByIdKhachSan(idKhachSan);
		req.setAttribute("listTienIch", listTienIch);
		
		int currentPage = 1;
        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }
        
		List<DanhGiaModel> listDanhGia = danhGiaService.findByIdKhachSan(currentPage, idKhachSan);
		
		List<DanhGiaModel> listDanhGia1 = danhGiaService.findByIdKhachSan(idKhachSan);
		
		int countKS = danhGiaService.countAllByIdKhachSan(idKhachSan);
    	int endPage = countKS/3;
    	if (countKS % 3 != 0) {
    		endPage ++;
    	}
    	req.setAttribute("currentPage", currentPage);
    	req.setAttribute("countKS", countKS);
    	req.setAttribute("endPage", endPage);
    	
		int tuyetVoi = 0;
		int ratTot = 0;
		int haiLong = 0;
		int trungBinh = 0;
		int kem = 0;
		int count = 0;
		int tongDiem = 0;
		for (DanhGiaModel danhGia : listDanhGia1)
		{
			if (danhGia.getDiem() == 10){
				tuyetVoi++;
			}	
			else if (danhGia.getDiem() == 9 || danhGia.getDiem() == 8) {
				ratTot++;
			}	
			else if (danhGia.getDiem() == 7 || danhGia.getDiem() == 6) {
				haiLong++;
			}	
			else if (danhGia.getDiem() == 5 || danhGia.getDiem() == 4) {
				trungBinh++;
			}
			else if (danhGia.getDiem() < 4) {
				kem++;
			}	
			count++;
			tongDiem = tongDiem + danhGia.getDiem();
		}
		double trungBinhCong = (double)tongDiem/count;
		
		session.setAttribute("ngayDen1", ngayDen);
		session.setAttribute("ngayDi1", ngayDi);
		
		req.setAttribute("count", count);
		req.setAttribute("tuyetVoi", tuyetVoi);
		req.setAttribute("ratTot", ratTot);
		req.setAttribute("haiLong", haiLong);
		req.setAttribute("trungBinh", trungBinh);
		req.setAttribute("kem", kem);
		req.setAttribute("trungBinhCong", trungBinhCong);
		req.setAttribute("listDanhGia", listDanhGia);
		req.setAttribute("ngayDen", ngayDen);
		req.setAttribute("ngayDi", ngayDi);
		req.getRequestDispatcher("/views/khachsan.jsp").forward(req, resp);
	}

}
