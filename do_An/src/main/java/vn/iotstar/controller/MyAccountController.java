package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.models.CheckboxModel;
import vn.iotstar.models.LichSuModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.ILichSuDatPhongService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.LichSuDatPhongServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/myAccount","/myAccount/trangCaNhan","/myAccount/lichSuDatPhong"})
public class MyAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ILichSuDatPhongService lichSuService = new LichSuDatPhongServiceImpl();
	public IUserServices userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel taiKhoan = (UserModel) session.getAttribute("account");
		if (url.contains("/myAccount/trangCaNhan")) 
		{
			req.setAttribute("ten", taiKhoan.getUsername());
			req.setAttribute("hovaten", taiKhoan.getFullname());
			req.setAttribute("ngaysinh", taiKhoan.getCreatedDate());
			req.setAttribute("gioitinh", taiKhoan.getGender());
			req.setAttribute("email", taiKhoan.getEmail());
			req.setAttribute("dienthoai", taiKhoan.getPhone());
			req.setAttribute("diaChi", taiKhoan.getDiaChi());
			req.setAttribute("matkhau", taiKhoan.getPassword());
			req.getRequestDispatcher("/views/caNhan.jsp").forward(req, resp);
	
		}
		if (url.contains("/myAccount/lichSuDatPhong")) 
		{
			List<LichSuModel> listLichSu = lichSuService.findByIdUser(taiKhoan.getId());
			req.setAttribute("listLichSu", listLichSu);
			req.getRequestDispatcher("/views/lichSuDatPhong.jsp").forward(req, resp);	
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ten = req.getParameter("ten");
		String hovaten = req.getParameter("hovaten");
		String ngaysinh = req.getParameter("ngaysinh");
		String gioitinh = req.getParameter("gioitinh");
		String email = req.getParameter("email");
		String dienthoai = req.getParameter("dienthoai");
		String diachi = req.getParameter("diachi");
		String matkhau = req.getParameter("matkhau");
		
		HttpSession session = req.getSession();
		UserModel taiKhoan = (UserModel) session.getAttribute("account");
		
		Date createdDate = null;
		try {
			createdDate = Date.valueOf(ngaysinh);
		} catch (IllegalArgumentException e) {
			return;
		}
		System.out.println (ten + " " + hovaten + " " + ngaysinh + gioitinh + email 
				+ dienthoai + diachi + matkhau);
		userService.update(new UserModel(taiKhoan.getId(),ten,hovaten,createdDate,gioitinh,email,dienthoai,diachi,matkhau,1));
		
		
	}
}
