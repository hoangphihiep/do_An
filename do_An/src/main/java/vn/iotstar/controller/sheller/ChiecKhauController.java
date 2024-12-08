package vn.iotstar.controller.sheller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.ChiecKhauModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IChiecKhauService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.ChiecKhauServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/sheller/danhSachChiecKhau", "/sheller/chiecKhau/yeuCauSua"})
public class ChiecKhauController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	public IChiecKhauService chiecKhauService = new ChiecKhauServiceImpl();
	public IUserServices userService = new UserServiceImpl();
	
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
		if (url.contains("/sheller/danhSachChiecKhau")) {
			int idUser = user.getId();
			List <ChiecKhauModel> listChiecKhau = chiecKhauService.findByIdSheller(idUser);
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listchieckhau", listChiecKhau);
			req.getRequestDispatcher("/views/sheller/listChiecKhau.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/chiecKhau/yeuCauSua")) {
			String noiDung  = req.getParameter("noidung");
			List<UserModel> listUser = userService.findAll();
			for (UserModel u : listUser) {
				if (u.getIdRole() == 3 && noiDung != null) {
					thongBaoService.insert(new ThongBaoModel(u.getId(),new Timestamp(System.currentTimeMillis()),noiDung));
				}
			}
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachChiecKhau");
		}
	}
}
