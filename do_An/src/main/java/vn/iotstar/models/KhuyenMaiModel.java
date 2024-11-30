package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.IPhongService;
import vn.iotstar.services.impl.KhachSanServiceImpl;
import vn.iotstar.services.impl.PhongServiceImpl;

public class KhuyenMaiModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String ten;
	private String moTa;
	private int giaTriGiam;
	private Date thoiGianBatDau;
	private Date thoiGianKetThuc;
	private Integer idPhong;
	private int idKS;
	private int status;
	private PhongModel phong;
	private KhachSanModel khachsan;
	
	IPhongService phongService = new PhongServiceImpl();
	IKhachSanService khachSanService = new KhachSanServiceImpl();
	public KhuyenMaiModel() {
		super();
	}
	public KhuyenMaiModel(int id, String ten, String moTa, int giaTriGiam, Date thoiGianBatDau, Date thoiGianKetThuc,
			Integer idPhong, int idKS, int status) {
		super();
		this.id = id;
		this.ten = ten;
		this.moTa = moTa;
		this.giaTriGiam = giaTriGiam;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.idPhong = idPhong;
		this.idKS = idKS;
		this.status = status;
		if (idPhong != null) {
			phong = phongService.findById(idPhong);
		}
		khachsan = khachSanService.findById(idKS);
	}
	public KhuyenMaiModel(String ten, String moTa, int giaTriGiam, Date thoiGianBatDau, Date thoiGianKetThuc,
			Integer idPhong, int idKS, int status) {
		super();
		this.ten = ten;
		this.moTa = moTa;
		this.giaTriGiam = giaTriGiam;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.idPhong = idPhong;
		this.idKS = idKS;
		this.status = status;
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
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getGiaTriGiam() {
		return giaTriGiam;
	}
	public void setGiaTriGiam(int giaTriGiam) {
		this.giaTriGiam = giaTriGiam;
	}
	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public Integer getIdPhong() {
		return idPhong;
	}
	public void setIdPhong(Integer idPhong) {
		this.idPhong = idPhong;
	}
	public int getIdKS() {
		return idKS;
	}
	public void setIdKS(int idKS) {
		this.idKS = idKS;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public PhongModel getPhong() {
		return phong;
	}
	public void setPhong(PhongModel phong) {
		this.phong = phong;
	}
	public KhachSanModel getKhachsan() {
		return khachsan;
	}
	public void setKhachsan(KhachSanModel khachsan) {
		this.khachsan = khachsan;
	}
}
