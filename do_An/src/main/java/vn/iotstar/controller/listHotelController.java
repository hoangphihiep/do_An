package vn.iotstar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import vn.iotstar.models.BuaAnModel;
import vn.iotstar.models.CheckboxModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.LoaiKhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.ThanhPhoModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IThanhPhoService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.ThanhPhoServiceImpl;
import vn.iotstar.services.impl.TienIchServiceImpl;

@WebServlet(urlPatterns = {"/danhsachks","/danhsachks/timkiem","/danhsachks/locks"})
public class listHotelController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ILoaiKhachSanService loaiKhachSanService = new LoaiKhachSanServiceImpl();
	public IThanhPhoService thanhPhoService = new ThanhPhoServiceImpl();
	public IKhachSanService khachSanService = new KhachSanServiceImpl();
	public IAnhKhachSanService anhKhachSanService = new AnhKhachSanServiceImpl();
	public ITienIchService tienIchService = new TienIchServiceImpl();
	public IPhongService phongService = new PhongServiceImpl();
	ArrayList<CheckboxModel> listXepHang = new ArrayList<CheckboxModel>();
	ArrayList<CheckboxModel> listLoaiKhachSan = new ArrayList<CheckboxModel>();
	ArrayList<CheckboxModel> listBuaAn = new ArrayList<CheckboxModel>();
	ArrayList<CheckboxModel> listCachTrungTam = new ArrayList<CheckboxModel>();
	ArrayList<CheckboxModel> listGiapBien = new ArrayList<CheckboxModel>();
	Map<Integer, List<AnhKhachSanModel>> anhMap = new HashMap<>();
    Map<Integer, List<TienIchModel>> tienIchMap = new HashMap<>();
    Map<Integer, List<PhongModel>> phongMap = new HashMap<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/danhsachks")) 
		{
			HttpSession session = req.getSession();
			List<CheckboxModel> listXepHang = (List<CheckboxModel>) session.getAttribute("listXepHang");
			
			if (listXepHang == null)
			{
				listXepHang = new ArrayList<>();
				listXepHang.add(new CheckboxModel("Không xếp hạng"));
		        listXepHang.add(new CheckboxModel("1 Sao"));
		        listXepHang.add(new CheckboxModel("2 Sao"));
		        listXepHang.add(new CheckboxModel("3 Sao"));
		        listXepHang.add(new CheckboxModel("4 Sao"));
		        listXepHang.add(new CheckboxModel("5 Sao"));
		        session.setAttribute("listXepHang", listXepHang); 
			}
			req.setAttribute("listxh", listXepHang);
			
			List<CheckboxModel> listLoaiKhachSan = (List<CheckboxModel>) session.getAttribute("listLoaiKhachSan");
			if (listLoaiKhachSan == null) {
			    listLoaiKhachSan = new ArrayList<>();
			    List<LoaiKhachSanModel> listLoaiKS = loaiKhachSanService.listTenLoaiKhachSan();
			    for (LoaiKhachSanModel loaiks : listLoaiKS) {
			        listLoaiKhachSan.add(new CheckboxModel(loaiks.getTen()));
			    }
			    session.setAttribute("listLoaiKhachSan", listLoaiKhachSan);
			}
			req.setAttribute("listloaiks", listLoaiKhachSan);
			
			List<CheckboxModel> listBuaAn = (List<CheckboxModel>) session.getAttribute("listBuaAn");
			if (listBuaAn == null) {
			    listBuaAn = new ArrayList<>();
			    for (BuaAnModel tmp : BuaAnModel.listBuaAn) {
			        listBuaAn.add(new CheckboxModel(tmp.getTen()));
			    }
			    session.setAttribute("listBuaAn", listBuaAn);
			}
			req.setAttribute("listBuaAn", listBuaAn);

			List<CheckboxModel> listCachTrungTam = (List<CheckboxModel>) session.getAttribute("listCachTrungTam");
			if (listCachTrungTam == null) {
			    listCachTrungTam = new ArrayList<>();
			    listCachTrungTam.add(new CheckboxModel("Dưới 1 Km"));
			    listCachTrungTam.add(new CheckboxModel("Dưới 3 Km"));
			    listCachTrungTam.add(new CheckboxModel("Dưới 5 Km"));
			    session.setAttribute("listCachTrungTam", listCachTrungTam); // Lưu vào session
			}
			req.setAttribute("listCachTrungTam", listCachTrungTam);

			List<CheckboxModel> listGiapBien = (List<CheckboxModel>) session.getAttribute("listGiapBien");
			if (listGiapBien == null) {
			    listGiapBien = new ArrayList<>();
			    listGiapBien.add(new CheckboxModel("Không giáp"));
			    listGiapBien.add(new CheckboxModel("Có giáp"));
			    session.setAttribute("listGiapBien", listGiapBien);
			}
			req.setAttribute("listGiapBien", listGiapBien);
	        
			List<KhachSanModel> originalHotelList = (List<KhachSanModel>) session.getAttribute("originalHotelList");
	        Object filteredHotelsObj = session.getAttribute("filteredHotels");
	        List<KhachSanModel> listKS = null;
	        if (filteredHotelsObj != null) {
	        	listKS = (List<KhachSanModel>) filteredHotelsObj;
	        }
	        else {
	        	Object idThanhPhoObj = session.getAttribute("idThanhPhoTimKiem");
		        int idThanhPho = 0;
		        if (idThanhPhoObj != null) {
		            idThanhPho = (int) idThanhPhoObj;
		        } else {
		            String idThanhPhoStr = req.getParameter("id");
		            if (idThanhPhoStr != null) {
		                idThanhPho = Integer.parseInt(idThanhPhoStr);
		            }
		        }
		        
		        if (idThanhPho != 0){
		        	listKS = khachSanService.findByIdThanhPho(idThanhPho);
		        	req.getSession().setAttribute("idTP", idThanhPho);
		        	session.setAttribute("originalHotelList", listKS);
		        }
		        else {
		        	String idLoaiKhachSanStr = req.getParameter("idloaiks");
		        	int idloaiKhachSan = Integer.parseInt(idLoaiKhachSanStr);
		        	listKS = khachSanService.findByIdLoaiKhachSan(idloaiKhachSan);
		        	session.setAttribute("originalHotelList", listKS);
		        }
	        }
	        
	        //session.setAttribute("danhSachTimKiem", listKS);
        	req.setAttribute("listks", listKS);
        	
	        for (KhachSanModel khachSan : listKS) {
	            List<AnhKhachSanModel> listAnh = anhKhachSanService.findByIdKhachSan(khachSan.getId());
	            anhMap.put(khachSan.getId(), listAnh);
	            
	            List<TienIchModel> listTienIch = tienIchService.findByIdKhachSan(khachSan.getId());
	            tienIchMap.put(khachSan.getId(), listTienIch);
	            
	            List<PhongModel> listPhong = phongService.phongMinByIdKhachSan(khachSan.getId());
	            phongMap.put(khachSan.getId(), listPhong);
	        }
	        
	        req.setAttribute("anhMap", anhMap);
	        req.setAttribute("tienIchMap", tienIchMap);
	        req.setAttribute("phongMap", phongMap);
	        session.setAttribute("tienThueMoiKS", phongMap);
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
		    HttpSession session = req.getSession();
		    ThanhPhoModel thanhPhoTheoDiaDiem = thanhPhoService.findByName(diadiem);
			int idThanhPho =  thanhPhoTheoDiaDiem.getId();
			session.setAttribute("idThanhPhoTimKiem", idThanhPho);
			
	        resp.sendRedirect(req.getContextPath() + "/danhsachks");
		}
		else if(url.contains("/danhsachks/locks"))
		{
			String[] rankings = req.getParameterValues("ranking");
		    String[] hotelTypes = req.getParameterValues("hotelType");
		    String[] mealTypes = req.getParameterValues("mealType");
		    String[] distances = req.getParameterValues("distanceFromCenter");
		    String[] nearSeas = req.getParameterValues("nearSea");
		    String minValue = req.getParameter("min-value");
		    String maxValue = req.getParameter("max-value");
		    
		    int min = Integer.parseInt(minValue);
            int max = Integer.parseInt(maxValue);
            System.out.println("Min value: " + min);
            System.out.println("Max value: " + max);
		    HttpSession session = req.getSession();
		    List<KhachSanModel> originalHotelList = (List<KhachSanModel>) session.getAttribute("originalHotelList");
		    if ((rankings == null || rankings.length == 0) &&
		            (hotelTypes == null || hotelTypes.length == 0) &&
		            (mealTypes == null || mealTypes.length == 0) &&
		            (distances == null || distances.length == 0) &&
		            (nearSeas == null || nearSeas.length == 0)) {
		            
		    		List<CheckboxModel> listXepHang = (List<CheckboxModel>) session.getAttribute("listXepHang");
			    	for (CheckboxModel checkbox : listXepHang) {
			            checkbox.setChecked(false);
			        }
			    	
			    	List<CheckboxModel> listLoaiKhachSan = (List<CheckboxModel>) session.getAttribute("listLoaiKhachSan");
			    	for (CheckboxModel checkbox : listLoaiKhachSan) {
			            checkbox.setChecked(false);
			        }
			    	
			    	List<CheckboxModel> listBuaAn = (List<CheckboxModel>) session.getAttribute("listBuaAn");
			    	for (CheckboxModel checkbox : listBuaAn) {
			            checkbox.setChecked(false);
			        }
			    	
			    	List<CheckboxModel> listCachTrungTam = (List<CheckboxModel>) session.getAttribute("listCachTrungTam");
			    	for (CheckboxModel checkbox : listCachTrungTam) {
			            checkbox.setChecked(false);
			        }
			    	
			    	List<CheckboxModel> listGiapBien = (List<CheckboxModel>) session.getAttribute("listGiapBien");
			    	for (CheckboxModel checkbox : listGiapBien) {
			            checkbox.setChecked(false);
			        }
			    	session.setAttribute("filteredHotels", originalHotelList);
		            
		        } else
		        {
		        	
		        	List<CheckboxModel> listXepHang = (List<CheckboxModel>) session.getAttribute("listXepHang");
				    if (rankings != null) {
				        for (CheckboxModel checkbox : listXepHang) {
				            if (Arrays.asList(rankings).contains(checkbox.getLabel())) {
				                checkbox.setChecked(true);
				            } else {
				                checkbox.setChecked(false);
				            }
				        }
				    }
				    
				    List<CheckboxModel> listLoaiKhachSan = (List<CheckboxModel>) session.getAttribute("listLoaiKhachSan");
				    if (hotelTypes != null) {
				        for (CheckboxModel checkbox : listLoaiKhachSan) {
				            if (Arrays.asList(hotelTypes).contains(checkbox.getLabel())) {
				                checkbox.setChecked(true);
				            } else {
				                checkbox.setChecked(false);
				            }
				        }
				    }
				    
				    List<CheckboxModel> listBuaAn = (List<CheckboxModel>) session.getAttribute("listBuaAn");
				    if (mealTypes != null) {
				        for (CheckboxModel checkbox : listBuaAn) {
				            if (Arrays.asList(mealTypes).contains(checkbox.getLabel())) {
				                checkbox.setChecked(true);
				            } else {
				                checkbox.setChecked(false);
				            }
				        }
				    }
				    List<CheckboxModel> listCachTrungTam = (List<CheckboxModel>) session.getAttribute("listCachTrungTam");
				    if (distances != null) {
				        for (CheckboxModel checkbox : listCachTrungTam) {
				            if (Arrays.asList(distances).contains(checkbox.getLabel())) {
				                checkbox.setChecked(true);
				            } else {
				                checkbox.setChecked(false);
				            }
				        }
				    }
				    
				    List<CheckboxModel> listGiapBien = (List<CheckboxModel>) session.getAttribute("listGiapBien");
				    if (nearSeas != null) {
				        for (CheckboxModel checkbox : listGiapBien) {
				            if (Arrays.asList(nearSeas).contains(checkbox.getLabel())) {
				                checkbox.setChecked(true);
				            } else {
				                checkbox.setChecked(false);
				            }
				        }
				    }
				    
				    session.setAttribute("listXepHang", listXepHang);
				    session.setAttribute("listLoaiKhachSan", listLoaiKhachSan);
				    session.setAttribute("listBuaAn", listBuaAn);
				    session.setAttribute("listCachTrungTam", listCachTrungTam);
				    session.setAttribute("listGiapBien", listGiapBien);
				    
				    
			    	List<KhachSanModel> filteredHotels = locKhachSan(listXepHang, listLoaiKhachSan, listBuaAn, listCachTrungTam, listGiapBien, originalHotelList,min,max);
			    	session.setAttribute("filteredHotels", filteredHotels);
			    	
			    	//List<CheckboxModel> listXepHang = (List<CheckboxModel>) session.getAttribute("listXepHang");
			    	
			    	//session.setAttribute("tienIchMoiKS", tienIchMap);
			    	
			    	
		        } 
		    int idThanhPho = 0;
		    Object idThanhPhoTimKiem = session.getAttribute("idThanhPhoTimKiem");
            if (idThanhPhoTimKiem != null) {
                idThanhPho = (int) idThanhPhoTimKiem;
            } 
            session.setAttribute("idThanhPhoTimKiem", idThanhPho);
            
            resp.sendRedirect(req.getContextPath() + "/danhsachks");

		}

	}	
	private List<KhachSanModel> locKhachSan(List<CheckboxModel> listXepHang2, List<CheckboxModel> listLoaiKhachSan2,
			List<CheckboxModel> listBuaAn2, List<CheckboxModel> listCachTrungTam2, List<CheckboxModel> listGiapBien2,
			List<KhachSanModel> danhSachTimKiem, int min, int max) {
		List<KhachSanModel> filteredHotels = new ArrayList<>();
		System.out.println ("Có vào đây ");
		for (KhachSanModel tmp : danhSachTimKiem) {
            if (locXepHang(tmp,listXepHang2) && locLoaiKhachSan(tmp,listLoaiKhachSan2) && locBuaAn(tmp,listBuaAn2) && locCachTrungTam(tmp,listCachTrungTam2) && locGiapBien(tmp,listGiapBien2) && locTienThue(tmp,min,max)) {
            	filteredHotels.add(tmp);
            }
        }
		return filteredHotels;
	}
	private boolean locTienThue(KhachSanModel tmp, int min, int max) {
		boolean check = false;
		List<PhongModel> listPhong = phongService.phongMinByIdKhachSan(tmp.getId());
		for (PhongModel phong : listPhong) {
			check = true;
			if (phong.getGiaThue() >= min && phong.getGiaThue() <= max) {
				return true;
			}
		}
		return !check;
	}
	private boolean locXepHang(KhachSanModel ks, List<CheckboxModel> listXepHang2) {
		boolean check = false;
        for (int i = 0; i <= 5; i++) {
            if (listXepHang2.get(i).isChecked()) {
                check = true;
                if (ks.getDanhGia() == i) {
                    return true;
                }
            }
        }
        return !check;
	}
	private boolean locLoaiKhachSan(KhachSanModel ks, List<CheckboxModel> listLoaiKhachSan2) {
		boolean check = false;
        for (CheckboxModel tmp : listLoaiKhachSan2) {
            if (tmp.isChecked()) {
                check = true;
                if (ks.getTenLoaiKhachSan().equals(tmp.getLabel())) {
                    return true;
                }
            }
        }
        return !check;
	}
	private boolean locBuaAn(KhachSanModel ks, List<CheckboxModel> listBuaAn2) {
		boolean check = false;
		List<TienIchModel> listTienIch = tienIchService.findByIdKhachSan(ks.getId());
		for (CheckboxModel check1 : listBuaAn2) {
			if (check1.isChecked()) {
				check = true;
				for (TienIchModel tienIch : listTienIch) {
                    if(tienIch.getTenTienNghi().equals(check1.getLabel())) {
                    	return true;
                    }
                }
            }
        }
		return !check;
	}
	private boolean locCachTrungTam(KhachSanModel ks, List<CheckboxModel> listCachTrungTam2) {
		boolean check = false;
        int khoangCach = ks.getCachTrungTam();
        if (listCachTrungTam2.get(0).isChecked()) {
            check = true;
            if (khoangCach < 1000) {
                return true;
            }
        }
        if (listCachTrungTam2.get(1).isChecked()) {
            check = true;
            if (khoangCach < 3000) {
                return true;
            }
        }
        if (listCachTrungTam2.get(2).isChecked()) {
            check = true;
            if (khoangCach < 5000) {
                return true;
            }
        }
        return !check;
	}
	private boolean locGiapBien(KhachSanModel ks, List<CheckboxModel> listGiapBien2) {
		boolean check = false;
        boolean giapBien = ks.isGiapBien();
        if (listGiapBien2.get(0).isChecked()) {
            check = true;
            if (giapBien == false) {
                return true;
            }
        }
        if (listGiapBien2.get(1).isChecked()) {
            check = true;
            if (giapBien == true) {
                return true;
            }
        }
        return !check;
	}	
}