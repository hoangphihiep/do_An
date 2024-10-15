package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.LoaiKhachSanModel;
import vn.iotstar.models.ThanhPhoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IThanhPhoService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.ThanhPhoServiceImpl;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IThanhPhoService thanhPhoService = new ThanhPhoServiceImpl();
	public ILoaiKhachSanService loaiKhachSanService = new LoaiKhachSanServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		String username = null;
		if (session != null && session.getAttribute("account") != null) {
			UserModel user = (UserModel) session.getAttribute("account");
			username = user.getFullname();
		}
		req.setAttribute("username", username);
		
		// danh sách thành phố 
		List<ThanhPhoModel> list = thanhPhoService.findAll();
		req.setAttribute("listthanhpho", list);
		
		//danh sách loại khách sạn
		List<LoaiKhachSanModel> listLoaiKS = loaiKhachSanService.findAll();
		req.setAttribute("listloaiks", listLoaiKS);
		
		//danh sách khách sạn
		String[] strDanhGia = {"Bình thường", "Khá ổn", "Chất lượng", "Sang trọng", "Tuyệt vời", "Xuất sắc"};
		List<KhachSanModel> listKS = khachSanService.findAll();
		req.setAttribute("listks", listKS);
		req.setAttribute("strDanhGia", strDanhGia);
		req.getRequestDispatcher("/views/home/trangchu.jsp").forward(req, resp);
	}
}
