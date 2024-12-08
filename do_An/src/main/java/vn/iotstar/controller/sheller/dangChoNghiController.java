package vn.iotstar.controller.sheller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.LoaiKhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.DiaDiemModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IDiaDiemService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.DiaDiemServiceImpl;
import vn.iotstar.services.impl.TienIchServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.Constant;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 8,  // Tăng giới hạn của mỗi file lên 8MB nếu cần
	    maxRequestSize = 1024 * 1024 * 40  // Tăng tổng kích thước tối đa của yêu cầu lên 40MB
	)
@WebServlet(urlPatterns = {"/sheller/dangChoNghi/ThongTinCoBan","/sheller/thongTinCoBan", 
		"/sheller/dangChoNghi/tienIch", "/sheller/tienIch",
		"/sheller/dangChoNghi/anhKS", "/sheller/anhKS",
		"/sheller/dangChoNghi/phong", "/sheller/phong"})
public class dangChoNghiController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ILoaiKhachSanService loaiKSService = new LoaiKhachSanServiceImpl();
	public IDiaDiemService thanhPhoService = new DiaDiemServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public ITienIchService tienIchService = new TienIchServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	public IUserServices userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (url.contains("/sheller/dangChoNghi/ThongTinCoBan")) {
			int idUser = (int) session.getAttribute("idUser");
			List<LoaiKhachSanModel> listLoaiKS = loaiKSService.findAll();
			List<DiaDiemModel> listDiaDiem = thanhPhoService.findAll();
			UserModel user = userService.findById(idUser);
			req.setAttribute("listloaiks", listLoaiKS);
			req.setAttribute("listdiadiem", listDiaDiem);
			req.setAttribute("username", user.getFullname());
			session.setAttribute("account", user);
			req.getRequestDispatcher("/views/sheller/dangChoNghi.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/dangChoNghi/tienIch")) {
			int idUser = (int) session.getAttribute("idUser");
			UserModel user = userService.findById(idUser);
			req.setAttribute("username", user.getFullname());
			session.setAttribute("account", user);
			req.getRequestDispatcher("/views/sheller/dangChoNghiTienIch.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/dangChoNghi/anhKS")) {
			int idUser = (int) session.getAttribute("idUser");
			UserModel user = userService.findById(idUser);
			req.setAttribute("username", user.getFullname());
			session.setAttribute("account", user);
			req.getRequestDispatcher("/views/sheller/dangChoNghiAnhKS.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/dangChoNghi/phong")) {
			String idKSStr = req.getParameter("idKS");
			System.out.println ("id của khách sạn: " + idKSStr);
			if (idKSStr != null) {
				session.setAttribute("idKSStr", idKSStr);
			}
			int idUser = (int) session.getAttribute("idUser");
			UserModel user = userService.findById(idUser);
			req.setAttribute("username", user.getFullname());
			session.setAttribute("account", user);
			req.getRequestDispatcher("/views/sheller/dangChoNghiPhong.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if (url.contains("/sheller/thongTinCoBan")) {
			String tenLoaiKS = req.getParameter("accommodationType");
			int idLoaiKS = loaiKSService.findIdByNameLoaiKS(tenLoaiKS);
			String tenKS = req.getParameter("hotel-name");
			String moTa = req.getParameter("moTa");
			int cachTT = Integer.parseInt(req.getParameter("distance-city"));
			boolean giapBien = "1".equals(req.getParameter("giapBien"));
			int danhGia = Integer.parseInt(req.getParameter("danhGia"));
			String diaChi = req.getParameter("address");
			String tenDiaDiem = req.getParameter("city");
			DiaDiemModel DiaDiem = thanhPhoService.findByName(tenDiaDiem);
			int idDiaDiem = DiaDiem.getId();
			HttpSession session = req.getSession();
			int idUser = (int) session.getAttribute("idUser");
			KhachSanModel ks = new KhachSanModel(0, tenKS, diaChi, idUser, cachTT, moTa, giapBien, danhGia, idDiaDiem, tenDiaDiem, idLoaiKS, tenLoaiKS, null,2,false);
			
			session.setAttribute("ks", ks);
			resp.sendRedirect(req.getContextPath() + "/sheller/dangChoNghi/tienIch");
		}
		if (url.contains("/sheller/tienIch")) {
			
			HttpSession session = req.getSession();
			
			List<TienIchModel> listTienIch = new ArrayList<>();
			String atm = req.getParameter("atm");
			if (atm != null) {
				listTienIch.add(new TienIchModel("Máy ATM/Ngân hàng", 0, 1));
			}
			String thammyvien = req.getParameter("thammyvien");
			if (thammyvien != null) {
				listTienIch.add(new TienIchModel("Thẩm mỹ viện", 0, 1));
			}
			String CHthucpham = req.getParameter("CHthucpham");
			if (CHthucpham != null) {
				listTienIch.add(new TienIchModel("Cửa hàng thực phẩm", 0, 1));
			}
			String Giatui = req.getParameter("Giatui");
			if (Giatui != null) {
				listTienIch.add(new TienIchModel("Giặt ủi", 0, 1));
			}
			String sieuthi = req.getParameter("sieuthi");
			if (sieuthi != null) {
				listTienIch.add(new TienIchModel("Siêu thị", 0, 1));
			}

			String receptiondesk = req.getParameter("reception-desk");
			if (receptiondesk != null) {
				listTienIch.add(new TienIchModel("Quầy lễ tân", 0,3));
			}
			String DVGiatui = req.getParameter("DVGiatui");
			if (DVGiatui != null) {
				listTienIch.add(new TienIchModel("Dịch vụ giặt ủi", 0, 3));
			}
			String luuTruHanhLy = req.getParameter("luuTruHanhLy");
			if (luuTruHanhLy != null) {
				listTienIch.add(new TienIchModel("Dịch vụ lưu trữ/bảo quản hành lý", 0, 3));
			}
			String tour_assistance = req.getParameter("tour-assistance");
			if (tour_assistance != null) {
				listTienIch.add(new TienIchModel("Dịch vụ hỗ trợ đặt tour", 0, 3));
			}
			String leTan24h = req.getParameter("leTan24h");
			if (leTan24h != null) {
				listTienIch.add(new TienIchModel("Lễ tân 24h", 0, 3));
			}
			
			String duadonsanbay = req.getParameter("duadonsanbay");
			if (duadonsanbay != null) {
				listTienIch.add(new TienIchModel("Đưa đón sân bay", 0, 4));
			}
			String thuexehoi = req.getParameter("thuexehoi");
			if (thuexehoi != null) {
				listTienIch.add(new TienIchModel("Cho thuê xe hơi", 0, 4));
			}
			String baidauxe = req.getParameter("baidauxe");
			if (baidauxe != null) {
				listTienIch.add(new TienIchModel("Bãi đậu xe", 0, 4));
			}
			
			String nhahang = req.getParameter("nhahang");
			if (nhahang != null) {
				listTienIch.add(new TienIchModel("Nhà hàng", 0, 5));
			}
			String wifi = req.getParameter("wifi");
			if (wifi != null) {
				listTienIch.add(new TienIchModel("WiFi tại khu vực chung", 0, 5));
			}
			String elevator = req.getParameter("elevator");
			if (elevator != null) {
				listTienIch.add(new TienIchModel("Thang máy", 0, 5));
			}
			
			String maylanh = req.getParameter("maylanh");
			if (maylanh != null) {
				listTienIch.add(new TienIchModel("Máy lạnh", 0, 6));
			}
			String phonggd = req.getParameter("phonggd");
			if (phonggd != null) {
				listTienIch.add(new TienIchModel("Phòng gia đình", 0, 6));
			}
			
			String restaurantmeal = req.getParameter("restaurant-meal");
			if (restaurantmeal != null) {
				listTienIch.add(new TienIchModel("Bữa sáng", 0, 7));
			}
			String quaybar = req.getParameter("quaybar");
			if (quaybar != null) {
				listTienIch.add(new TienIchModel("Quầy bar", 0, 7));
			}
			
			String wififree = req.getParameter("wififree");
			if (wififree != null) {
				listTienIch.add(new TienIchModel("Wifi (miễn phí)", 0, 8));
			}
			session.setAttribute("listTienIch", listTienIch);
			resp.sendRedirect(req.getContextPath() + "/sheller/dangChoNghi/anhKS");
		}
		if(url.contains("/sheller/anhKS")) {
			
			HttpSession session = req.getSession();
			KhachSanModel ks = (KhachSanModel)session.getAttribute("ks");

			List<TienIchModel> listTienIch = (List<TienIchModel>)session.getAttribute("listTienIch");
			List<AnhKhachSanModel> listAnhKS = new ArrayList<AnhKhachSanModel>();
			
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			
			try {
				for (int i = 1; i <= 7; i++) {
					Part part = req.getPart("image" + i);
					if (part.getSize() > 0) {
						String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			            String ext = filename.substring(filename.lastIndexOf(".") + 1);
			            fname = System.currentTimeMillis() + "_" + i + "." + ext; // Unique filename with timestamp and index
			           
			            part.write(uploadPath + File.separator + fname);
			            // Optional: Log or save `fname` in the database if needed
			            if (i == 1) {
			                listAnhKS.add(new AnhKhachSanModel("AnhChinh", fname, 0));
			            }
			            else {
			            	listAnhKS.add(new AnhKhachSanModel("Anhphu"+i, fname, 0));
			            }
					}
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			if (ks != null && listTienIch != null && listAnhKS != null) {
				
				khachSanService.insert(ks);
				
				for (TienIchModel tienIch : listTienIch) {
					int idKS = khachSanService.maxId();
				    tienIch.setIdKhachSan(idKS); // Đặt ID khách sạn thực tế cho mỗi tiện ích
				}
				for (AnhKhachSanModel anhks : listAnhKS) {
					int idKS = khachSanService.maxId();
				    anhks.setIdKhachSan(idKS); // Đặt ID khách sạn thực tế cho mỗi ảnh
				}
				
				for (TienIchModel tienIch : listTienIch) {
					tienIchService.insert(tienIch);
				}
				
				for (AnhKhachSanModel anhks : listAnhKS) {
					anhKhachSanService.insert(anhks);
				}
				
				
			}
			
			req.setAttribute("isSuccess", true);
			req.getRequestDispatcher("/views/sheller/dangChoNghiAnhKS.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/phong")) {
			HttpSession session = req.getSession();
			String tenPhong = req.getParameter("tenphong");
			int kichthuoc = Integer.parseInt(req.getParameter("kichthuoc"));
			String mota = req.getParameter("mota");
			int soluongnguoi = Integer.parseInt(req.getParameter("soluongnguoi"));
			String singleBedCount = req.getParameter("singleBedCount");
			String doubleBedCount = req.getParameter("doubleBedCount");
			String kingBedCount = req.getParameter("kingBedCount");
			String superkingBedCount = req.getParameter("superkingBedCount");
			int slphong = Integer.parseInt(req.getParameter("slphong"));
			int giathue = Integer.parseInt(req.getParameter("giathue"));
			int idKS = 0;
			String idKSStr = (String)session.getAttribute("idKSStr");
			if (idKSStr != null) {
				idKS = Integer.parseInt(idKSStr);
			}
			else {
				idKS = khachSanService.maxId();
			}
			String tienNghi = "";
			if (!"0".equals(singleBedCount)) {
				tienNghi = tienNghi + singleBedCount + " Giường đơn,"; 
			}
			if (!"0".equals(doubleBedCount)) {
				tienNghi = tienNghi + doubleBedCount + " Giường đôi,"; 
			}
			if (!"0".equals(kingBedCount)) {
				tienNghi = tienNghi + kingBedCount + " Giường lớn(cỡ King),"; 
			}
			if (!"0".equals(superkingBedCount)) {
				tienNghi = tienNghi + superkingBedCount + " Giường cực lớn(cỡ Super-King),"; 
			}
			System.out.println (tenPhong + " " + kichthuoc + " " + mota
					+ " " + soluongnguoi + " " + singleBedCount + " " + doubleBedCount
					+ " " + kingBedCount + " " + superkingBedCount + " " 
					+ slphong + " " + giathue + "     " + tienNghi);
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			try {
				Part part = req.getPart("imageUpload");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					System.out.println ("Anh của phòng1: " + filename);
					part.write(uploadPath + "/" + fname);

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String tv = req.getParameter("tv");
			if (tv != null) {
				tienNghi = tienNghi + "TV màn hình phẳng,"; 
			}
			String dieuhoa = req.getParameter("dieuhoa");
			if (dieuhoa != null) {
				tienNghi = tienNghi + "Điều hòa không khí,"; 
			}
			String banlamviec = req.getParameter("banlamviec");
			if (banlamviec != null) {
				tienNghi = tienNghi + "Bàn làm việc,"; 
			}
			String tudequanao = req.getParameter("tudequanao");
			if (tudequanao != null) {
				tienNghi = tienNghi + "Tủ hoặc phòng để quần áo,"; 
			}
			String hethongsuu = req.getParameter("hethongsuu");
			if (hethongsuu != null) {
				tienNghi = tienNghi + "Hệ thống sưởi,"; 
			}
			String quatmay = req.getParameter("quatmay");
			if (quatmay != null) {
				tienNghi = tienNghi + "Quạt máy,"; 
			}
			String ketantoan = req.getParameter("ketantoan");
			if (ketantoan != null) {
				tienNghi = tienNghi + "Két an toàn,"; 
			}
			String khantamvstaigiuong = req.getParameter("khantamvstaigiuong");
			if (khantamvstaigiuong != null) {
				tienNghi = tienNghi + "Khăn tắm/Đồ vệ sinh tại giường,"; 
			}
			
			String bancong = req.getParameter("bancong");
			if (bancong != null) {
				tienNghi = tienNghi + "Ban công,"; 
			}
			String sanhien = req.getParameter("sanhien");
			if (sanhien != null) {
				tienNghi = tienNghi + "Sân hiên,"; 
			}
			String tamnhinrakhungcanh = req.getParameter("tamnhinrakhungcanh");
			if (tamnhinrakhungcanh != null) {
				tienNghi = tienNghi + "Tầm nhìn ra khung cảnh,"; 
			}
			
			String amdunnuoc = req.getParameter("amdunnuoc");
			if (amdunnuoc != null) {
				tienNghi = tienNghi + "Ấm đun nước điện,"; 
			}
			String maypha = req.getParameter("maypha");
			if (maypha != null) {
				tienNghi = tienNghi + "Máy pha trà/cà phê,"; 
			}
			String banan = req.getParameter("banan");
			if (banan != null) {
				tienNghi = tienNghi + "Bàn ăn,"; 
			}
			String mlovisong = req.getParameter("lovisong");
			if (mlovisong != null) {
				tienNghi = tienNghi + "Lò vi sóng,"; 
			}
			System.out.println ("anh cua phong: " + fname);
			phongService.insert(new PhongModel(tenPhong, kichthuoc, giathue, tienNghi, mota, 0, idKS, slphong, 0, soluongnguoi, fname));
			req.setAttribute("isSuccess", true);
			req.getRequestDispatcher("/views/sheller/dangChoNghiPhong.jsp").forward(req, resp);
		}
	}
}
