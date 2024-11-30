package vn.iotstar.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.KhuyenMaiModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IKhuyenMaiService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.KhuyenMaiServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;

@WebServlet(urlPatterns = {"/admin/listKhuyenMai","/admin/khuyenMai/duyet","/admin/khuyenMai/huy"})
public class KhuyenMaiController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		session.setAttribute("account", user);
		if (url.contains("/admin/listKhuyenMai")) {
			List<KhuyenMaiModel> listKhuyenMai = khuyenMaiService.findAll();
			
			req.setAttribute("listkhuyenmai", listKhuyenMai);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/listKhuyenMai.jsp").forward(req, resp);
		}
		if (url.contains("/admin/khuyenMai/duyet")) {
			String idStr = req.getParameter("id");
			if (idStr != null) {
				int id = Integer.parseInt(idStr);
				KhuyenMaiModel khuyenMai = khuyenMaiService.findById(id);
				khuyenMai.setStatus(1);
				if (khuyenMai.getIdPhong() == 0) {
					khuyenMai.setIdPhong(null);
				}
				khuyenMaiService.update(khuyenMai);
				resp.sendRedirect(req.getContextPath() + "/admin/listKhuyenMai");
			}
		}
		if (url.contains("/admin/khuyenMai/huy")) {
			String idStr = req.getParameter("id");
			String noiDung  = req.getParameter("noidung");
			if (idStr != null) {
				int id = Integer.parseInt(idStr);
				KhuyenMaiModel khuyenMai = khuyenMaiService.findById(id);
				KhachSanModel ks = khachSanService.findById(khuyenMai.getIdKS());
				khuyenMai.setStatus(3);
				if (noiDung != null) {
					thongBaoService.insert(new ThongBaoModel(ks.getidUser(),new Timestamp(System.currentTimeMillis()),noiDung));
				}
				if (khuyenMai.getIdPhong() == 0) {
					khuyenMai.setIdPhong(null);
				}
				khuyenMaiService.update(khuyenMai);
				resp.sendRedirect(req.getContextPath() + "/admin/listKhuyenMai");
			}
		}
	}
}
