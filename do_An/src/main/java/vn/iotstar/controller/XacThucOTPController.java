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

@WebServlet(urlPatterns = {"/xacThucOTP","/xacThucOTPforgetPassword"})
public class XacThucOTPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String otpCode1 = req.getParameter("otp1");
			String otpCode2 = req.getParameter("otp2");
			String otpCode3 = req.getParameter("otp3");
			String otpCode4 = req.getParameter("otp4");
			String otpCode5 = req.getParameter("otp5");
			String otpCode6 = req.getParameter("otp6");
			String otpCode = otpCode1 + otpCode2 + otpCode3 + otpCode4 + otpCode5 + otpCode6;
			
			String sessionOtp = (String) req.getSession().getAttribute("otp");
	        String username = (String) req.getSession().getAttribute("username");
	        String fullname = (String) req.getSession().getAttribute("fullname");
	        Date createdDate = (Date) req.getSession().getAttribute("createdDate");
	        String gender = (String) req.getSession().getAttribute("gender");
	        String email = (String) req.getSession().getAttribute("email");
	        String phone = (String) req.getSession().getAttribute("phone");
	        String password = (String) req.getSession().getAttribute("password");
	        String diaChi = (String) req.getSession().getAttribute("diaChi");
	        
	        System.out.println ("Người dùng nhập" + otpCode);
	        System.out.println ("Bên hệ thống" + sessionOtp);
	        System.out.println ("Password: " + password);
	        String alertMsg = "";
	        String alertMsg1 = "";
	        IUserServices service = new UserServiceImpl();
	        if (otpCode != null && otpCode.equals(sessionOtp)) {
	        	boolean isSuccess = service.register(username, fullname, createdDate, gender, email, phone, password,diaChi,1,true);
	    		if (isSuccess) {
	    			alertMsg = "Bạn đã đăng ký thành công!";
	    			req.getSession().setAttribute("alert", alertMsg);
	    			resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
	    		} else {
	    			alertMsg1 = "System error!";
	    			req.getSession().setAttribute("alert1", alertMsg1);
	    			resp.sendRedirect(req.getContextPath() + "/home?showRegisterModal=true");
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
