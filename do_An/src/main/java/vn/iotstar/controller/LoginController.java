package vn.iotstar.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// lấy toàn bộ hàm trong service
	IUserServices service = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			
			return;
		}
		// Kiểm tra cookie nếu không có session
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
					System.out.println("Tên cookie: " + cookie.getName() + ", Giá trị cookie: " + cookie.getValue());
					// Tạo session mới và đặt thuộc tính tài khoản nếu tìm thấy cookie
					System.out.println("Cookie nhớ đã được tìm thấy: " + cookie.getValue());
					session = req.getSession(true);
					String username = cookie.getValue();
			        UserModel user = service.findByUserName(username);
			        if (user != null) { // Kiểm tra nếu user tồn tại
			        	session.setAttribute("account", user);
			        	System.out.println("Đăng nhập tự động thông qua cookie");
			        	resp.sendRedirect(req.getContextPath() + "/waiting");
			        	
			        	return;
			       }
				}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// lấy tham số từ view
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");

		boolean isRememberMe = false;
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.getSession().setAttribute("alert", alertMsg);
		    resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
		    return;
		}

		// Xử lý bài toán login
		System.out.println (username);
		System.out.println (password);
		UserModel user = service.login(username, password);
		System.out.println (user.getFullname());
		System.out.println (user.isAcitve());
		System.out.println (username);
		System.out.println (password);
		if (user != null) {
			if (user.isAcitve() == false){
				alertMsg = "Tài khoản của bạn đã bị khóa ";
				req.getSession().setAttribute("alert", alertMsg);
				resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
				System.out.println ("Có vào chổ này 222?");
			}
			else {
				HttpSession session = req.getSession(true);
				session.setAttribute("account", user);
				if (isRememberMe) {
					saveRemeberMe(resp, username);
				}
				System.out.println ("Có vào chổ này 333?");
				resp.sendRedirect(req.getContextPath() + "/waiting");
			}
			
		} 
		else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.getSession().setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
		} 
	}
	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		cookie.setPath("/"); // Áp dụng cho toàn bộ ứng dụng
		response.addCookie(cookie);
	}

}
