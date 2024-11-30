package vn.iotstar.controller.sheller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.DatPhongModel;
import vn.iotstar.models.GiamGiaModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.KhuyenMaiModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IKhuyenMaiService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.KhuyenMaiServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;

@WebServlet(urlPatterns = {"/sheller/danhSachKhuyenMai","/sheller/khuyenMai/add"
		,"/sheller/khuyenMai/insert", "/sheller/khuyenMai/edit"
		,"/sheller/khuyenMai/update","/sheller/khuyenMai/delete","/sheller/khuyenMai/getRooms"})
public class khuyenMaiController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(false);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		if (url.contains("/sheller/danhSachKhuyenMai")) {
			int idUser = user.getId();
			List<KhuyenMaiModel> listKhuyenMai = khuyenMaiService.findByIdSheller(idUser);
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listkhuyenmai", listKhuyenMai);
			req.getRequestDispatcher("/views/sheller/listKhuyenMai.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/khuyenMai/add")) {
			int idUser = user.getId();
			List<KhachSanModel> listKhachSan = khachSanService.findByIdUser(idUser);
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listkhachsan", listKhachSan);
			req.getRequestDispatcher("/views/sheller/addKhuyenMai.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/khuyenMai/getRooms")) {
			// Lấy idKhachSan từ request
	        String idKhachSan = req.getParameter("idKS");
	        
	        int idKS = Integer.parseInt(idKhachSan);
	        // Lấy danh sách phòng theo id khách sạn
	        List<PhongModel> listPhong = phongService.findByIdKhachSan(idKS);

	        // Trả về danh sách phòng dưới dạng JSON
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");

	        // Chuyển danh sách phòng sang JSON
	        Gson gson = new Gson();
	        String json = gson.toJson(listPhong);
	        resp.getWriter().write(json);
		}
		if (url.contains("/sheller/khuyenMai/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			KhuyenMaiModel khuyenMai = khuyenMaiService.findById(id);
			req.setAttribute("khuyenmai", khuyenMai);
			int idUser = user.getId();
			List<KhachSanModel> listKhachSan = khachSanService.findByIdUser(idUser);
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("listkhachsan", listKhachSan);
			req.getRequestDispatcher("/views/sheller/suaKhuyenMai.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/khuyenMai/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			khuyenMaiService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachKhuyenMai");	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/sheller/khuyenMai/insert")) {
			
			String tenKhuyenMai = req.getParameter("tenkhuyenmai");
			String moTa = req.getParameter("mota");
			String phanTramGiamGiaStr = req.getParameter("discount-amount");
			int phanTramGiamGia = Integer.parseInt(phanTramGiamGiaStr);
			String ngayBatDauStr = req.getParameter("ngaybatdau");
			String ngayKetThucStr = req.getParameter("ngayketthuc");
			int idKS = Integer.parseInt(req.getParameter("idKhachSan"));
			String idPhongStr = req.getParameter("idPhong");
			int idPhong = 0;
			
			Date ngayBatDau = null;
			if (ngayBatDauStr != null) {
				try {
					ngayBatDau = Date.valueOf(ngayBatDauStr);
				} catch (IllegalArgumentException e) {
					return;
				}
			}
			
			Date ngayKetThuc = null;
			if (ngayKetThucStr != null) {
				try {
					ngayKetThuc = Date.valueOf(ngayKetThucStr);
				} catch (IllegalArgumentException e) {
					return;
				}
			}
			
			if (idPhongStr.length() > 0) {
				idPhong = Integer.parseInt(idPhongStr);
				System.out.println ("idPhongStr: " + idPhongStr.length());
				khuyenMaiService.insert(new KhuyenMaiModel(tenKhuyenMai,moTa,phanTramGiamGia,ngayBatDau,ngayKetThuc,idPhong,idKS,2));
			}else {
				khuyenMaiService.insert(new KhuyenMaiModel(tenKhuyenMai,moTa,phanTramGiamGia,ngayBatDau,ngayKetThuc,null,idKS,2));
			}
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachKhuyenMai");	
		}
		if (url.contains("/sheller/khuyenMai/update")) {
			int id = Integer.parseInt(req.getParameter("idkhuyenmai"));
			
			String tenKhuyenMai = req.getParameter("tenkhuyenmai");
			String moTa = req.getParameter("mota");
			String phanTramGiamGiaStr = req.getParameter("discount-amount");
			int phanTramGiamGia = Integer.parseInt(phanTramGiamGiaStr);
			String ngayBatDauStr = req.getParameter("ngaybatdau");
			String ngayKetThucStr = req.getParameter("ngayketthuc");
			int idKS = Integer.parseInt(req.getParameter("idKhachSan"));
			String idPhongStr = req.getParameter("idPhong");
			int idPhong = 0;
			
			Date ngayBatDau = null;
			if (ngayBatDauStr != null) {
				try {
					ngayBatDau = Date.valueOf(ngayBatDauStr);
				} catch (IllegalArgumentException e) {
					return;
				}
			}
			
			Date ngayKetThuc = null;
			if (ngayKetThucStr != null) {
				try {
					ngayKetThuc = Date.valueOf(ngayKetThucStr);
				} catch (IllegalArgumentException e) {
					return;
				}
			}
			if (idPhongStr.length() > 0) {
				idPhong = Integer.parseInt(idPhongStr);
				khuyenMaiService.update(new KhuyenMaiModel(id,tenKhuyenMai,moTa,phanTramGiamGia,ngayBatDau,ngayKetThuc,idPhong,idKS,2));
			}else {
				khuyenMaiService.update(new KhuyenMaiModel(id,tenKhuyenMai,moTa,phanTramGiamGia,ngayBatDau,ngayKetThuc,null,idKS,2));
			}
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachKhuyenMai");	
		}
	}
}
