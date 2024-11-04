package vn.iotstar.models;

import java.io.Serializable;
import java.util.Date;

public class LichSuModel implements Serializable {

	private static final long serialVersionUID = 1L;

	int id;
    String tenPhong;
    int idKhachSan;
    String tenKhachSan;
    Date ngayDat;
    Date ngayDen;
    Date ngayTra;
    String ghiChu;
    String thanhTien;
    int trangThai; // 0: Đang xử lý, 1: Quá hạn, 2: Đã hủy
    String anhPhong;
    int soPhongDaDat;
    boolean trangThaiTT;
    String phuongThucTT;
    
	public LichSuModel() {
		super();
	}

	public LichSuModel(int id, String tenPhong, int idKhachSan, String tenKhachSan, Date ngayDat, Date ngayDen,
			Date ngayTra, String ghiChu, String thanhTien, int trangThai, String anhPhong, int soPhongDaDat,
			boolean trangThaiTT, String phuongThucTT) {
		super();
		this.id = id;
		this.tenPhong = tenPhong;
		this.idKhachSan = idKhachSan;
		this.tenKhachSan = tenKhachSan;
		this.ngayDat = ngayDat;
		this.ngayDen = ngayDen;
		this.ngayTra = ngayTra;
		this.ghiChu = ghiChu;
		this.thanhTien = thanhTien;
		this.trangThai = trangThai;
		this.anhPhong = anhPhong;
		this.soPhongDaDat = soPhongDaDat;
		this.trangThaiTT = trangThaiTT;
		this.phuongThucTT = phuongThucTT;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getIdKhachSan() {
		return idKhachSan;
	}

	public void setIdKhachSan(int idKhachSan) {
		this.idKhachSan = idKhachSan;
	}

	public String getTenKhachSan() {
		return tenKhachSan;
	}

	public void setTenKhachSan(String tenKhachSan) {
		this.tenKhachSan = tenKhachSan;
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

	public String getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getAnhPhong() {
		return anhPhong;
	}

	public void setAnhPhong(String anhPhong) {
		this.anhPhong = anhPhong;
	}

	public int getSoPhongDaDat() {
		return soPhongDaDat;
	}

	public void setSoPhongDaDat(int soPhongDaDat) {
		this.soPhongDaDat = soPhongDaDat;
	}

	public boolean isTrangThaiTT() {
		return trangThaiTT;
	}

	public void setTrangThaiTT(boolean trangThaiTT) {
		this.trangThaiTT = trangThaiTT;
	}

	public String getPhuongThucTT() {
		return phuongThucTT;
	}

	public void setPhuongThucTT(String phuongThucTT) {
		this.phuongThucTT = phuongThucTT;
	}

	@Override
	public String toString() {
		return "LichSuModel [id=" + id + ", tenPhong=" + tenPhong + ", idKhachSan=" + idKhachSan + ", tenKhachSan="
				+ tenKhachSan + ", ngayDat=" + ngayDat + ", ngayDen=" + ngayDen + ", ngayTra=" + ngayTra + ", ghiChu="
				+ ghiChu + ", thanhTien=" + thanhTien + ", trangThai=" + trangThai + ", anhPhong=" + anhPhong + "]";
	}
}
