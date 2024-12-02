package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import vn.iotstar.services.IPhongService;
import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.PhongServiceImpl;
import vn.iotstar.services.impl.UserServiceImpl;

public class DatPhongModel implements Serializable {

	private static final long serialVersionUID = 1L;

	int id;
    int idUser;
    int idPhong;
    Date ngayDat;
    Date ngayDen;
    Date ngayTra;
    String ghiChu;
    int thanhTien;
    int daHuy;
    int soPhongDaDat;
    boolean thanhToan;
    String phuongThucTT;
    int tienSauKhiChietKhau;
    UserModel user;
    PhongModel phong;
    long thoiGianConLaiTT;
    long thoiGianOConLai;
    Date ngayHienTai = new Date(System.currentTimeMillis());
    
    public IUserServices userService = new UserServiceImpl();
    public IPhongService phongService = new PhongServiceImpl();
    
    
	public DatPhongModel() {
		super();
	}

	public DatPhongModel(int id, int idUser, int idPhong, Date ngayDat, Date ngayDen, Date ngayTra,
			String ghiChu, int thanhTien, int daHuy, int soPhongDaDat, boolean thanhToan, String phuongThucTT, int tienSauKhiChietKhau) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idPhong = idPhong;
		this.ngayDat = ngayDat;
		this.ngayDen = ngayDen;
		this.ngayTra = ngayTra;
		this.ghiChu = ghiChu;
		this.thanhTien = thanhTien;
		this.daHuy = daHuy;
		this.soPhongDaDat = soPhongDaDat;
		this.thanhToan = thanhToan;
		this.phuongThucTT = phuongThucTT;
		this.tienSauKhiChietKhau = tienSauKhiChietKhau;
		
		if (ngayHienTai.before(ngayDat)) {
			thoiGianConLaiTT = ChronoUnit.DAYS.between(ngayDat.toLocalDate(), ngayDen.toLocalDate());
		}
		else {
			thoiGianConLaiTT = ChronoUnit.DAYS.between(ngayHienTai.toLocalDate(), ngayDen.toLocalDate());
		}

		if (ngayHienTai.before(ngayDen)) {
			thoiGianOConLai = ChronoUnit.DAYS.between(ngayDen.toLocalDate(), ngayDen.toLocalDate());
		}
		else {
			thoiGianOConLai = ChronoUnit.DAYS.between(ngayHienTai.toLocalDate(), ngayDen.toLocalDate());
		}
		user = userService.findById(idUser);
		phong = phongService.findById(idPhong);
	}

	public DatPhongModel(int idUser, int idPhong, Date ngayDat, Date ngayDen, Date ngayTra, String ghiChu,
			int thanhTien, int daHuy, int soPhongDaDat, boolean thanhToan, String phuongThucTT) {
		super();
		this.idUser = idUser;
		this.idPhong = idPhong;
		this.ngayDat = ngayDat;
		this.ngayDen = ngayDen;
		this.ngayTra = ngayTra;
		this.ghiChu = ghiChu;
		this.thanhTien = thanhTien;
		this.daHuy = daHuy;
		this.soPhongDaDat = soPhongDaDat;
		this.thanhToan = thanhToan;
		this.phuongThucTT = phuongThucTT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	public int isDaHuy() {
		return daHuy;
	}

	public void setDaHuy(int daHuy) {
		this.daHuy = daHuy;
	}

	public int getSoPhongDaDat() {
		return soPhongDaDat;
	}

	public void setSoPhongDaDat(int soPhongDaDat) {
		this.soPhongDaDat = soPhongDaDat;
	}

	public boolean isThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(boolean thanhToan) {
		this.thanhToan = thanhToan;
	}

	public String getPhuongThucTT() {
		return phuongThucTT;
	}

	public void setPhuongThucTT(String phuongThucTT) {
		this.phuongThucTT = phuongThucTT;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public PhongModel getPhong() {
		return phong;
	}

	public void setPhong(PhongModel phong) {
		this.phong = phong;
	}

	public long getThoiGianConLaiTT() {
		return thoiGianConLaiTT;
	}

	public void setThoiGianConLaiTT(long thoiGianConLaiTT) {
		this.thoiGianConLaiTT = thoiGianConLaiTT;
	}

	public long getThoiGianOConLai() {
		return thoiGianOConLai;
	}

	public void setThoiGianOConLai(long thoiGianOConLai) {
		this.thoiGianOConLai = thoiGianOConLai;
	}

	public int getTienSauKhiChietKhau() {
		return tienSauKhiChietKhau;
	}

	public void setTienSauKhiChietKhau(int tienSauKhiChietKhau) {
		this.tienSauKhiChietKhau = tienSauKhiChietKhau;
	} 
}
