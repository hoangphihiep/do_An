package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;

@WebServlet(urlPatterns = {"/khachsan"})
public class HotelController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		KhachSanModel khachSan = khachSanService.findById(id);
		
		req.setAttribute("ks", khachSan);
		
		List<PhongModel> listPhong = phongService.findByIdKhachSan(id);
		for (PhongModel phong: listPhong)
		{
			System.out.println(phong.getLoaiGiuong());
		}
		req.setAttribute("listPhong", listPhong);
		
		String[] strDanhGia = {"Bình thường", "Khá ổn", "Chất lượng", "Sang trọng", "Tuyệt vời", "Xuất sắc"};
		req.setAttribute("strDanhGia", strDanhGia);
		
		req.getRequestDispatcher("/views/khachsan.jsp").forward(req, resp);
	}

}
