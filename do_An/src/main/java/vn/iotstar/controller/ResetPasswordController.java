package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.AESUtil;

@WebServlet(urlPatterns = "/updatePassword")
public class ResetPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IUserServices userService = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String) req.getSession().getAttribute("email1");
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		String skipUpdate = req.getParameter("skipUpdate");
		
		
		IUserServices service = new UserServiceImpl();
		String alertMsg = "";
		UserModel user = userService.findByUsernameOrEmail(email);
		
		if (!newPassword.equals(confirmPassword)) {
			alertMsg = "Mật khẩu không khớp!";
			req.getSession().setAttribute("alert1", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/home?showResetPassword=true");
			return;
		}
		
		String encryptedPassword = null;
		try {
			encryptedPassword = AESUtil.encrypt(newPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if ("true".equals(skipUpdate)) {
			
			HttpSession session = req.getSession(false);
			session = req.getSession(true);
			session.setAttribute("username", user.getFullname());
			session.setAttribute("account", user);
			resp.sendRedirect(req.getContextPath() + "/home");
		}
		else{
			boolean isSuccess = service.updatePassword(email, encryptedPassword);
			if (isSuccess) {
				alertMsg = "Bạn đã cập nhật mật khẩu mới! Đăng nhập lại.";
				req.getSession().setAttribute("alert", alertMsg);
				resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
			} else {
				alertMsg = "System error!";
				req.getSession().setAttribute("alert1", alertMsg);
				resp.sendRedirect(req.getContextPath() + "/home?showResetPassword=true");
			}
		}
		
	}
}
