package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.AESUtil;

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
		String gender = req.getParameter("gioiTinh");
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
		
		String otpCode = String.format("%06d", (int)(Math.random() * 1000000));
		sendOtpEmail(email, otpCode);
		
		
		IUserServices service = new UserServiceImpl();
		String alertMsg1 = "";
		if (username == null || fullname == null || createdDateStr == null || gender == null || email == null || phone == null || password == null || diaChi == null){
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
		if (service.checkExistEmail(email)) {
			alertMsg1 = "Email đã tồn tại!";
			req.getSession().setAttribute("alert1", alertMsg1);
			resp.sendRedirect(req.getContextPath() + "/home?showRegisterModal=true");
			return;
		}
		if (service.checkExistUsername(username)) {
			alertMsg1 = "Tài khoản đã tồn tại!";
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
		
		req.getSession().setAttribute("otp", otpCode);
		req.getSession().setAttribute("username", username);
		req.getSession().setAttribute("fullname", fullname);
		req.getSession().setAttribute("createdDate", createdDate);
		req.getSession().setAttribute("gender", gender);
		req.getSession().setAttribute("email", email);
		req.getSession().setAttribute("phone", phone);
		req.getSession().setAttribute("password", encryptedPassword);
	    req.getSession().setAttribute("diaChi", diaChi);
		
		if (username != null && fullname != null && createdDateStr != null && gender != null && email != null && phone != null && password != null && diaChi != null) {
			resp.sendRedirect(req.getContextPath() + "/home?showOTP=true");
		}	
	}
	private void sendOtpEmail(String email, String otpCode) {
        // Thiết lập cấu hình email server
        String host = "smtp.gmail.com";
        String port = "587";
        String senderEmail = "phihiep31012004@gmail.com";
        String senderPassword = "ocjsgypnecgrwmcy";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Thiết lập nội dung email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Mã OTP kích hoạt tài khoản");
            message.setText("Xin chào, mã OTP của bạn là: " + otpCode);

            // Gửi email
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
