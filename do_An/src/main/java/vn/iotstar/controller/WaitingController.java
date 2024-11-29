package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			UserModel u = (UserModel) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			if (u.getIdRole() == 3) {
				resp.sendRedirect(req.getContextPath() + "/admin/listTaiKhoan");
			} else if (u.getIdRole() == 2) {
				resp.sendRedirect(req.getContextPath() + "/sheller/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			String currentURL = (String) session.getAttribute("currentURL");
			resp.sendRedirect(currentURL);
			resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
		}
	}
}
