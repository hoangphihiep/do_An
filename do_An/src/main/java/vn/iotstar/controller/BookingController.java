package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;

@WebServlet(urlPatterns = {"/datPhong"})
public class BookingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public IPhongService phongService = new PhongServiceImpl();
	public IDatPhongService datPhongService = new DatPhongServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int idPhong = 0;
		String id = req.getParameter("id");
		if (id == null) {
		    Object idPhongObj = session.getAttribute("idphong");
		    if (idPhongObj != null) {
		        idPhong = Integer.parseInt((String) idPhongObj);
		    }
		} else {
		    idPhong = Integer.parseInt(id);
		    session.setAttribute("idphong", String.valueOf(idPhong));
		}
		
		PhongModel Phong = phongService.findById(idPhong);
		
		String username = null;
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
			username = user.getFullname();
		}
		req.setAttribute("username", username);
		session.setAttribute("currentURL", req.getContextPath().toString() + "/datPhong");
		
		
		String ngayDen = (String) session.getAttribute("ngayDen1");
		String ngayDi = (String) session.getAttribute("ngayDi1");
		
		SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dateNgayDen = Date.valueOf(ngayDen);
		    Date dateNgayDi = Date.valueOf(ngayDi);

		    // Chuyển đổi java.sql.Date thành chuỗi theo định dạng mong muốn
		    String ngayDenFormatted = newFormat.format(dateNgayDen);
		    String ngayDiFormatted = newFormat.format(dateNgayDi);

		    req.setAttribute("ngayDen", ngayDenFormatted);
		    req.setAttribute("ngayDi", ngayDiFormatted);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		req.setAttribute("tenphong", Phong.getTen());
		req.setAttribute("anhhong", Phong.getAnhPhong());
		req.setAttribute("slkhach", Phong.getSucChuaToiDa());
		req.setAttribute("sophongtrong", Phong.getSoPhongTrong());
		req.setAttribute("tienphong", Phong.getGiaThue());
		if (user != null) {
			req.setAttribute("hovaten", user.getFullname());
			req.setAttribute("sodt", user.getPhone());
			req.setAttribute("email", user.getEmail());
		}
		req.getRequestDispatcher("/views/datPhong.jsp").forward(req, resp);
	}
}
