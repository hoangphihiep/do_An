package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
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
		Cookie[] cookies = req.getCookies();
		HttpSession session = req.getSession(false);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					return;
				}
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			System.out.println (alertMsg);
			req.getSession().setAttribute("alert", alertMsg);
		    resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
		    return;
		}

		// Xử lý bài toán login

		UserModel user = service.login(username, password);
		
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			String currentURL = (String) session.getAttribute("currentURL");
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			resp.sendRedirect(currentURL);
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			System.out.println (alertMsg);
			req.getSession().setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
		} 
	}
	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}
}
