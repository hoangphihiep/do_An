package vn.iotstar.controller;

import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		IUserServices service = new UserServiceImpl();
		
		String otpCode = String.format("%06d", (int)(Math.random() * 1000000));
		sendOtpEmail(email, otpCode);
		
		req.getSession().setAttribute("otp1", otpCode);
		req.getSession().setAttribute("email1", email);
		
		System.out.println ("Email: " + email);
		System.out.println ("otp cua email: " + otpCode);
		String alertMsg = "";
		if (service.checkExistEmail(email)) {
			resp.sendRedirect(req.getContextPath() + "/home?showOTP=true");
		} else {
			alertMsg = "Email không tồn tại!";
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/home?showForgotPassword=true");
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
