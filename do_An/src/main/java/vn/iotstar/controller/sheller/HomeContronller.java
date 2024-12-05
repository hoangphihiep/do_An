package vn.iotstar.controller.sheller;

import java.io.IOException;
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

@WebServlet(urlPatterns = {"/sheller/home"})
public class HomeContronller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		
		List<KhachSanModel> listKS = khachSanService.findByIdUser(user.getId());
		session.setAttribute("account", user);
		List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
		int soLuongThongBao = listThongBao.size();
		req.setAttribute("listKS", listKS);
		req.setAttribute("slthongbao", soLuongThongBao);
		req.setAttribute("listthongbao", listThongBao);
		req.setAttribute("username", user.getFullname());
		session.setAttribute("idUser", user.getId());
		
		req.getRequestDispatcher("/views/sheller/shellerHome.jsp").forward(req, resp);
	}
}
