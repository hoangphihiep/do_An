package vn.iotstar.controller.sheller;

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
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.AESUtil;

@WebServlet(urlPatterns = {"/sheller1/dangKy"})
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		if (user != null) {
			req.setAttribute("email", user.getEmail());
			
		}
		req.getRequestDispatcher("/views/sheller/register.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String username = req.getParameter("username");
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
		String otpCode = String.format("%06d", (int)(Math.random() * 1000000));
		sendOtpEmail(email, otpCode);
		
		String encryptedPassword = null;
		try {
			encryptedPassword = AESUtil.encrypt(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getSession().setAttribute("otp", otpCode);
		req.getSession().setAttribute("username1", username);
		req.getSession().setAttribute("email", email);
		req.getSession().setAttribute("password", encryptedPassword);;
		if (email != null && password != null) {
			System.out.println ("có vào đây");
    		resp.sendRedirect(req.getContextPath() + "/sheller1/xacThucOTP");
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
