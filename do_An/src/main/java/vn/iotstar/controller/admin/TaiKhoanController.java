package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.ThongBaoServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin/listTaiKhoan"})
public class TaiKhoanController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IUserServices userService = new UserServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		session.setAttribute("account", user);
		List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
		int soLuongThongBao = listThongBao.size();
		req.setAttribute("slthongbao", soLuongThongBao);
		req.setAttribute("listthongbao", listThongBao);
		String idUserStr = req.getParameter("id");
		if (idUserStr != null) {
			int idUser = Integer.parseInt(idUserStr);
			UserModel user1 = userService.findById(idUser);
			if (user1.isAcitve() == true) {
				user1.setAcitve(false);
				userService.update(user1);
			}
			else
			{
				user1.setAcitve(true);
				userService.update(user1);
			}
		}
		System.out.println ("fullname cua user1: " + user.getFullname());
		req.setAttribute("username", user.getFullname());
		List<UserModel> listUser = userService.findAll();
		req.setAttribute("listuser", listUser);
		req.getRequestDispatcher("/views/admin/listTaiKhoan.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
