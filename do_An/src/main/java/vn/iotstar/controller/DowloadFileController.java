package vn.iotstar.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = {"/image"})
public class DowloadFileController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("fname");
		
		if (fileName != null && !fileName.isEmpty()) {
			File file = new File(Constant.DIR + "/" + fileName);
	        if (file.exists()) {
	        	resp.setContentType("image/jpeg"); // Hoặc loại MIME tương ứng
	            try (FileInputStream fis = new FileInputStream(file);
	                OutputStream os = resp.getOutputStream()) {
	                byte[] buffer = new byte[1024];
	                int bytesRead;
	                while ((bytesRead = fis.read(buffer)) != -1) {
	                    os.write(buffer, 0, bytesRead);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            
	        }
	    }
//		resp.setContentType("image/jpeg");
//		if (file.exists()) {
//			IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
//		}
	}

}
