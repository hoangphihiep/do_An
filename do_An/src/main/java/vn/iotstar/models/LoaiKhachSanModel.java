package vn.iotstar.models;

import java.io.Serializable;

public class LoaiKhachSanModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int id;
    String ten;
    String moTa;
    String urlHinhAnh;
    int soKhachSan;
    
	public LoaiKhachSanModel() {
		super();
	}

	public LoaiKhachSanModel(int id, String ten, String moTa, String urlHinhAnh, int soKhachSan) {
		super();
		this.id = id;
		this.ten = ten;
		this.moTa = moTa;
		this.urlHinhAnh = urlHinhAnh;
		this.soKhachSan = soKhachSan;
	}

	public LoaiKhachSanModel(String ten) {
		super();
		this.ten = ten;
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

	public String getUrlHinhAnh() {
		return urlHinhAnh;
	}

	public void setUrlHinhAnh(String urlHinhAnh) {
		this.urlHinhAnh = urlHinhAnh;
	}

	public int getSoKhachSan() {
		return soKhachSan;
	}

	public void setSoKhachSan(int soKhachSan) {
		this.soKhachSan = soKhachSan;
	}

	@Override
	public String toString() {
		return "LoaiKhachSanModel [id=" + id + ", ten=" + ten + ", moTa=" + moTa + ", urlHinhAnh=" + urlHinhAnh
				+ ", soKhachSan=" + soKhachSan + "]";
	}
}
