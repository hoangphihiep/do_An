package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("Username");
		String fullname = req.getParameter("Fullname");
		String createdDateStr = req.getParameter("DateofBirth");
		String gender = req.getParameter("gender");
		String email = req.getParameter("Email");
		String phone = req.getParameter("Phone");
		String password = req.getParameter("Password");
		String repeatPassword = req.getParameter("Psw-repeat");
		String diaChi = req.getParameter("Address" );

		Date createdDate = null;
		try {
			createdDate = Date.valueOf(createdDateStr);
		} catch (IllegalArgumentException e) {
			return;
		}

		IUserServices service = new UserServiceImpl();
		String alertMsg = "";

		if (!password.equals(repeatPassword)) {
			alertMsg = "Mật khẩu không khớp!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
		}

		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
		}
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
			return;
		}
		boolean isSuccess = service.register(username, fullname, createdDate, gender, email, phone, password,diaChi,1);
		if (isSuccess) {
			alertMsg = "Bạn đã đăng ký thành công!";
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
		}
	}
}
