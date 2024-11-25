package vn.iotstar.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.models.DanhGiaModel;
import vn.iotstar.services.IDanhGiaService;
import vn.iotstar.services.impl.DanhGiaServiceImpl;
import vn.iotstar.utils.Constant;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 8,  // Tăng giới hạn của mỗi file lên 8MB nếu cần
	    maxRequestSize = 1024 * 1024 * 40  // Tăng tổng kích thước tối đa của yêu cầu lên 40MB
	)
@WebServlet(urlPatterns = {"/comment"})
public class CommentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IDanhGiaService danhGiaService = new DanhGiaServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int danhGia =Integer.parseInt(req.getParameter("danhgia"));
		String comment = req.getParameter("comment");
		int idKhachSan = Integer.parseInt(req.getParameter("id"));
		 
		HttpSession session = req.getSession(); 
		int idUser = (int) session.getAttribute("idKhachHang");
		
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

			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(danhGia);
		System.out.println(comment);
		System.out.println(idKhachSan);
		System.out.println(idUser);
		System.out.println(fname);
		danhGiaService.insert(new DanhGiaModel(danhGia, comment, idUser, idKhachSan, fname));
		resp.sendRedirect(req.getContextPath() + "/myAccount/lichSuDatPhong");
	}
	

}
