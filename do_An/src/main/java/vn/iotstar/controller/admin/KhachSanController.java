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
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;

@WebServlet(urlPatterns = {"/admin/listKhachSan","/admin/khachSan/duyet","/admin/khachSan/huy"})
public class KhachSanController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
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
		System.out.println ("id cua user: " + user.getId());
		if (url.contains("/admin/listKhachSan")) {
			List<KhachSanModel> listKhachSan = khachSanService.findAll();
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("listkhachsan", listKhachSan);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/listKhachSan.jsp").forward(req, resp);
		}
		if (url.contains("/admin/khachSan/duyet")) {
			String idKSStr = req.getParameter("id");
			if (idKSStr != null) {
				int idKS = Integer.parseInt(idKSStr);
				KhachSanModel ks = khachSanService.findById(idKS);
				ks.setStatus(1);
				ks.setActive(true);
				khachSanService.update(ks);
				
				resp.sendRedirect(req.getContextPath() + "/admin/listKhachSan");
			}
		}
		if (url.contains("/admin/khachSan/huy")) {
			String idKSStr = req.getParameter("id");
			String noiDung  = req.getParameter("noidung");
			if (idKSStr != null) {
				int idKS = Integer.parseInt(idKSStr);
				KhachSanModel ks = khachSanService.findById(idKS);
				ks.setStatus(3);
				ks.setActive(false);
				if (noiDung != null) {
					thongBaoService.insert(new ThongBaoModel(ks.getidUser(),new Timestamp(System.currentTimeMillis()),noiDung));
				}
				khachSanService.update(ks);
				resp.sendRedirect(req.getContextPath() + "/admin/listKhachSan");
			}
		}
		
	}
}
