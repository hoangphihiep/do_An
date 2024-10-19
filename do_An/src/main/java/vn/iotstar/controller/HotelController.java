package vn.iotstar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.models.DanhGiaModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IDanhGiaService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.DanhGiaServiceImpl;
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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		KhachSanModel khachSan = khachSanService.findById(id);
		
		req.setAttribute("ks", khachSan);
		
		List<PhongModel> listPhong = phongService.findByIdKhachSan(id);
		req.setAttribute("listPhong", listPhong);
		
		String[] strDanhGia = {"Bình thường", "Khá ổn", "Chất lượng", "Sang trọng", "Tuyệt vời", "Xuất sắc"};
		req.setAttribute("strDanhGia", strDanhGia);
		
		List<AnhKhachSanModel> listAnh = anhKhachSanService.findByIdKhachSan(id);
		req.setAttribute("listAnh", listAnh);
		
		List<TienIchModel> listTienIch = tienIchService.findByIdKhachSan(id);
		req.setAttribute("listTienIch", listTienIch);
		
		List<DanhGiaModel> listDanhGia = danhGiaService.findByIdKhachSan(id);
		int tuyetVoi = 0;
		int ratTot = 0;
		int haiLong = 0;
		int trungBinh = 0;
		int kem = 0;
		int count = 0;
		int tongDiem = 0;
		for (DanhGiaModel danhGia : listDanhGia)
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
		req.setAttribute("count", count);
		req.setAttribute("tuyetVoi", tuyetVoi);
		req.setAttribute("ratTot", ratTot);
		req.setAttribute("haiLong", haiLong);
		req.setAttribute("trungBinh", trungBinh);
		req.setAttribute("kem", kem);
		req.setAttribute("trungBinhCong", trungBinhCong);
		req.setAttribute("listDanhGia", listDanhGia);
		req.getRequestDispatcher("/views/khachsan.jsp").forward(req, resp);
	}

}
