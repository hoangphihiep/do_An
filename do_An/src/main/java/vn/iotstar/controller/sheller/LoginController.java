package vn.iotstar.controller.sheller;

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

@WebServlet(urlPatterns = {"/sheller/dangNhap"})
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IUserServices service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/sheller/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alertMsg", alertMsg);
			req.setAttribute("isSuccess", false);
			req.getRequestDispatcher("/views/sheller/login.jsp").forward(req, resp);
		    return;
		}
		
		UserModel user = service.findByUserName(username);
		if (user.getIdRole() == 2) {
			user = service.login(username, password);
			
			if (user != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("account", user);
				}
				req.setAttribute("isSuccess", true);
				req.setAttribute("username", user.getFullname());
				req.getRequestDispatcher("/views/sheller/login.jsp").forward(req, resp);
			} else {
				alertMsg = "Tài khoản hoặc mật khẩu không đúng";
				req.setAttribute("alertMsg", alertMsg);
				req.setAttribute("isSuccess", false);
				req.getRequestDispatcher("/views/sheller/login.jsp").forward(req, resp);
			}
		}
}
