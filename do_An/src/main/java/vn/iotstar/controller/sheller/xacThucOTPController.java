package vn.iotstar.controller.sheller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/sheller1/xacThucOTP"})
public class xacThucOTPController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = (String) req.getSession().getAttribute("email");
		req.setAttribute("email", email);
		req.getRequestDispatcher("/views/sheller/xacThucOTP.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		String otpCode1 = req.getParameter("otp1");
		String otpCode2 = req.getParameter("otp2");
		String otpCode3 = req.getParameter("otp3");
		String otpCode4 = req.getParameter("otp4");
		String otpCode5 = req.getParameter("otp5");
		String otpCode6 = req.getParameter("otp6");
		String otpCode = otpCode1 + otpCode2 + otpCode3 + otpCode4 + otpCode5 + otpCode6;
		
		String sessionOtp = (String) req.getSession().getAttribute("otp");
        String username = (String) req.getSession().getAttribute("username1");
        String email = (String) req.getSession().getAttribute("email");
        String password = (String) req.getSession().getAttribute("password");
        
        System.out.println ("Người dùng nhập" + otpCode);
        System.out.println ("Bên hệ thống" + sessionOtp);
        System.out.println ("Password: " + password);
        IUserServices service = new UserServiceImpl();
        if (otpCode != null && otpCode.equals(sessionOtp)) {
        	boolean isSuccess = service.register(username, username, null, null, email, null, password,null,2,true);
    		if (isSuccess) {
    			req.setAttribute("isSuccess", true);
    			UserModel user = service.findByUserName(username);
				session.setAttribute("idUser", user.getId());
				session.setAttribute("account", user);
    			req.getRequestDispatcher("/views/sheller/xacThucOTP.jsp").forward(req, resp);
    		} else {
    			req.setAttribute("isSuccess", false);
    			resp.sendRedirect(req.getContextPath() + "/sheller1/dangKy");
    		} 
        } 
        String sessionOtp1 = (String) req.getSession().getAttribute("otp1");
        if (otpCode != null && otpCode.equals(sessionOtp1)) {
        	 resp.sendRedirect(req.getContextPath() + "/home?showResetPassword=true");
        }
        else {
            resp.getWriter().println("Mã OTP không hợp lệ, vui lòng thử lại.");
        }
	}

}
