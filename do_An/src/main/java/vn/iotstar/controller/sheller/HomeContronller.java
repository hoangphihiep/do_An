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
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.impl.KhachSanServiceImpl;

@WebServlet(urlPatterns = {"/sheller/home"})
public class HomeContronller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		
		List<KhachSanModel> listKS = khachSanService.findByIdUser(user.getId());
		session.setAttribute("idUser", user.getId());
		req.setAttribute("listKS", listKS);
		req.setAttribute("username", user.getFullname());
		
		req.getRequestDispatcher("/views/sheller/shellerHome.jsp").forward(req, resp);
	}
}
