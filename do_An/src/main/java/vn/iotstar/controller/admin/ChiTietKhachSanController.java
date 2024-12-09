package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IThongBaoService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.ThongBaoServiceImpl;
import vn.iotstar.services.impl.TienIchServiceImpl;

@WebServlet(urlPatterns = {"/admin/chiTietKS/thongTinKhachSan","/admin/chiTietKS/tienIch","/admin/chiTietKS/anhKhachSan","/admin/chiTietKS/phongKhachSan"})
public class ChiTietKhachSanController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	public ITienIchService tienIchService = new TienIchServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	public IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
		}
		session.setAttribute("account", user);
		List<ThongBaoModel> listThongBao = thongBaoService.listFindByIdUser(user.getId());
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
		if (url.contains("/admin/chiTietKS/thongTinKhachSan")) {
			KhachSanModel ks = khachSanService.findById(idKS);
			List <PhongModel> listPhong = phongService.findByIdKhachSan(idKS);
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listPhong", listPhong);
			session.setAttribute("listPhong", listPhong);
			req.setAttribute("ks", ks);
			req.getRequestDispatcher("/views/admin/chiTietThongTinKS.jsp").forward(req, resp);
		}
		if (url.contains("/admin/chiTietKS/tienIch")) {
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
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listPhong", listPhong);
			req.getRequestDispatcher("/views/admin/chiTietTienNghi.jsp").forward(req, resp);
		}
		if (url.contains("/admin/chiTietKS/anhKhachSan")) {
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
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
			req.setAttribute("listPhong", listPhong);
			req.getRequestDispatcher("/views/admin/chiTietAnhKhachSan.jsp").forward(req, resp);
		}
		if (url.contains("/admin/chiTietKS/phongKhachSan")) {
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
			int soLuongThongBao = listThongBao.size();
			req.setAttribute("slthongbao", soLuongThongBao);
			req.setAttribute("listthongbao", listThongBao);
			req.setAttribute("username", user.getFullname());
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
			req.getRequestDispatcher("/views/admin/chiTietPhong.jsp").forward(req, resp);
		}
	}

}
