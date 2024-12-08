package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.DatPhongModel;
import vn.iotstar.models.GiamGiaModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IGiamGiaService;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.GiamGiaServiceImpl;

@WebServlet(urlPatterns = {"/xacNhan"})
public class xacNhanController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IDatPhongService datPhongService = new DatPhongServiceImpl();
	public IGiamGiaService giamGiaService = new GiamGiaServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String username = null;
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
			username = user.getFullname();
		}
		req.setAttribute("username", username);
		
		Object idKhachSanObj = session.getAttribute("idKhachSan");
    	int idKhachSan = 0;
        if (idKhachSanObj != null) {
        	idKhachSan = (int) idKhachSanObj;
        } 
		
		int idUser = user.getId();
		String hovaten = req.getParameter("hovaten");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String slphongdat = req.getParameter("slphongdat");		
		String thanhTien = req.getParameter("thanhTien") + " VNĐ";
		String tenPhong = req.getParameter("tenPhong");
		String ngayDen = req.getParameter("ngayDen");
		String ngayDi = req.getParameter("ngayDi");
		String specialRequests = req.getParameter("specialRequests");
		String payment = req.getParameter("payment");		
		String giamGia = req.getParameter("giamgia");
		
		session.setAttribute("slphongdat", slphongdat);
		session.setAttribute("thanhTien", req.getParameter("thanhTien"));
		session.setAttribute("specialRequests", specialRequests);
		session.setAttribute("payment", payment);
		session.setAttribute("idUser", String.valueOf(idUser));
		session.setAttribute("giamgia", String.valueOf(giamGia));
		
		req.setAttribute("hovaten", hovaten);
		req.setAttribute("email", email);
		req.setAttribute("phone", phone);
		req.setAttribute("slphongdat", slphongdat);
		req.setAttribute("thanhTien", thanhTien);
		req.setAttribute("tenPhong", tenPhong);
		req.setAttribute("ngayDen", ngayDen);
		req.setAttribute("ngayDi", ngayDi);
		req.setAttribute("specialRequests", specialRequests);
		req.setAttribute("payment", payment);
		req.setAttribute("idKhachSan", idKhachSan);
		
		session.setAttribute("currentURL", req.getContextPath().toString() + "/datPhong");
		req.getRequestDispatcher("/views/xacNhanDatPhong.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int idPhong = 0;
		Object idPhongObj = session.getAttribute("idphong");
	    if (idPhongObj != null) {
	        idPhong = Integer.parseInt((String) idPhongObj);
	    }
	    
	    int idUser = 0;
		Object idUserObj = session.getAttribute("idUser");
	    if (idUserObj != null) {
	    	idUser = Integer.parseInt((String) idUserObj);
	    }
	    
	    int slphongdat = 0;
		Object slphongdatObj = session.getAttribute("slphongdat");
	    if (slphongdatObj != null) {
	    	slphongdat = Integer.parseInt((String) slphongdatObj);
	    }
	    
	    int thanhTien = 0;
		Object thanhTienObj = session.getAttribute("thanhTien");
	    if (thanhTienObj != null) {
	    	thanhTien = Integer.parseInt((String) thanhTienObj);
	    }
	    
	    int idGiamGia = 0;
		Object idGiamGiaObj = session.getAttribute("giamgia");
	    if (idGiamGiaObj != null) {
	    	idGiamGia = Integer.parseInt((String)idGiamGiaObj);
	    }
	    
	    String ngayDenStr = (String) session.getAttribute("ngayDen1");
	    Date ngayDen = null;
		try {
			ngayDen = Date.valueOf(ngayDenStr);
		} catch (IllegalArgumentException e) {
			return;
		}
		
		
		String ngayDiStr = (String) session.getAttribute("ngayDi1");
		Date ngayDi = null;
		try {
			ngayDi = Date.valueOf(ngayDiStr);
		} catch (IllegalArgumentException e) {
			return;
		}
	    
		String specialRequests = (String) session.getAttribute("specialRequests");
		
		String payment = (String) session.getAttribute("payment");
		
		if (idGiamGia != 0) {
			GiamGiaModel giamGia = giamGiaService.findById(idGiamGia);
			giamGiaService.updateSoLanDaSuDung(giamGia.getSoLanDaSuDung() + 1, idGiamGia);	
			giamGiaService.insertMaGiamGiaCuaKhach(idGiamGia, idUser);
		}
		Date ngayHienTai = new Date(System.currentTimeMillis());
		datPhongService.insert(new DatPhongModel(idUser, idPhong, ngayHienTai, ngayDen, ngayDi, specialRequests, thanhTien, 0, slphongdat, false, payment));
		req.setAttribute("isSuccess", true);
		req.getRequestDispatcher("/views/xacNhanDatPhong.jsp").forward(req, resp);
	}
}
