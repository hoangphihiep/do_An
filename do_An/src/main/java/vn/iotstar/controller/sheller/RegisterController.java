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
import vn.iotstar.utils.AESUtil;

@WebServlet(urlPatterns = {"/sheller/dangKy"})
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		req.setAttribute("email", user.getEmail());
		req.getRequestDispatcher("/views/sheller/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String repeatPassword = req.getParameter("Repassword");
		
		HttpSession session = req.getSession();
		
		String alertMsg1 = "";
		if (email == null || password == null ){
			alertMsg1 = "Bạn chưa điền thông tin vào đăng ký!";
			System.out.println(alertMsg1);
			req.getSession().setAttribute("alert1", alertMsg1);
			resp.sendRedirect(req.getContextPath() + "/home?showRegisterModal=true");
			return;
		}
		if (!password.equals(repeatPassword)) {
			alertMsg1 = "Mật khẩu không khớp!";
			req.getSession().setAttribute("alert1", alertMsg1);
			resp.sendRedirect(req.getContextPath() + "/home?showRegisterModal=true");
			return;
		}
		String encryptedPassword = null;
		try {
			encryptedPassword = AESUtil.encrypt(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IUserServices service = new UserServiceImpl();
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		if (email != null && password != null) {
			boolean isSuccess = service.register(user.getUsername(), user.getFullname(), user.getCreatedDate(), user.getGender(), email, user.getPhone(), encryptedPassword, user.getDiaChi(),2);
			if (isSuccess) {
				req.setAttribute("isSuccess", true);
				req.setAttribute("doiTac", user.getUsername());
				session.setAttribute("idUser", user.getId());
				req.getRequestDispatcher("/views/sheller/register.jsp").forward(req, resp);
    			//resp.sendRedirect(req.getContextPath() + "/sheller/dangChoNghi/ThongTinCoBan");
			}	
		}
	}
}
