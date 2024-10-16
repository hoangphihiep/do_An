package vn.iotstar.models;

import java.io.Serializable;

public class DanhGiaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	int id;
	int diem;
	String noiDung;
	int idKhachHang;
	int idKhachSan;
	int soLuongKhachHang;
	
	public DanhGiaModel(int id, int diem, String noiDung, int idKhachHang, int idKhachSan) {
		super();
		this.id = id;
		this.diem = diem;
		this.noiDung = noiDung;
		this.idKhachHang = idKhachHang;
		this.idKhachSan = idKhachSan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getIdKhachSan() {
		return idKhachSan;
	}

	public void setIdKhachSan(int idKhachSan) {
		this.idKhachSan = idKhachSan;
	}

	public int getSoLuongKhachHang() {
		return soLuongKhachHang;
	}

	public void setSoLuongKhachHang(int soLuongKhachHang) {
		this.soLuongKhachHang = soLuongKhachHang;
	}

	@Override
	public String toString() {
		return "DanhGiaModel [id=" + id + ", diem=" + diem + ", noiDung=" + noiDung + ", idKhachHang=" + idKhachHang
				+ ", tenKhachHang="+ ", idKhachSan=" + idKhachSan + "]";
	}
}
