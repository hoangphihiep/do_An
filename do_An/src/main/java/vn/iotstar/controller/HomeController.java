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
import vn.iotstar.models.DiaDiemModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IDiaDiemService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.DiaDiemServiceImpl;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IDiaDiemService diaDiemService = new DiaDiemServiceImpl();
	public ILoaiKhachSanService loaiKhachSanService = new LoaiKhachSanServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	public IDatPhongService datPhongService = new DatPhongServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String username = null;
		if (session != null && session.getAttribute("account") != null) {
			UserModel user = (UserModel) session.getAttribute("account");
			username = user.getFullname();
		}
		req.setAttribute("username", username);
		
		// danh sách thành phố 
		List<DiaDiemModel> list = diaDiemService.findAll();
		req.setAttribute("listdiadiem", list);
		
		//danh sách loại khách sạn
		List<LoaiKhachSanModel> listLoaiKS = loaiKhachSanService.findAll();
		req.setAttribute("listloaiks", listLoaiKS);
		
		if (session != null) {
			session.setAttribute("currentURL", req.getContextPath().toString() + "/home");
		}
		
		
		//danh sách khách sạn
		String[] strDanhGia = {"Bình thường", "Khá ổn", "Chất lượng", "Sang trọng", "Tuyệt vời", "Xuất sắc"};
		List<KhachSanModel> listKS = khachSanService.findByDatPhong();
		List<DiaDiemModel> listDiaDiem = diaDiemService.findAll();
		req.setAttribute("listks", listKS);
		req.setAttribute("listdiadiem", listDiaDiem);
		req.setAttribute("strDanhGia", strDanhGia);
		req.getRequestDispatcher("/views/home/trangchu.jsp").forward(req, resp);
	} 
}
