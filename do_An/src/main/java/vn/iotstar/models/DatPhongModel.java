package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

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
    boolean daHuy;
    int soPhongDaDat;
    boolean thanhToan;
    String phuongThucTT;
    
	public DatPhongModel(int id, int idUser, int idPhong, Date ngayDat, Date ngayDen, Date ngayTra,
			String ghiChu, int thanhTien, boolean daHuy, int soPhongDaDat, boolean thanhToan, String phuongThucTT) {
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
	}

	public DatPhongModel(int idUser, int idPhong, Date ngayDat, Date ngayDen, Date ngayTra, String ghiChu,
			int thanhTien, boolean daHuy, int soPhongDaDat, boolean thanhToan, String phuongThucTT) {
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

	public boolean isDaHuy() {
		return daHuy;
	}

	public void setDaHuy(boolean daHuy) {
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
}
