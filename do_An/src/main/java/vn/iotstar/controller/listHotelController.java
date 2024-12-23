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
import vn.iotstar.models.LocTienNghiModel;
import vn.iotstar.models.CheckboxModel;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.KhuyenMaiModel;
import vn.iotstar.models.LoaiKhachSanModel;
import vn.iotstar.models.PhongModel;
import vn.iotstar.models.ThichKhachSanModel;
import vn.iotstar.models.DiaDiemModel;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IAnhKhachSanService;
import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IKhuyenMaiService;
import vn.iotstar.services.ILoaiKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IThichKhachSanService;
import vn.iotstar.services.IDiaDiemService;
import vn.iotstar.services.ITienIchService;
import vn.iotstar.services.impl.AnhKhachSanServiceImpl;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.KhuyenMaiServiceImpl;
import vn.iotstar.services.impl.LoaiKhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.ThichKhachSanServiceImpl;
import vn.iotstar.services.impl.DiaDiemServiceImpl;
import vn.iotstar.services.impl.TienIchServiceImpl;

@WebServlet(urlPatterns = {"/danhsachks","/danhsachks/timkiem","/danhsachks/locks", "/danhsachks/thichKS"})
public class listHotelController extends HttpServlet {

	private static final long serialVersionUID = 1L;
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
		if (url.contains("/danhsachks")) 
		{			
			HttpSession session = req.getSession(false);
			String username = null;
			int idUser = 0;
			if (session != null && session.getAttribute("account") != null) {
				UserModel user = (UserModel) session.getAttribute("account");
				username = user.getFullname();
				idUser = user.getId();
				session.setAttribute("account", user);
			}
			req.setAttribute("username", username);
			
			
			
			List<CheckboxModel> listXepHang = (List<CheckboxModel>) session.getAttribute("listXepHang");
			session.setAttribute("currentURL", req.getContextPath().toString() + "/danhsachks");
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
			
			
			List<CheckboxModel> listTienNghi = (List<CheckboxModel>) session.getAttribute("listTienNghi");
			if (listTienNghi == null) {
			    listTienNghi = new ArrayList<>();
			    for (LocTienNghiModel tmp : LocTienNghiModel.listTienNghi) {
			        listTienNghi.add(new CheckboxModel(tmp.getTen()));
			    }
			    session.setAttribute("listTienNghi", listTienNghi);
			}
			req.setAttribute("listTienNghi", listTienNghi);

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
	        
	        Object filteredHotelsObj = session.getAttribute("filteredHotels");
	        List<KhachSanModel> listKS = null;
	        
	        Object idDiaDiemObj = session.getAttribute("idDiaDiemTimKiem1");
	        Object idDiaDiemObj1 = session.getAttribute("idDiaDiemTimKiem");        	
        	int idDiaDiem = 0;
        	String idDiaDiemStr = req.getParameter("id");
	        if (idDiaDiemStr != null) {
	        	idDiaDiem = Integer.parseInt(idDiaDiemStr);
	        	filteredHotelsObj = null;
	        	session.setAttribute("filteredHotels", null);
	        	
	        }else {
	        	if (idDiaDiemObj != null) {
		            idDiaDiem = (int) idDiaDiemObj;
		            session.setAttribute("idDiaDiemTimKiem1", null);
		            filteredHotelsObj = null;
		            session.setAttribute("filteredHotels", null);
		        } else if (idDiaDiemObj1 != null) {
		        	idDiaDiem = (int) idDiaDiemObj1;    
		        }
	        }
	        
	        
	        
	        int idloaiKhachSan = 0;
	        String idLoaiKhachSanStr = req.getParameter("idloaiks");
	        if (idLoaiKhachSanStr != null) {
	        	idloaiKhachSan = Integer.parseInt(idLoaiKhachSanStr);
	        }
	        
	        if (idLoaiKhachSanStr != null) {
	        	int currentPage = 1;
	            if (req.getParameter("page") != null) {
	                currentPage = Integer.parseInt(req.getParameter("page"));
	            }
	        	
	        	
	        	listKS = khachSanService.findByIdLoaiKhachSan(currentPage, idloaiKhachSan);
	        	List<KhachSanModel> listKS1 = khachSanService.findByIdLoaiKhachSan(idloaiKhachSan);
	        	int countKS = khachSanService.countAllByIdLoaiKS(idloaiKhachSan);
	        	int endPage = countKS/5;
	        	if (countKS % 5 != 0) {
	        		endPage ++;
	        	}
	        	req.setAttribute("currentPage", currentPage);
	        	req.setAttribute("countKS", countKS);
	        	req.setAttribute("endPage", endPage);
	        	session.setAttribute("originalHotelList", listKS1);
	        }
	        else if (filteredHotelsObj != null) {
	        	int currentPage = 1;
	            if (req.getParameter("page") != null) {
	                currentPage = Integer.parseInt(req.getParameter("page"));
	            }
	        	listKS = (List<KhachSanModel>) filteredHotelsObj;
	        	
	        	int startIndex = (currentPage - 1) * 5;
	            int endIndex = Math.min(startIndex + 5, listKS.size());
	            System.out.println ("Số khách sạn: " + listKS.size());
	            System.out.println ("Trang hiện tại: " + currentPage);
	            System.out.println ("Bắt đầu: " + startIndex + " Kết thúc: " + endIndex);
	            List<KhachSanModel> paginatedList = listKS.subList(startIndex, endIndex);
	            
	        	int countKS = listKS.size();
	        	int endPage = countKS/5;
	        	if (countKS % 5 != 0) {
	        		endPage ++;
	        	}
	        	
	        	listKS = paginatedList;
	        	req.setAttribute("currentPage", currentPage);
	        	req.setAttribute("countKS", countKS);
	        	req.setAttribute("endPage", endPage);
	        }
	        else if (idDiaDiemStr != null || idDiaDiemObj != null || idDiaDiemObj1 != null){
	        	int currentPage = 1;
	            if (req.getParameter("page") != null) {
	                currentPage = Integer.parseInt(req.getParameter("page"));
	            }
	        	listKS = khachSanService.findByIdDiaDiem(currentPage,idDiaDiem);
	        	List<KhachSanModel> listKS1 = khachSanService.findByIdDiaDiem(idDiaDiem);
	        	int countKS = khachSanService.countAllByIdDiaDiem(idDiaDiem);
	        	int endPage = countKS/5;
	        	if (countKS % 5 != 0) {
	        		endPage ++;
	        	}
	        	req.setAttribute("currentPage", currentPage);
	        	req.setAttribute("countKS", countKS);
	        	req.setAttribute("endPage", endPage);
	        	session.setAttribute("idDiaDiemTimKiem", idDiaDiem);
	        	//req.getSession().setAttribute("idTP", idThanhPho);
	        	session.setAttribute("originalHotelList", listKS1);
	        }
	        
	        //session.setAttribute("danhSachTimKiem", listKS);
	        List<ThichKhachSanModel> listThichKhachSan = thichKhachSanService.listLikeHotel(idUser);
			for (ThichKhachSanModel thich : listThichKhachSan) {
				for (KhachSanModel ks : listKS) {
					if (ks.getId() == thich.getIdKS()) {
						ks.setDaThich(true);
					}
				}
			}
        	req.setAttribute("listks", listKS);
        	req.setAttribute("SLKS", listKS.size());
        	int i = 0;
        	for (KhachSanModel ks : listKS) {
        		if (i == 0) {
        			req.setAttribute("diaDiem", ks.getTenDiaDiem());
        			i++;
        		}
        	}
	        for (KhachSanModel khachSan : listKS) {
	        	List<KhuyenMaiModel> listKhuyenMai = khuyenMaiService.findByIdKhachSan(khachSan.getId());
	            khyenMaiMap.put(khachSan.getId(), listKhuyenMai);
	            
	        	List<PhongModel> listP = phongService.findByIdKhachSan(khachSan.getId());
	            for (PhongModel phong : listP) {	
	    			phong.setTienThueSauKhiGiam(phong.getGiaThue());
	    			phongService.update2(phong);
	    		}
	    		for (KhuyenMaiModel khuyenMai : listKhuyenMai) {
	    			System.out.println ("khuyen mãi1: " + khuyenMai.getTen());
	    			System.out.println("Thời gian bắt đầu: " + khuyenMai.getThoiGianBatDau());
	    			System.out.println("Thời gian kết thúc: " + khuyenMai.getThoiGianKetThuc());
	    			if (khuyenMai.getStatus() == 1)  {
	    				System.out.println ("khuyen mãi: " + khuyenMai.getTen());
	    				if (khuyenMai.getIdPhong() == 0) {
	    					List<PhongModel> listPhong1 = phongService.findByIdKhachSan(khuyenMai.getIdKS());
	    					for (PhongModel phong : listPhong1) {
	    						int tienSauKhiGiam = (phong.getTienThueSauKhiGiam() * (100 - khuyenMai.getGiaTriGiam()))/100;
	    						phong.setTienThueSauKhiGiam(tienSauKhiGiam);
	    						phongService.update2(phong);
	    					}
	    				}
	    				else {
	    					PhongModel phong = phongService.findById(khuyenMai.getIdPhong());
	    					int tienSauKhiGiam = (phong.getGiaThue() * (100 - khuyenMai.getGiaTriGiam()))/100;
	    					phong.setTienThueSauKhiGiam(tienSauKhiGiam);
	    					phongService.update2(phong);
	    				}
	    				
	    			}
	    		}
	    		
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
	        req.setAttribute("khyenMaiMap", khyenMaiMap);
	        
	        req.setAttribute("listThichKhachSan", listThichKhachSan);
	        
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
		
		if (url.contains("/danhsachks/thichKS")) {
			HttpSession session = req.getSession(false);
			UserModel user = null;
			
			if (session != null && session.getAttribute("account") != null) {
				user = (UserModel) session.getAttribute("account");
			}
			
			int ksId = Integer.parseInt(req.getParameter("ksId"));
		    boolean favorite = Boolean.parseBoolean(req.getParameter("favorite"));
		    
		    if (favorite == true) {
		    	thichKhachSanService.likeHotel(user.getId(), ksId);
		    }
		    else {
		    	thichKhachSanService.unlikeHotel(user.getId(), ksId);
		    }

		    System.out.println("ksId nhận được: " + ksId);
		    System.out.println("favorite nhận được: " + favorite);
		    System.out.println("favorite nhận được: " + user.getFullname());

		    resp.setContentType("text/plain");
		    resp.getWriter().write("Dữ liệu nhận thành công!");
		}
		if (url.contains("/danhsachks/timkiem")) {
			String diadiem = req.getParameter("tenThanhPhoTimKiem");
			String ngaydenStr = req.getParameter("thoiGianDen");
			String ngaydiStr = req.getParameter("thoiGianDi");
		    HttpSession session = req.getSession();
		    DiaDiemModel theoDiaDiem = diaDiemService.findByName(diadiem);
			int idDiaDiem =  theoDiaDiem.getId();
			session.setAttribute("idDiaDiemTimKiem1", idDiaDiem);
			
			session.setAttribute("ngayDen", ngaydenStr);
			session.setAttribute("ngayDi", ngaydiStr);
			session.setAttribute("listXepHang", null);
		    session.setAttribute("listLoaiKhachSan", null);
		    session.setAttribute("listTienNghi", null);
		    session.setAttribute("listCachTrungTam", null);
		    session.setAttribute("listGiapBien", null);
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
			    	
			    	List<CheckboxModel> listTienNghi = (List<CheckboxModel>) session.getAttribute("listTienNghi");
			    	for (CheckboxModel checkbox : listTienNghi) {
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
		            
		        } else{
		        	
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
				    else {
				    	for (CheckboxModel checkbox : listXepHang) {
				                checkbox.setChecked(false);
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
				    else {
				    	for (CheckboxModel checkbox : listLoaiKhachSan) {
				                checkbox.setChecked(false);
				        }
				    }

				    List<CheckboxModel> listTienNghi = (List<CheckboxModel>) session.getAttribute("listTienNghi");
				    if (mealTypes != null) {
				        for (CheckboxModel checkbox : listTienNghi) {
				            if (Arrays.asList(mealTypes).contains(checkbox.getLabel())) {
				                checkbox.setChecked(true);
				            } else {
				                checkbox.setChecked(false);
				            }
				        }
				    }
				    else {
				    	for (CheckboxModel checkbox : listTienNghi) {
				                checkbox.setChecked(false);
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
				    else {
				    	for (CheckboxModel checkbox : listCachTrungTam) {
				                checkbox.setChecked(false);
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
				    else {
				    	for (CheckboxModel checkbox : listGiapBien) {
				                checkbox.setChecked(false);
				        }
				    }
				    
				    session.setAttribute("listXepHang", listXepHang);
				    session.setAttribute("listLoaiKhachSan", listLoaiKhachSan);
				    session.setAttribute("listTienNghi", listTienNghi);
				    session.setAttribute("listCachTrungTam", listCachTrungTam);
				    session.setAttribute("listGiapBien", listGiapBien);
				    
				    
			    	List<KhachSanModel> filteredHotels = locKhachSan(listXepHang, listLoaiKhachSan, listTienNghi, listCachTrungTam, listGiapBien, originalHotelList,min,max);
			    	session.setAttribute("filteredHotels", filteredHotels);
			    	
			    	//List<CheckboxModel> listXepHang = (List<CheckboxModel>) session.getAttribute("listXepHang");
			    	
			    	//session.setAttribute("tienIchMoiKS", tienIchMap);
			    	
			    	
		        } 
		   
            
            resp.sendRedirect(req.getContextPath() + "/danhsachks");

		}

	}	
	private List<KhachSanModel> locKhachSan(List<CheckboxModel> listXepHang2, List<CheckboxModel> listLoaiKhachSan2,
			List<CheckboxModel> listTienNghi2, List<CheckboxModel> listCachTrungTam2, List<CheckboxModel> listGiapBien2,
			List<KhachSanModel> danhSachTimKiem, int min, int max) {
		List<KhachSanModel> filteredHotels = new ArrayList<>();
		for (KhachSanModel tmp : danhSachTimKiem) {
            if (locXepHang(tmp,listXepHang2) && locLoaiKhachSan(tmp,listLoaiKhachSan2) && locTienNghi(tmp,listTienNghi2) && locCachTrungTam(tmp,listCachTrungTam2) && locGiapBien(tmp,listGiapBien2) && locTienThue(tmp,min,max)) {
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
	private boolean locTienNghi(KhachSanModel ks, List<CheckboxModel> listTienNghi2) {
		boolean check = false;
		List<TienIchModel> listTienIch = tienIchService.findByIdKhachSan(ks.getId());
		
		for (CheckboxModel check1 : listTienNghi2) {
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