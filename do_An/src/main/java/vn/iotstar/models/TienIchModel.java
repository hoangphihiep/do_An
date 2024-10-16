package vn.iotstar.models;

import java.io.Serializable;

public class TienIchModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int id;
	String tenTienNghi;
	int IdKhachSan;
	int IdLoaiTienNghi;
	
	public TienIchModel(int id, String tenTienNghi, int idKhachSan, int idLoaiTienNghi) {
		super();
		this.id = id;
		this.tenTienNghi = tenTienNghi;
		IdKhachSan = idKhachSan;
		IdLoaiTienNghi = idLoaiTienNghi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTienNghi() {
		return tenTienNghi;
	}

	public void setTenTienNghi(String tenTienNghi) {
		this.tenTienNghi = tenTienNghi;
	}

	public int getIdKhachSan() {
		return IdKhachSan;
	}

	public void setIdKhachSan(int idKhachSan) {
		IdKhachSan = idKhachSan;
	}

	public int getIdLoaiTienNghi() {
		return IdLoaiTienNghi;
	}

	public void setIdLoaiTienNghi(int idLoaiTienNghi) {
		IdLoaiTienNghi = idLoaiTienNghi;
	}

	@Override
	public String toString() {
		return "TienNghiModel [id=" + id + ", tenTienNghi=" + tenTienNghi + ", IdKhachSan=" + IdKhachSan
				+ ", IdLoaiTienNghi=" + IdLoaiTienNghi + "]";
	}
}
