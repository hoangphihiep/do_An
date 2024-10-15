package vn.iotstar.models;

import java.io.Serializable;

public class AnhKhachSanModel implements Serializable {

	private static final long serialVersionUID = 1L;

	int idAnhKhachSan;
    String vaiTroCuaAnh;
    String urlAnhKhachSan;
    int idKhachSan;
    
	public AnhKhachSanModel(int idAnhKhachSan, String vaiTroCuaAnh, String urlAnhKhachSan, int idKhachSan) {
		super();
		this.idAnhKhachSan = idAnhKhachSan;
		this.vaiTroCuaAnh = vaiTroCuaAnh;
		this.urlAnhKhachSan = urlAnhKhachSan;
		this.idKhachSan = idKhachSan;
	}

	public int getIdAnhKhachSan() {
		return idAnhKhachSan;
	}

	public void setIdAnhKhachSan(int idAnhKhachSan) {
		this.idAnhKhachSan = idAnhKhachSan;
	}

	public String getVaiTroCuaAnh() {
		return vaiTroCuaAnh;
	}

	public void setVaiTroCuaAnh(String vaiTroCuaAnh) {
		this.vaiTroCuaAnh = vaiTroCuaAnh;
	}

	public String getUrlAnhKhachSan() {
		return urlAnhKhachSan;
	}

	public void setUrlAnhKhachSan(String urlAnhKhachSan) {
		this.urlAnhKhachSan = urlAnhKhachSan;
	}

	public int getIdKhachSan() {
		return idKhachSan;
	}

	public void setIdKhachSan(int idKhachSan) {
		this.idKhachSan = idKhachSan;
	}

	@Override
	public String toString() {
		return "AnhKhachSanModel [idAnhKhachSan=" + idAnhKhachSan + ", vaiTroCuaAnh=" + vaiTroCuaAnh
				+ ", urlAnhKhachSan=" + urlAnhKhachSan + ", idKhachSan=" + idKhachSan + "]";
	}
}
