package vn.iotstar.controller.sheller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = {"/sheller/xoaChoNghi"})
public class xoaChoNghiController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		// xóa file củ
		List<AnhKhachSanModel> listAnhKS = anhKhachSanService.findByIdKhachSan(id);
		for (AnhKhachSanModel anhks : listAnhKS) {
			String imageOld = anhks.getUrlAnhKhachSan();
			String uploadPath = Constant.DIR;
			if (imageOld != null && !imageOld.isEmpty()&& !imageOld.startsWith("https")) {
				Path oldImagePath = Paths.get(uploadPath, imageOld);
				if (Files.exists(oldImagePath)) {
					try {
						Files.delete(oldImagePath);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		khachSanService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/sheller/home");	
	}
}
