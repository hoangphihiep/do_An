package vn.iotstar.controller.sheller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.DatPhongModel;
import vn.iotstar.models.GiamGiaModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IGiamGiaService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.GiamGiaServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;

@WebServlet(urlPatterns = {"/sheller/danhSachGiamGia","/sheller/giamGia/add"
		,"/sheller/giamGia/insert", "/sheller/giamGia/edit"
		,"/sheller/giamGia/update","/sheller/giamGia/delete"})
public class giamGiaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public IDatPhongService datPhongService = new DatPhongServiceImpl();
	public IGiamGiaService giamGiaService = new GiamGiaServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
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
		if (url.contains("/sheller/danhSachGiamGia")) {
			int idUser = user.getId();
			List<DatPhongModel> listKhachDP = datPhongService.listKhachDatPhong(idUser);
			List<GiamGiaModel> listGiamGia = giamGiaService.findByIdSheller(idUser);
			for (GiamGiaModel giamGia: listGiamGia) {
				if (giamGia.getApDung() != null && giamGia.getApDung().matches("\\d+")) { 
				    giamGia.setIdKhachHang(Integer.parseInt(giamGia.getApDung())); 
				}
				else {
					System.out.println (giamGia.getIdKhachHang());
				}
			}
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listGiamGia", listGiamGia);
			req.setAttribute("listKhachDP", listKhachDP);
			req.getRequestDispatcher("/views/sheller/listGiamGia.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/giamGia/add")) {
			int idUser = user.getId();
			List<DatPhongModel> listKhachDP = datPhongService.listKhachDatPhong(idUser);
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listKhachDP", listKhachDP);
			req.getRequestDispatcher("/views/sheller/addGiamGia.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/giamGia/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			GiamGiaModel giamGia = giamGiaService.findById(id);
			req.setAttribute("giamgia", giamGia);
			int idUser = user.getId();
			List<DatPhongModel> listKhachDP = datPhongService.listKhachDatPhong(idUser);
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listKhachDP", listKhachDP);
			req.getRequestDispatcher("/views/sheller/suaGiamGia.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/giamGia/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			giamGiaService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachGiamGia");	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(false);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		if (url.contains("/sheller/giamGia/insert")) {
			
			String maGiamGia = req.getParameter("discount-code");
			String apDung = req.getParameter("apdung");
			String phanTramGiamGiaStr = req.getParameter("discount-amount");
			int phanTramGiamGia = Integer.parseInt(phanTramGiamGiaStr);
			String ngayBatDauStr = req.getParameter("ngaybatdau");
			String ngayKetThucStr = req.getParameter("ngayketthuc");
			String soLuongMaStr = req.getParameter("soluongma");
			int soLuongMa = Integer.parseInt(soLuongMaStr);
			
			int idUser = user.getId();
			System.out.println ("id cua chu: " + idUser);
			
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
			giamGiaService.insert(new GiamGiaModel(maGiamGia,phanTramGiamGia, ngayBatDau, ngayKetThuc, soLuongMa, 0, idUser, apDung));
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachGiamGia");	
		}
		if (url.contains("/sheller/giamGia/update")) {
			int id = Integer.parseInt(req.getParameter("idgiamgia"));
			String maGiamGia = req.getParameter("discount-code");
			String apDung = req.getParameter("apdung");
			String phanTramGiamGiaStr = req.getParameter("discount-amount");
			int phanTramGiamGia = Integer.parseInt(phanTramGiamGiaStr);
			String ngayBatDauStr = req.getParameter("ngaybatdau");
			String ngayKetThucStr = req.getParameter("ngayketthuc");
			String soLuongMaStr = req.getParameter("soluongma");
			int soLuongMa = Integer.parseInt(soLuongMaStr);
			int soLuongMaSuDung = Integer.parseInt(req.getParameter("soluongmadasd"));
			
			int idUser = user.getId();
			System.out.println ("ap dung: " + apDung);
			
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
			giamGiaService.update(new GiamGiaModel(id,maGiamGia,phanTramGiamGia, ngayBatDau, ngayKetThuc, soLuongMa,apDung, soLuongMaSuDung, idUser ));
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachGiamGia");	
		}
	}

}
