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
import vn.iotstar.models.DiaDiemModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IDiaDiemService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.DiaDiemServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.TienIchServiceImpl;
import vn.iotstar.utils.Constant;

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 8,  // Tăng giới hạn của mỗi file lên 8MB nếu cần
	    maxRequestSize = 1024 * 1024 * 40  // Tăng tổng kích thước tối đa của yêu cầu lên 40MB
	)
@WebServlet(urlPatterns = {"/sheller/suaChoNghi/ThongTinCoBan","/sheller/sua/thongTinCoBan", 
		"/sheller/suaChoNghi/tienIch", "/sheller/sua/tienIch",
		"/sheller/suaChoNghi/anhKhachSan", "/sheller/sua/anhKS",
		"/sheller/suaChoNghi/phong", "/sheller/sua/phong"})
public class suaChoNghiController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ILoaiKhachSanService loaiKSService = new LoaiKhachSanServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public ITienIchService tienIchService = new TienIchServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	public IPhongService phongService = new PhongServiceImpl(); 
	public IDiaDiemService thanhPhoService = new DiaDiemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		int idKS = 0;
		String id = req.getParameter("id");
		if (id == null) {
		    Object idKSObj = session.getAttribute("idKS");
		    if (idKSObj != null) {
		    	idKS = Integer.parseInt((String) idKSObj);
		    }
		} else {
			idKS = Integer.parseInt(id);
		    session.setAttribute("idKS", String.valueOf(id));
		}
		
		if (url.contains("/sheller/suaChoNghi/ThongTinCoBan")) {
			KhachSanModel ks = khachSanService.findById(idKS);
			List <PhongModel> listPhong = phongService.findByIdKhachSan(idKS);
			req.setAttribute("listPhong", listPhong);
			session.setAttribute("listPhong", listPhong);
			req.setAttribute("ks", ks);
			req.getRequestDispatcher("/views/sheller/suaThongTinKS.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/suaChoNghi/tienIch")) {
			List<TienIchModel> listTienIch = tienIchService.findByIdKhachSan(idKS);
			for (TienIchModel tienIch : listTienIch) {
				if (tienIch.getTenTienNghi().equals("Máy ATM/Ngân hàng")) {
					req.setAttribute("atm", true);
				}
				if (tienIch.getTenTienNghi().equals("Thẩm mỹ viện")) {
					req.setAttribute("thammyvien", true);
				}
				if (tienIch.getTenTienNghi().equals("Cửa hàng thực phẩm")) {
					req.setAttribute("CHthucpham", true);
				}
				if (tienIch.getTenTienNghi().equals("Giặt ủi")) {
					req.setAttribute("Giatui", true);
				}
				if (tienIch.getTenTienNghi().equals("Siêu thị")) {
					req.setAttribute("sieuthi", true);
				}
				
				if (tienIch.getTenTienNghi().equals("Quầy lễ tân")) {
					req.setAttribute("reception_desk", true);
				}
				if (tienIch.getTenTienNghi().equals("Dịch vụ giặt ủi")) {
					req.setAttribute("DVGiatui", true);
				}
				if (tienIch.getTenTienNghi().equals("Dịch vụ lưu trữ/bảo quản hành lý")) {
					req.setAttribute("luuTruHanhLy", true);
				}
				if (tienIch.getTenTienNghi().equals("Dịch vụ hỗ trợ đặt tour")) {
					req.setAttribute("tour_assistance", true);
				}
				if (tienIch.getTenTienNghi().equals("Lễ tân 24h")) {
					req.setAttribute("leTan24h", true);
				}
				
				if (tienIch.getTenTienNghi().equals("Đưa đón sân bay")) {
					req.setAttribute("duadonsanbay", true);
				}
				if (tienIch.getTenTienNghi().equals("Cho thuê xe hơi")) {
					req.setAttribute("thuexehoi", true);
				}
				if (tienIch.getTenTienNghi().equals("Bãi đậu xe")) {
					req.setAttribute("baidauxe", true);
				}
				
				if (tienIch.getTenTienNghi().equals("Nhà hàng")) {
					req.setAttribute("nhahang", true);
				}
				if (tienIch.getTenTienNghi().equals("WiFi tại khu vực chung")) {
					req.setAttribute("wifi", true);
				}
				if (tienIch.getTenTienNghi().equals("Thang máy")) {
					req.setAttribute("elevator", true);
				}
				
				if (tienIch.getTenTienNghi().equals("Máy lạnh")) {
					req.setAttribute("maylanh", true);
				}
				if (tienIch.getTenTienNghi().equals("Phòng gia đình")) {
					req.setAttribute("phonggd", true);
				}
				
				if (tienIch.getTenTienNghi().equals("Bữa sáng")) {
					req.setAttribute("buasang", true);
				}
				if (tienIch.getTenTienNghi().equals("Quầy bar")) {
					req.setAttribute("quaybar", true);
				}
				
				if (tienIch.getTenTienNghi().equals("Wifi (miễn phí)")) {
					req.setAttribute("wififree", true);
				}
			}
			List<PhongModel> listPhong = (List<PhongModel>) session.getAttribute("listPhong");
			req.setAttribute("listPhong", listPhong);
			req.getRequestDispatcher("/views/sheller/suaTienNghiKS.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/suaChoNghi/anhKhachSan")) {
			List<AnhKhachSanModel> listAnhKS = anhKhachSanService.findByIdKhachSan(idKS);
			int i = 2;
			for (AnhKhachSanModel anhKS: listAnhKS) {
				if(anhKS.getVaiTroCuaAnh().equals("AnhChinh")) {
					req.setAttribute("image1", anhKS.getUrlAnhKhachSan());
				}
				else {
					req.setAttribute("image"+i, anhKS.getUrlAnhKhachSan());
					i++;
				}
				
			}
			List<PhongModel> listPhong = (List<PhongModel>) session.getAttribute("listPhong");
			req.setAttribute("listPhong", listPhong);
			req.getRequestDispatcher("/views/sheller/suaAnhKS.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/suaChoNghi/phong")) {
			int idPhong = 0;
			String idP = req.getParameter("idPhong");
			if (idP == null) {
			    Object idPObj = session.getAttribute("idPhong1");
			    if (idPObj != null) {
			    	idPhong = Integer.parseInt((String) idPObj);
			    }
			} else {
				idPhong = Integer.parseInt(idP);
			    session.setAttribute("idPhong1", String.valueOf(idP));
			}
			
			PhongModel phong = phongService.findById(idPhong);
			String[] amenities = phong.getTienNghi().split(",");
			String singleBedCount = null;
			String doubleBedCount = null;
			String kingBedCount = null;
			String superkingBedCount = null;
			for (String amenity : amenities) {
	            amenity = amenity.trim();
	            if (amenity.contains("Giường đơn")) {
	                String[] parts = amenity.split(" ");
	                if (parts.length > 0) {
	                	singleBedCount = parts[0];
	                }
	            }
	            if (amenity.contains("Giường đôi")) {
	                String[] parts = amenity.split(" ");
	                if (parts.length > 0) {
	                	doubleBedCount = parts[0];
	                }
	            }
	            if (amenity.contains("Giường lớn(cỡ King)")) {
	                String[] parts = amenity.split(" ");
	                if (parts.length > 0) {
	                	kingBedCount = parts[0];
	                }
	            }
	            if (amenity.contains("Giường cực lớn(cỡ Super-King)")) {
	                String[] parts = amenity.split(" ");
	                if (parts.length > 0) {
	                	superkingBedCount = parts[0];
	                }
	            }
	            
	            if (amenity.contains("TV màn hình phẳng")) {
	            	req.setAttribute("tv", true);
	            }
	            if (amenity.contains("Điều hòa không khí")) {
	            	req.setAttribute("dieuhoa", true);
	            }
	            if (amenity.contains("Bàn làm việc")) {
	            	req.setAttribute("banlamviec", true);
	            }
	            if (amenity.contains("Tủ hoặc phòng để quần áo")) {
	            	req.setAttribute("tudequanao", true);
	            }
	            if (amenity.contains("Hệ thống sưởi")) {
	            	req.setAttribute("hethongsuu", true);
	            }
	            if (amenity.contains("Quạt máy")) {
	            	req.setAttribute("quatmay", true);
	            }
	            if (amenity.contains("Két an toàn")) {
	            	req.setAttribute("ketantoan", true);
	            }
	            if (amenity.contains("Khăn tắm/Đồ vệ sinh tại giường")) {
	            	req.setAttribute("khantamvstaigiuong", true);
	            }
	            
	            if (amenity.contains("Ban công")) {
	            	req.setAttribute("bancong", true);
	            }
	            if (amenity.contains("Sân hiên")) {
	            	req.setAttribute("sanhien", true);
	            }
	            if (amenity.contains("Tầm nhìn ra khung cảnh")) {
	            	req.setAttribute("tamnhinrakhungcanh", true);
	            }
	            
	            if (amenity.contains("Ấm đun nước điện")) {
	            	req.setAttribute("amdunnuoc", true);
	            }
	            if (amenity.contains("Máy pha trà/cà phê")) {
	            	req.setAttribute("maypha", true);
	            }
	            if (amenity.contains("Bàn ăn")) {
	            	req.setAttribute("banan", true);
	            }
	            if (amenity.contains("Lò vi sóng")) {
	            	req.setAttribute("lovisong", true);
	            }   
	        }
			req.setAttribute("singleBedCount", singleBedCount);
			req.setAttribute("doubleBedCount", doubleBedCount);
			req.setAttribute("kingBedCount", kingBedCount);
			req.setAttribute("superkingBedCount", superkingBedCount);
			req.setAttribute("tenphong", phong.getTen());
			req.setAttribute("kichthuoc", phong.getDienTich());
			req.setAttribute("mota", phong.getMoTa());
			req.setAttribute("slphong", phong.getSoPhongTrong());
			req.setAttribute("giathue", phong.getGiaThue());
			req.setAttribute("soluongnguoi", phong.getSucChuaToiDa());
			req.setAttribute("imageUpload", phong.getAnhPhong());
			List<PhongModel> listPhong = (List<PhongModel>) session.getAttribute("listPhong");
			req.setAttribute("listPhong", listPhong);
			req.getRequestDispatcher("/views/sheller/suaPhongKS.jsp").forward(req, resp);
		}	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if (url.contains("/sheller/sua/thongTinCoBan")) {
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
			int idKS = 0;
			Object idKSObj = session.getAttribute("idKS");
		    if (idKSObj != null) {
		    	idKS = Integer.parseInt((String) idKSObj);
		    }
			KhachSanModel ks = new KhachSanModel(idKS, tenKS, diaChi, idUser, cachTT, moTa, giapBien, danhGia, idDiaDiem, tenDiaDiem, idLoaiKS, tenLoaiKS, null);
			
			//session.setAttribute("ks", ks);
			khachSanService.update(ks);
			req.setAttribute("isSuccess", true);
			req.getRequestDispatcher("/views/sheller/suaThongTinKS.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/sua/tienIch")) {
			
			HttpSession session = req.getSession();
			
			List<TienIchModel> listTienIch = new ArrayList<>();
			
			int idKS = 0;
			Object idKSObj = session.getAttribute("idKS");
		    if (idKSObj != null) {
		    	idKS = Integer.parseInt((String) idKSObj);
		    }
			String atm = req.getParameter("atm");
			if (atm != null) {
				listTienIch.add(new TienIchModel("Máy ATM/Ngân hàng", idKS, 1));
			}
			String thammyvien = req.getParameter("thammyvien");
			if (thammyvien != null) {
				listTienIch.add(new TienIchModel("Thẩm mỹ viện", idKS, 1));
			}
			String CHthucpham = req.getParameter("CHthucpham");
			if (CHthucpham != null) {
				listTienIch.add(new TienIchModel("Cửa hàng thực phẩm", idKS, 1));
			}
			String Giatui = req.getParameter("Giatui");
			if (Giatui != null) {
				listTienIch.add(new TienIchModel("Giặt ủi", idKS, 1));
			}
			String sieuthi = req.getParameter("sieuthi");
			if (sieuthi != null) {
				listTienIch.add(new TienIchModel("Siêu thị", idKS, 1));
			}

			String receptiondesk = req.getParameter("reception-desk");
			if (receptiondesk != null) {
				listTienIch.add(new TienIchModel("Quầy lễ tân", idKS, 3));
			}
			String DVGiatui = req.getParameter("DVGiatui");
			if (DVGiatui != null) {
				listTienIch.add(new TienIchModel("Dịch vụ giặt ủi", idKS, 3));
			}
			String luuTruHanhLy = req.getParameter("luuTruHanhLy");
			if (luuTruHanhLy != null) {
				listTienIch.add(new TienIchModel("Dịch vụ lưu trữ/bảo quản hành lý", idKS, 3));
			}
			String tour_assistance = req.getParameter("tour-assistance");
			if (tour_assistance != null) {
				listTienIch.add(new TienIchModel("Dịch vụ hỗ trợ đặt tour", idKS, 3));
			}
			String leTan24h = req.getParameter("leTan24h");
			if (leTan24h != null) {
				listTienIch.add(new TienIchModel("Lễ tân 24h", idKS, 3));
			}
			
			String duadonsanbay = req.getParameter("duadonsanbay");
			if (duadonsanbay != null) {
				listTienIch.add(new TienIchModel("Đưa đón sân bay", idKS, 4));
			}
			String thuexehoi = req.getParameter("thuexehoi");
			if (thuexehoi != null) {
				listTienIch.add(new TienIchModel("Cho thuê xe hơi", idKS, 4));
			}
			String baidauxe = req.getParameter("baidauxe");
			if (baidauxe != null) {
				listTienIch.add(new TienIchModel("Bãi đậu xe", idKS, 4));
			}
			
			String nhahang = req.getParameter("nhahang");
			if (nhahang != null) {
				listTienIch.add(new TienIchModel("Nhà hàng", idKS, 5));
			}
			String wifi = req.getParameter("wifi");
			if (wifi != null) {
				listTienIch.add(new TienIchModel("WiFi tại khu vực chung", idKS, 5));
			}
			String elevator = req.getParameter("elevator");
			if (elevator != null) {
				listTienIch.add(new TienIchModel("Thang máy", idKS, 5));
			}
			
			String maylanh = req.getParameter("maylanh");
			if (maylanh != null) {
				listTienIch.add(new TienIchModel("Máy lạnh", idKS, 6));
			}
			String phonggd = req.getParameter("phonggd");
			if (phonggd != null) {
				listTienIch.add(new TienIchModel("Phòng gia đình", idKS, 6));
			}
			
			String restaurantmeal = req.getParameter("restaurant-meal");
			if (restaurantmeal != null) {
				listTienIch.add(new TienIchModel("Bữa sáng", idKS, 7));
			}
			String quaybar = req.getParameter("quaybar");
			if (quaybar != null) {
				listTienIch.add(new TienIchModel("Quầy bar", idKS, 7));
			}
			
			String wififree = req.getParameter("wififree");
			if (wififree != null) {
				listTienIch.add(new TienIchModel("Wifi (miễn phí)", idKS, 8));
			}
			tienIchService.deleteByIdKhachSan(idKS);
			for (TienIchModel tienIch : listTienIch) {
				tienIchService.insert(tienIch);
			}
			req.setAttribute("isSuccess", true);
			req.getRequestDispatcher("/views/sheller/suaTienNghiKS.jsp").forward(req, resp);
		}	
		if(url.contains("/sheller/sua/anhKS")) {
			
			HttpSession session = req.getSession();
			
			int idKS = 0;
			Object idKSObj = session.getAttribute("idKS");
		    if (idKSObj != null) {
		    	idKS = Integer.parseInt((String) idKSObj);
		    }
			List<AnhKhachSanModel> listAnhKS = new ArrayList<AnhKhachSanModel>();
			
			String fname = "";
			String uploadPath = Constant.DIR;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			
			try {
				for (int i = 1; i <= 7; i++) {
					Part part = req.getPart("image" + i);
					if (part.getSize() > 0 && part != null) {
						String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			            String ext = filename.substring(filename.lastIndexOf(".") + 1);
			            fname = System.currentTimeMillis() + "_" + i + "." + ext; // Unique filename with timestamp and index
			           
			            part.write(uploadPath + File.separator + fname);
			            // Optional: Log or save `fname` in the database if needed
			            if (i == 1) {
			                listAnhKS.add(new AnhKhachSanModel("AnhChinh", fname, idKS));
			            }
			            else {
			            	listAnhKS.add(new AnhKhachSanModel("Anhphu"+i, fname, idKS));
			            }
			            System.out.println("Có vào đây");
					}else {
						String fileName = req.getParameter("image" + i + "Url");
						String result = fileName.replace("/do_An/image?fname=", "");
						if (i == 1) {
			                listAnhKS.add(new AnhKhachSanModel("AnhChinh", result, idKS));
			            }
			            else {
			            	listAnhKS.add(new AnhKhachSanModel("Anhphu"+i, result, idKS));
			            }
					}
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			anhKhachSanService.deleteByIdKhachSan(idKS);
			
			 for (AnhKhachSanModel anhks : listAnhKS) { 
				 anhKhachSanService.insert(anhks);
				 System.out.println ("Vai trò: " + anhks.getVaiTroCuaAnh() + " URL: " + anhks.getUrlAnhKhachSan());
			 }
			 
			req.setAttribute("isSuccess", true);
			req.getRequestDispatcher("/views/sheller/suaAnhKS.jsp").forward(req, resp);
		}
		if (url.contains("/sheller/sua/phong")) {
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
			
			HttpSession session = req.getSession();
			int idPhong = 0;
			Object idPObj = session.getAttribute("idPhong1");
		    if (idPObj != null) {
		    	idPhong = Integer.parseInt((String) idPObj);
		    }
		    int idKS = 0;
			Object idKSObj = session.getAttribute("idKS");
		    if (idKSObj != null) {
		    	idKS = Integer.parseInt((String) idKSObj);
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

					part.write(uploadPath + "/" + fname);

				}
				else {
					String fileName = req.getParameter("imageUploadUrl");
					fname = fileName.replace("/do_An/image?fname=", "");

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
			
			PhongModel phong = phongService.findById(idPhong);
			System.out.println ("Id phòng: " + idPhong );
			
			phongService.update(new PhongModel(idPhong, tenPhong, kichthuoc, giathue,tienNghi, mota, 0, idKS, slphong, phong.getSoPhongDaDat(), soluongnguoi,fname)); 
			req.setAttribute("idPhong", idPhong); 
			req.setAttribute("isSuccess",true); 
			req.getRequestDispatcher("/views/sheller/suaPhongKS.jsp").forward(req,resp);
			 
		}
	}
}