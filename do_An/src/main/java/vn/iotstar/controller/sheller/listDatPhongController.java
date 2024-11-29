package vn.iotstar.controller.sheller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.DatPhongModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;

@WebServlet(urlPatterns = {"/sheller/danhSachDatPhong","/sheller/datPhong/xacNhanTT", "/sheller/datPhong/huyDatPhong"})
public class listDatPhongController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IDatPhongService datPhongService = new DatPhongServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(false);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		
		if (url.contains("/sheller/danhSachDatPhong")) {
			int idUser = user.getId();
			System.out.println ("id cua chu: " + idUser);
			List<DatPhongModel> listDP = datPhongService.listPhongDaDatByIdSheller(idUser);
			List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
			int soLuongThongBao = listThongBao.size();
			session.setAttribute("account", user);
			req.setAttribute("listDP", listDP);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.getRequestDispatcher("/views/sheller/danhSachDatPhong.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/datPhong/xacNhanTT")) {
			int id = Integer.parseInt(req.getParameter("id"));
			datPhongService.updateTrangThaiTT(id);
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachDatPhong");	
		}
		if (url.contains("/sheller/datPhong/huyDatPhong")) {
			int id = Integer.parseInt(req.getParameter("id"));
			datPhongService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/sheller/danhSachDatPhong");	
		}
		
	}

}
