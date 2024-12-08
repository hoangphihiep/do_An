package vn.iotstar.controller.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.models.LoaiKhachSanModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;
import vn.iotstar.utils.Constant;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 8,  // Tăng giới hạn của mỗi file lên 8MB nếu cần
	    maxRequestSize = 1024 * 1024 * 40  // Tăng tổng kích thước tối đa của yêu cầu lên 40MB
	)
@WebServlet(urlPatterns = {"/admin/listLoaiKhachSan","/admin/loaiKhachSan/add"
		,"/admin/loaiKhachSan/insert", "/admin/loaiKhachSan/edit"
		,"/admin/loaiKhachSan/update","/admin/loaiKhachSan/delete"})
public class LoaiKhachSanController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ILoaiKhachSanService loaiKhachSanService = new LoaiKhachSanServiceImpl();
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
		List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
		if (url.contains("/admin/listLoaiKhachSan")) {
			
			List<LoaiKhachSanModel> listLoaiKS = loaiKhachSanService.findAll();
			
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("listloaiks", listLoaiKS);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/listLoaiKhachSan.jsp").forward(req, resp);
		}
		if (url.contains("/admin/loaiKhachSan/add")) {
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/addLoaiKhachSan.jsp").forward(req, resp);
		}
		if (url.contains("/admin/loaiKhachSan/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			LoaiKhachSanModel loaiKS = loaiKhachSanService.findById(id);
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("loaiKS", loaiKS);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/suaLoaiKhachSan.jsp").forward(req, resp);
		}
		if (url.contains("/admin/loaiKhachSan/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			// xóa file củ
			LoaiKhachSanModel loaiKS = loaiKhachSanService.findById(id);
			String fileold = loaiKS.getUrlHinhAnh();
			String uploadPath = Constant.DIR;
			if (fileold != null && !fileold.isEmpty() && !fileold.startsWith("https")) {
				Path oldFilePath = Paths.get(uploadPath, fileold);
				if (Files.exists(oldFilePath)) {
					try {
						Files.delete(oldFilePath);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			loaiKhachSanService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/listLoaiKhachSan");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/admin/loaiKhachSan/insert")) {
			String ten = req.getParameter("ten");
			String moTa = req.getParameter("mota");
			
			LoaiKhachSanModel loaiKS = new LoaiKhachSanModel();
			loaiKS.setTen(ten);
			loaiKS.setMoTa(moTa);

			
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();

			try {
				Part part = req.getPart("image1");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;

					part.write(uploadPath + "/" + fname);

					loaiKS.setUrlHinhAnh(fname);
				} 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			loaiKhachSanService.insert(loaiKS);
			resp.sendRedirect(req.getContextPath() + "/admin/listLoaiKhachSan");	
		}
		if (url.contains("/admin/loaiKhachSan/update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String ten = req.getParameter("ten");
			String moTa = req.getParameter("mota");
			
			LoaiKhachSanModel loaiKS = new LoaiKhachSanModel();
			String fileold = loaiKS.getUrlHinhAnh();
			loaiKS.setId(id);
			loaiKS.setTen(ten);
			loaiKS.setMoTa(moTa);
			
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();

			// Xóa file cũ trước khi ghi file mới
			if (fileold != null && !fileold.isEmpty() && !fileold.startsWith("https")) {
				Path oldFilePath = Paths.get(uploadPath, fileold);
				if (Files.exists(oldFilePath)) {
					try {
						Files.delete(oldFilePath);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Part part = req.getPart("image1");
				if (part.getSize() > 0 && part != null) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// Ghi file mới
					part.write(uploadPath + File.separator + fname);
					loaiKS.setUrlHinhAnh(fname);
				}
				else {
					String fileName = req.getParameter("image1Url");
					String result = fileName.replace("/do_An/image?fname=", "");
					loaiKS.setUrlHinhAnh(result);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			loaiKhachSanService.update(loaiKS);
			resp.sendRedirect(req.getContextPath() + "/admin/listLoaiKhachSan");	
		}
	}
}
