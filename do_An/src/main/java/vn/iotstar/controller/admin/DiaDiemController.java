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
import vn.iotstar.models.DiaDiemModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IDiaDiemService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.impl.DiaDiemServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;
import vn.iotstar.utils.Constant;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 8,  // Tăng giới hạn của mỗi file lên 8MB nếu cần
	    maxRequestSize = 1024 * 1024 * 40  // Tăng tổng kích thước tối đa của yêu cầu lên 40MB
	)
@WebServlet(urlPatterns = {"/admin/listDiaDiem","/admin/diaDiem/add"
		,"/admin/diaDiem/insert", "/admin/diaDiem/edit"
		,"/admin/diaDiem/update","/admin/diaDiem/delete"})
public class DiaDiemController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IDiaDiemService diaDiemService = new DiaDiemServiceImpl();
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
		if (url.contains("/admin/listDiaDiem")) {
			List<DiaDiemModel> listDiaDiem = diaDiemService.findAll();
			
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("listdiadiem", listDiaDiem);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/listDiaDiem.jsp").forward(req, resp);
		}
		if (url.contains("/admin/diaDiem/add")) {
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/addDiaDiem.jsp").forward(req, resp);
		}
		if (url.contains("/admin/diaDiem/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			DiaDiemModel diaDiem = diaDiemService.findById(id);
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("diadiem", diaDiem);
			req.setAttribute("username", user.getFullname());
			req.getRequestDispatcher("/views/admin/suaDiaDiem.jsp").forward(req, resp);
		}
		if (url.contains("/admin/diaDiem/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			// xóa file củ
			DiaDiemModel diaDiem = diaDiemService.findById(id);
			String fileold = diaDiem.getUrlHinhAnh();
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
			diaDiemService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/listDiaDiem");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/admin/diaDiem/insert")) {
			String ten = req.getParameter("tendiadiem");
			String moTa = req.getParameter("mota");
			
			DiaDiemModel diaDiem = new DiaDiemModel();
			diaDiem.setTen(ten);
			diaDiem.setMoTa(moTa);
			
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

					diaDiem.setUrlHinhAnh(fname);
				} 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			diaDiemService.insert(diaDiem);
			resp.sendRedirect(req.getContextPath() + "/admin/listDiaDiem");	
		}
		if (url.contains("/admin/diaDiem/update")) {
			int id = Integer.parseInt(req.getParameter("idiadiem"));
			String ten = req.getParameter("tendiadiem");
			String moTa = req.getParameter("mota");
			
			DiaDiemModel diaDiem = new DiaDiemModel();
			String fileold = diaDiem.getUrlHinhAnh();
			diaDiem.setId(id);
			diaDiem.setTen(ten);
			diaDiem.setMoTa(moTa);
			
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
					diaDiem.setUrlHinhAnh(fname);
				}
				else {
					String fileName = req.getParameter("image1Url");
					String result = fileName.replace("/do_An/image?fname=", "");
					diaDiem.setUrlHinhAnh(result);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			diaDiemService.update(diaDiem);
			resp.sendRedirect(req.getContextPath() + "/admin/listDiaDiem");	
		}
	}
}
