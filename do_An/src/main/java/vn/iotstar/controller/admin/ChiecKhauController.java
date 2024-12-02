package vn.iotstar.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.ChiecKhauModel;
import vn.iotstar.models.DatPhongModel;
import vn.iotstar.models.GiamGiaModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IChiecKhauService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.ChiecKhauServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;

@WebServlet(urlPatterns = {"/admin/listChiecKhau","/admin/chiecKhau/add"
		,"/admin/chiecKhau/insert", "/admin/chiecKhau/edit"
		,"/admin/chiecKhau/update","/admin/chiecKhau/delete"})
public class ChiecKhauController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public IChiecKhauService chiecKhauService = new ChiecKhauServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		session.setAttribute("account", user);
		if (url.contains("/admin/listChiecKhau")) {
			List<ChiecKhauModel> listChiecKhau = chiecKhauService.findAll();
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("listchieckhau", listChiecKhau);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/listChiecKhau.jsp").forward(req, resp);
		}
		if (url.contains("/admin/chiecKhau/add")) {
			
			List<KhachSanModel> listKhachSan = khachSanService.findAll();
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listkhachsan", listKhachSan);
			req.getRequestDispatcher("/views/admin/addChiecKhau.jsp").forward(req, resp);
		}
		if (url.contains("/admin/chiecKhau/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			ChiecKhauModel chiecKhau = chiecKhauService.findById(id);
			List<KhachSanModel> listKhachSan = khachSanService.findAll();
			req.setAttribute("listkhachsan", listKhachSan);
			req.setAttribute("chieckhau", chiecKhau);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/suaChiecKhau.jsp").forward(req, resp);
		}
		if (url.contains("/admin/chiecKhau/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			chiecKhauService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/listChiecKhau");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/admin/chiecKhau/insert")) {
			int phanTramChiecKhau = Integer.parseInt(req.getParameter("discount-amount"));
			int idKS = Integer.parseInt(req.getParameter("idKhachSan"));
			
			chiecKhauService.insert(new ChiecKhauModel(idKS, phanTramChiecKhau));
			resp.sendRedirect(req.getContextPath() + "/admin/listChiecKhau");	
		}
		if (url.contains("/admin/chiecKhau/update")) {
			int id = Integer.parseInt(req.getParameter("idchieckhau"));
			int idKS = Integer.parseInt(req.getParameter("idKhachSan"));
			int phanTramChiecKhau = Integer.parseInt(req.getParameter("discount-amount"));
			
			chiecKhauService.update(new ChiecKhauModel(id,idKS,phanTramChiecKhau));
			resp.sendRedirect(req.getContextPath() + "/admin/listChiecKhau");	
		}
	}

}
