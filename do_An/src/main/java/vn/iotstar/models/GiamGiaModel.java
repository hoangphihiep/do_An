package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class GiamGiaModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int id;
	String maGiamGia;
	int phanTramGiamGia;
	Date ngayBatDau;
	Date ngayKetThuc;
	int soLuongMa;
	String apDung;
	
	int soLanDaSuDung;
	int idUser;
	int idKhach;
	boolean status;
	int idKhachHang;
	
	public GiamGiaModel() {
		super();
	}

	public GiamGiaModel(String maGiamGia, int phanTramGiamGia, Date ngayBatDau, Date ngayKetThuc, int soLuongMa, int soLanDaSuDung, int idUser, String apDung) {
		super();
		this.maGiamGia = maGiamGia;
		this.phanTramGiamGia = phanTramGiamGia;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soLuongMa = soLuongMa;
		this.idUser = idUser;
		this.apDung = apDung;
		this.soLanDaSuDung = soLanDaSuDung;
	}
	
	

	public GiamGiaModel(int id, String maGiamGia, int phanTramGiamGia, Date ngayBatDau, Date ngayKetThuc, int soLuongMa,
			String apDung, int soLanDaSuDung, int idUser) {
		super();
		this.id = id;
		this.maGiamGia = maGiamGia;
		this.phanTramGiamGia = phanTramGiamGia;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soLuongMa = soLuongMa;
		this.apDung = apDung;
		this.soLanDaSuDung = soLanDaSuDung;
		this.idUser = idUser;
	}
	
	public GiamGiaModel(int id, int idKhach) {
		super();
		this.id = id;
		this.idKhach = idKhach;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaGiamGia() {
		return maGiamGia;
	}

	public void setMaGiamGia(String maGiamGia) {
		this.maGiamGia = maGiamGia;
	}

	public int getPhanTramGiamGia() {
		return phanTramGiamGia;
	}

	public void setPhanTramGiamGia(int phanTramGiamGia) {
		this.phanTramGiamGia = phanTramGiamGia;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getSoLuongMa() {
		return soLuongMa;
	}

	public void setSoLuongMa(int soLuongMa) {
		this.soLuongMa = soLuongMa;
	}
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getApDung() {
		return apDung;
	}

	public void setApDung(String apDung) {
		this.apDung = apDung;
	}

	public int getSoLanDaSuDung() {
		return soLanDaSuDung;
	}

	public void setSoLanDaSuDung(int soLanDaSuDung) {
		this.soLanDaSuDung = soLanDaSuDung;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getIdKhach() {
		return idKhach;
	}
	

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public void setIdKhach(int idKhach) {
		this.idKhach = idKhach;
	}

	@Override
	public String toString() {
		return "GiamGiaModel [id=" + id + ", maGiamGia=" + maGiamGia + ", phanTramGiamGia=" + phanTramGiamGia
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", soLuongMa=" + soLuongMa
				+ ", apDung=" + apDung + ", soLanDaSuDung=" + soLanDaSuDung + ", idUser=" + idUser + "]";
	}
	
}
