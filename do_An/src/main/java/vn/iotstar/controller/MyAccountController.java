package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.models.KhuyenMaiModel;
import vn.iotstar.models.LichSuModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.ThichKhachSanModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IDiaDiemService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IKhuyenMaiService;
import vn.iotstar.services.ILichSuDatPhongService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IThichKhachSanService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.DiaDiemServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.KhuyenMaiServiceImpl;
import vn.iotstar.services.impl.LichSuDatPhongServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.ThichKhachSanServiceImpl;
import vn.iotstar.services.impl.TienIchServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.AESUtil;

@WebServlet(urlPatterns = {"/myAccount","/myAccount/trangCaNhan","/myAccount/lichSuDatPhong","/myAccount/danhsachksyeuthich"})
public class MyAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ILichSuDatPhongService lichSuService = new LichSuDatPhongServiceImpl();
	public IUserServices userService = new UserServiceImpl();
	public ILoaiKhachSanService loaiKhachSanService = new LoaiKhachSanServiceImpl();
	public IDiaDiemService diaDiemService = new DiaDiemServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	public ITienIchService tienIchService = new TienIchServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	public IKhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
	public IThichKhachSanService thichKhachSanService = new ThichKhachSanServiceImpl();
	Map<Integer, List<AnhKhachSanModel>> anhMap = new HashMap<>();
    Map<Integer, List<TienIchModel>> tienIchMap = new HashMap<>();
    Map<Integer, List<PhongModel>> phongMap = new HashMap<>();
    Map<Integer, List<KhuyenMaiModel>> khyenMaiMap = new HashMap<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		//UserModel taiKhoan = (UserModel) session.getAttribute("account");
		UserModel taiKhoan = null;
		if (url.contains("/myAccount/trangCaNhan")) 
		{
			String username = null;
			if (session != null && session.getAttribute("account") != null) {
				UserModel user = (UserModel) session.getAttribute("account");
				username = user.getFullname();
				taiKhoan = user;
			}	
			if (taiKhoan != null) {
				req.setAttribute("username", username);
				session.setAttribute("currentURL", req.getContextPath().toString() + "/myAccount/trangCaNhan");
				req.setAttribute("ten", taiKhoan.getUsername());
				req.setAttribute("hovaten", taiKhoan.getFullname());
				req.setAttribute("ngaysinh", taiKhoan.getCreatedDate());
				req.setAttribute("gioitinh", taiKhoan.getGender());
				req.setAttribute("email", taiKhoan.getEmail());
				req.setAttribute("dienthoai", taiKhoan.getPhone());
				req.setAttribute("diaChi", taiKhoan.getDiaChi());
				
				String encryptedPassword = taiKhoan.getPassword();
				String decryptedPassword = null;
				try {
					decryptedPassword = AESUtil.decrypt(encryptedPassword);
				} catch (Exception e) {
					e.printStackTrace();
				}
				req.setAttribute("matkhau", decryptedPassword);
				req.getRequestDispatcher("/views/caNhan.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
			}
		}
		if (url.contains("/myAccount/lichSuDatPhong")) 
		{
			String username = null;
			UserModel user = (UserModel) session.getAttribute("account");
			if (session != null && session.getAttribute("account") != null) {
				username = user.getFullname();
				taiKhoan = user;
			}
			req.setAttribute("username", username);
			
			int currentPage = 1;
            if (req.getParameter("page") != null) {
                currentPage = Integer.parseInt(req.getParameter("page"));
            }
            
            List <LichSuModel> listLichSu = lichSuService.findAll(currentPage, taiKhoan.getId());
            int countLS = lichSuService.countAll(taiKhoan.getId());
        	int endPage = countLS/5;
        	if (countLS % 5 != 0) {
        		endPage ++;
        	}
        	req.setAttribute("currentPage", currentPage);
        	req.setAttribute("countKS", countLS);
        	req.setAttribute("endPage", endPage);
            
			session.setAttribute("idKhachHang", taiKhoan.getId());
			System.out.println (taiKhoan.getId());
			session.setAttribute("currentURL", req.getContextPath().toString() + "/myAccount/lichSuDatPhong");
			req.setAttribute("listLichSu", listLichSu);
			req.getRequestDispatcher("/views/lichSuDatPhong.jsp").forward(req, resp);	
		}
		if (url.contains("/myAccount/danhsachksyeuthich")) 
		{			
			String username = null;
			int idUser = 0;
			if (session != null && session.getAttribute("account") != null) {
				UserModel user = (UserModel) session.getAttribute("account");
				username = user.getFullname();
				idUser = user.getId();
				session.setAttribute("account", user);
			}
			req.setAttribute("username", username);
			
			//List<ThichKhachSanModel> listThichKhachSan = thichKhachSanService.listLikeHotel(idUser);
		    
			int currentPage = 1;
            if (req.getParameter("page") != null) {
                currentPage = Integer.parseInt(req.getParameter("page"));
            }
            
            List<ThichKhachSanModel> listThichKhachSan = thichKhachSanService.findAll(currentPage, idUser);
        	int countKS = thichKhachSanService.countAll(idUser);
        	int endPage = countKS/5;
        	if (countKS % 5 != 0) {
        		endPage ++;
        	}
        	req.setAttribute("currentPage", currentPage);
        	req.setAttribute("countKS", countKS);
        	req.setAttribute("endPage", endPage);
        	
	        for (ThichKhachSanModel thicKhachSan : listThichKhachSan) {
	            List<AnhKhachSanModel> listAnh = anhKhachSanService.findByIdKhachSan(thicKhachSan.getIdKS());
	            anhMap.put(thicKhachSan.getIdKS(), listAnh);
	            
	            List<TienIchModel> listTienIch = tienIchService.findByIdKhachSan(thicKhachSan.getIdKS());
	            tienIchMap.put(thicKhachSan.getIdKS(), listTienIch);
	            for (TienIchModel tienich : listTienIch) {
	            	System.out.println ("id tien ich: " + tienich.getId() + " ten tien ich: " + tienich.getTenTienNghi());
	            }
	            
	            List<PhongModel> listPhong = phongService.phongMinByIdKhachSan(thicKhachSan.getIdKS());
	            phongMap.put(thicKhachSan.getIdKS(), listPhong);
	            
	            List<KhuyenMaiModel> listKhuyenMai = khuyenMaiService.findByIdKhachSan(thicKhachSan.getIdKS());
	            khyenMaiMap.put(thicKhachSan.getIdKS(), listKhuyenMai);
	            for (KhuyenMaiModel khuyenMai : listKhuyenMai) {
	            	System.out.println (thicKhachSan.getIdKS() + "tên khuyến mãi: " + khuyenMai.getTen());
	            }
	        }
	  
	        req.setAttribute("anhMap", anhMap);
	        req.setAttribute("tienIchMap", tienIchMap);
	        req.setAttribute("phongMap", phongMap);
	        req.setAttribute("khyenMaiMap", khyenMaiMap);
	        
	        req.setAttribute("listThichKhachSan", listThichKhachSan);
	        
	        session.setAttribute("tienThueMoiKS", phongMap);
	        String[] strDanhGia = {"Bình thường", "Khá ổn", "Chất lượng", "Sang trọng", "Tuyệt vời", "Xuất sắc"};
	        req.setAttribute("strDanhGia", strDanhGia);
	        
	        req.getRequestDispatcher("/views/danhSachKSYeuThich.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ten = req.getParameter("ten");
		String hovaten = req.getParameter("hovaten");
		String ngaysinh = req.getParameter("ngaysinh");
		String gioitinh = req.getParameter("gioitinh");
		String email = req.getParameter("email");
		String dienthoai = req.getParameter("dienthoai");
		String diachi = req.getParameter("diachi");
		String matkhau = req.getParameter("matkhau");
		
		HttpSession session = req.getSession();
		UserModel taiKhoan = (UserModel) session.getAttribute("account");
		session.setAttribute("idUser", taiKhoan.getId());
		
		Date createdDate = null;
		try {
			createdDate = Date.valueOf(ngaysinh);
		} catch (IllegalArgumentException e) {
			return;
		}
		String encryptedPassword = null;
		try {
			encryptedPassword = AESUtil.encrypt(matkhau);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println (ten + " " + hovaten + " " + ngaysinh + gioitinh + email 
				+ dienthoai + diachi + matkhau);
		userService.update(new UserModel(taiKhoan.getId(),ten,hovaten,createdDate,gioitinh,email,dienthoai,diachi,encryptedPassword,1,true));	
	}
}
