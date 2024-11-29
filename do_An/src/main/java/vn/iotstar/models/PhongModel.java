package vn.iotstar.models;

import java.io.Serializable;

public class PhongModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int id;
    String ten;
    int dienTich;
    int giaThue;
    String tienNghi;
    String moTa;
    int loaiGiuong;
    int idKhachSan;
    String tenKhachSan;
    int soPhongTrong;
    int soPhongDaDat;
    int sucChuaToiDa;
    String anhPhong;
    int tienThueSauKhiGiam;
	
    public PhongModel() {
		super();
	}

	public PhongModel(int id, String ten, int dienTich, int giaThue, String tienNghi, String moTa, int loaiGiuong,
			int idKhachSan, String tenKhachSan) {
		super();
		this.id = id;
		this.ten = ten;
		this.dienTich = dienTich;
		this.giaThue = giaThue;
		this.tienNghi = tienNghi;
		this.moTa = moTa;
		this.loaiGiuong = loaiGiuong;
		this.idKhachSan = idKhachSan;
		this.tenKhachSan = tenKhachSan;
	}
	
	public PhongModel(int id, String ten, int dienTich, int giaThue, String tienNghi, String moTa, int loaiGiuong,
			int idKhachSan, int soPhongTrong, int soPhongDaDat, int sucChuaToiDa, String anhPhong) {
		super();
		this.id = id;
		this.ten = ten;
		this.dienTich = dienTich;
		this.giaThue = giaThue;
		this.tienNghi = tienNghi;
		this.moTa = moTa;
		this.loaiGiuong = loaiGiuong;
		this.idKhachSan = idKhachSan;
		this.soPhongTrong = soPhongTrong;
		this.soPhongDaDat = soPhongDaDat;
		this.sucChuaToiDa = sucChuaToiDa;
		this.anhPhong = anhPhong;
	}
	
	public PhongModel(int id, String ten, int dienTich, int giaThue, String tienNghi, String moTa, int loaiGiuong,
			int idKhachSan, String tenKhachSan, int soPhongTrong, int soPhongDaDat, int sucChuaToiDa, String anhPhong) {
		super();
		this.id = id;
		this.ten = ten;
		this.dienTich = dienTich;
		this.giaThue = giaThue;
		this.tienNghi = tienNghi;
		this.moTa = moTa;
		this.loaiGiuong = loaiGiuong;
		this.idKhachSan = idKhachSan;
		this.tenKhachSan = tenKhachSan;
		this.soPhongTrong = soPhongTrong;
		this.soPhongDaDat = soPhongDaDat;
		this.sucChuaToiDa = sucChuaToiDa;
		this.anhPhong = anhPhong;
	}
	
	public PhongModel(String ten, int dienTich, int giaThue, String tienNghi, String moTa, int loaiGiuong,
			int idKhachSan, int soPhongTrong, int soPhongDaDat, int sucChuaToiDa, String anhPhong) {
		super();
		this.ten = ten;
		this.dienTich = dienTich;
		this.giaThue = giaThue;
		this.tienNghi = tienNghi;
		this.moTa = moTa;
		this.loaiGiuong = loaiGiuong;
		this.idKhachSan = idKhachSan;
		this.soPhongTrong = soPhongTrong;
		this.soPhongDaDat = soPhongDaDat;
		this.sucChuaToiDa = sucChuaToiDa;
		this.anhPhong = anhPhong;
	}

	public PhongModel(int idKhachSan, int giaThue) {
		super();
		this.giaThue = giaThue;
		this.idKhachSan = idKhachSan;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getDienTich() {
		return dienTich;
	}

	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}

	public int getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(int giaThue) {
		this.giaThue = giaThue;
	}

	public String getTienNghi() {
		return tienNghi;
	}

	public void setTienNghi(String tienNghi) {
		this.tienNghi = tienNghi;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getLoaiGiuong() {
		return loaiGiuong;
	}

	public void setLoaiGiuong(int loaiGiuong) {
		this.loaiGiuong = loaiGiuong;
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

	public int getSoPhongTrong() {
		return soPhongTrong;
	}

	public void setSoPhongTrong(int soPhongTrong) {
		this.soPhongTrong = soPhongTrong;
	}

	public int getSoPhongDaDat() {
		return soPhongDaDat;
	}

	public void setSoPhongDaDat(int soPhongDaDat) {
		this.soPhongDaDat = soPhongDaDat;
	}

	public int getSucChuaToiDa() {
		return sucChuaToiDa;
	}

	public void setSucChuaToiDa(int sucChuaToiDa) {
		this.sucChuaToiDa = sucChuaToiDa;
	}

	public String getAnhPhong() {
		return anhPhong;
	}

	public void setAnhPhong(String anhPhong) {
		this.anhPhong = anhPhong;
	}
	
	public int getTienThueSauKhiGiam() {
		return tienThueSauKhiGiam;
	}

	public void setTienThueSauKhiGiam(int tienThueSauKhiGiam) {
		this.tienThueSauKhiGiam = tienThueSauKhiGiam;
	}

	@Override
	public String toString() {
		return "PhongModel [id=" + id + ", ten=" + ten + ", dienTich=" + dienTich + ", giaThue=" + giaThue
				+ ", tienNghi=" + tienNghi + ", moTa=" + moTa + ", loaiGiuong=" + loaiGiuong + ", idKhachSan="
				+ idKhachSan + ", tenKhachSan=" + tenKhachSan + ", soPhongTrong=" + soPhongTrong + ", soPhongDaDat="
				+ soPhongDaDat + ", sucChuaToiDa=" + sucChuaToiDa + ", anhPhong=" + anhPhong + "]";
	}
}
