package vn.iotstar.controller;

import java.io.IOException;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
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
	private static final String SECRET_KEY = "Tuonglua8*8014725836901234567890123456";
	// lấy toàn bộ hàm trong service
	IUserServices service = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		HttpSession session = req.getSession(false);
		String action = req.getParameter("action");

		if ("logout".equals(action)) {
	            getLogOut(req, resp);
	            return;
	    }

		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
			}

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("jwtToken")) {
					String jwtToken = cookie.getValue();
					if (validateJWTToken(jwtToken)) {
						Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	                    Claims claims = Jwts.parserBuilder()
	                                        .setSigningKey(key)
	                                        .build()
	                                        .parseClaimsJws(jwtToken)
	                                        .getBody();
	                    String username = claims.get("sub", String.class);

	                    // Tạo session mới nếu chưa có và lưu username vào session
	                    session = req.getSession(true);
	                    session.setAttribute("username", username);
	                    resp.sendRedirect(req.getContextPath() + "/waiting");
                        return;
                    }	
				}
			}
		}
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
			String jwtToken = createJWTToken(user.getUsername());			
			if (isRememberMe) {
				saveRememberMe(resp, jwtToken);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			System.out.println (alertMsg);
			req.getSession().setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
		} 
	}
	private void saveRememberMe(HttpServletResponse response, String jwtToken) {
        Cookie cookie = new Cookie("jwtToken", jwtToken);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }
	private String createJWTToken(String username) {
        long currentTimeMillis = System.currentTimeMillis();
        Date expiryDate = new Date(currentTimeMillis + 30 * 60 * 1000); // JWT hết hạn sau 30 phút
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .claim("sub", username) // Thay thế setSubject bằng cách thêm claim "sub"
                .claim("iat", currentTimeMillis / 1000)
                .claim("exp", expiryDate.getTime() / 1000)      // Đặt thời gian hết hạn
                .signWith(key)
                .compact();
    }
	public boolean validateJWTToken(String jwtToken) {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            Jwts.parserBuilder()          // Sử dụng parserBuilder để khởi tạo bộ phân tích
                .setSigningKey(key)       // Đặt khóa ký
                .build()                  // Xây dựng bộ phân tích
                .parseClaimsJws(jwtToken); // Phân tích và xác thực token
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	private void getLogOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	//khi logout xoa 2 session account binh thuong va account fb
    	HttpSession session = req.getSession();
		session.removeAttribute("account");
		session.removeAttribute("accountfb");
    	
        // Xóa JWT , fb trong cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwtToken")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    break;
                }
                if (cookie.getName().equals("fbToken")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/home?showLoginModal=true");
    }

}
