package vn.iotstar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.BuaAnModel;
import vn.iotstar.models.CheckboxModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.LoaiKhachSanModel;
import vn.iotstar.models.ThanhPhoModel;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IThanhPhoService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.ThanhPhoServiceImpl;

@WebServlet(urlPatterns = {"/danhsachks","/danhsachks/timkiem"})
public class listHotelController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ILoaiKhachSanService loaiKhachSanService = new LoaiKhachSanServiceImpl();
	public IThanhPhoService thanhPhoService = new ThanhPhoServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/danhsachks")) 
		{
			ArrayList<CheckboxModel> listXepHang = new ArrayList<CheckboxModel>();
	        listXepHang.add(new CheckboxModel("Không xếp hạng"));
	        listXepHang.add(new CheckboxModel("1 Sao"));
	        listXepHang.add(new CheckboxModel("2 Sao"));
	        listXepHang.add(new CheckboxModel("3 Sao"));
	        listXepHang.add(new CheckboxModel("4 Sao"));
	        listXepHang.add(new CheckboxModel("5 Sao"));
	        req.setAttribute("listxh", listXepHang);
	        
	        ArrayList<CheckboxModel> listLoaiKhachSan = new ArrayList<CheckboxModel>();
	        List<LoaiKhachSanModel> listLoaiKS = loaiKhachSanService.listTenLoaiKhachSan();
	        for(LoaiKhachSanModel loaiks : listLoaiKS)
	        {
	        	listLoaiKhachSan.add(new CheckboxModel(loaiks.getTen()));
	        }
	        req.setAttribute("listloaiks", listLoaiKhachSan);
	        
		    ArrayList<CheckboxModel> listBuaAn = new ArrayList<CheckboxModel>();
		    for (BuaAnModel tmp : BuaAnModel.listBuaAn) {
		    	listBuaAn.add(new CheckboxModel(tmp.getTen()));
	        }
		    req.setAttribute("listBuaAn", listBuaAn);
		    
		    ArrayList<CheckboxModel> listCachTrungTam = new ArrayList<CheckboxModel>();
		    listCachTrungTam.add(new CheckboxModel("Dưới 1 Km"));
	        listCachTrungTam.add(new CheckboxModel("Dưới 3 Km"));
	        listCachTrungTam.add(new CheckboxModel("Dưới 5 Km"));
	        req.setAttribute("listCachTrungTam", listCachTrungTam);
	        
		    ArrayList<CheckboxModel> listGiapBien = new ArrayList<CheckboxModel>();
		    listGiapBien.add(new CheckboxModel("Không giáp"));
	        listGiapBien.add(new CheckboxModel("Có giáp"));
	        req.setAttribute("listGiapBien", listGiapBien);
	        
	        HttpSession session = req.getSession();
	        int idThanhPho = (int) session.getAttribute("idThanhPhoTimKiem");
	        List<KhachSanModel> listKS = khachSanService.findByIdThanhPho(idThanhPho);
	        req.setAttribute("listks", listKS);
	        String[] strDanhGia = {"Bình thường", "Khá ổn", "Chất lượng", "Sang trọng", "Tuyệt vời", "Xuất sắc"};
	        req.setAttribute("strDanhGia", strDanhGia);
	        
	        req.getRequestDispatcher("/views/danhsachks.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/danhsachks/timkiem")) {
			
			
			
			String diadiem = req.getParameter("tenThanhPhoTimKiem");
			//String ngaydenStr = req.getParameter("thoiGianDen");
			//String ngaydiStr = req.getParameter("thoiGianDi");
			

			ThanhPhoModel thanhPhoTheoDiaDiem = thanhPhoService.findByName(diadiem);
			int idThanhPho = thanhPhoTheoDiaDiem.getId();
			HttpSession session = req.getSession();
			session.setAttribute("idThanhPhoTimKiem", idThanhPho);
			resp.sendRedirect(req.getContextPath() + "/danhsachks");
		}
	}
}
