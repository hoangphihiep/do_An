package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.DatPhongModel;
import vn.iotstar.models.GiamGiaModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IDatPhongService;
import vn.iotstar.services.IGiamGiaService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.impl.DatPhongServiceImpl;
import vn.iotstar.services.impl.GiamGiaServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;

@WebServlet(urlPatterns = {"/datPhong"})
public class BookingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public IPhongService phongService = new PhongServiceImpl();
	public IDatPhongService datPhongService = new DatPhongServiceImpl();
	public IGiamGiaService giamGiaService = new GiamGiaServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int idPhong = 0;
		String id = req.getParameter("id");
		if (id == null) {
		    Object idPhongObj = session.getAttribute("idphong");
		    if (idPhongObj != null) {
		        idPhong = Integer.parseInt((String) idPhongObj);
		    }
		} else {
		    idPhong = Integer.parseInt(id);
		    session.setAttribute("idphong", String.valueOf(idPhong));
		}
		
		PhongModel Phong = phongService.findById(idPhong);
		
		String username = null;
		UserModel user = null;
		if (session != null && session.getAttribute("account") != null) {
			user = (UserModel) session.getAttribute("account");
			username = user.getFullname();
		}
		req.setAttribute("username", username);
		session.setAttribute("currentURL", req.getContextPath().toString() + "/datPhong");
		
		
		String ngayDen = (String) session.getAttribute("ngayDen1");
		String ngayDi = (String) session.getAttribute("ngayDi1");
		
		SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dateNgayDen = Date.valueOf(ngayDen);
		    Date dateNgayDi = Date.valueOf(ngayDi);

		    // Chuyển đổi java.sql.Date thành chuỗi theo định dạng mong muốn
		    String ngayDenFormatted = newFormat.format(dateNgayDen);
		    String ngayDiFormatted = newFormat.format(dateNgayDi);

		    req.setAttribute("ngayDen", ngayDenFormatted);
		    req.setAttribute("ngayDi", ngayDiFormatted);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		Object idKhachSanObj = session.getAttribute("idKhachSan");
    	int idKhachSan = 0;
        if (idKhachSanObj != null) {
        	idKhachSan = (int) idKhachSanObj;
        } 
        KhachSanModel ks = khachSanService.findById(idKhachSan);
        List<GiamGiaModel> listGiamGia = giamGiaService.findByIdSheller(ks.getidUser());
        Date ngayHienTai = new Date(System.currentTimeMillis());
        for (GiamGiaModel giamGia : listGiamGia) {
        	giamGia.setStatus(false);
        	int count = datPhongService.countDatPhongByIdUser(user.getId());
        	int sum = datPhongService.sumTienDatPhongByIdUser(user.getId(), idKhachSan);
        	boolean kiemTra = giamGiaService.checkExistIdUser(user.getId(), giamGia.getId());
        	if (giamGia.getApDung().equals ("Giảm giá cho người mới")) {        		
        		if ((count == 0 || kiemTra == false) && ngayHienTai.before(giamGia.getNgayKetThuc())  && ngayHienTai.after(giamGia.getNgayBatDau())) {
        			giamGia.setStatus(true);
        			System.out.println ("Giảm giá cho người mới");        		}
        	}
        	if (giamGia.getApDung().equals("Khách hàng thân thiết")) {
        		if (count > 5 && kiemTra == false && ngayHienTai.before(giamGia.getNgayKetThuc())  && ngayHienTai.after(giamGia.getNgayBatDau())) {
        			giamGia.setStatus(true);
        			System.out.println ("Giảm giá cho khách hàng thân thiết");      
        		}
        	}
        	if (giamGia.getApDung().equals("Số tiền lớn hơn 5.000.000 VNĐ")) {
        		if (sum >= 5000000 && kiemTra == false && ngayHienTai.before(giamGia.getNgayKetThuc())  && ngayHienTai.after(giamGia.getNgayBatDau())) {
        			giamGia.setStatus(true);
        			System.out.println ("Số tiền lớn hơn 5.000.000 VNĐ");      
        		}
        	}
        	if (giamGia.getApDung().equals(user.getFullname())) {
        		giamGia.setStatus(true);
        	}
        }
		req.setAttribute("listgiamgia", listGiamGia);
		req.setAttribute("tenphong", Phong.getTen());
		req.setAttribute("anhhong", Phong.getAnhPhong());
		req.setAttribute("slkhach", Phong.getSucChuaToiDa());
		req.setAttribute("sophongtrong", Phong.getSoPhongTrong());
		req.setAttribute("tienphong", Phong.getTienThueSauKhiGiam());
		if (user != null) {
			req.setAttribute("hovaten", user.getFullname());
			req.setAttribute("sodt", user.getPhone());
			req.setAttribute("email", user.getEmail());
		}
		req.getRequestDispatcher("/views/datPhong.jsp").forward(req, resp);
	}
}
