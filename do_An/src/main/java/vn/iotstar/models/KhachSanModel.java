package vn.iotstar.models;

import java.io.Serializable;

import vn.iotstar.services.IUserServices;
import vn.iotstar.services.impl.UserServiceImpl;

public class KhachSanModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int id;
    String ten;
    String diaChi;
    int idUser;
    int cachTrungTam;
    String moTa;
    boolean giapBien;
    int danhGia;
    int idDiaDiem;
    String tenDiaDiem;
    int idLoaiKhachSan;
    String tenLoaiKhachSan;
    String urlHinhAnhThanhPho;
    UserModel sheller = new UserModel();
    IUserServices userService = new UserServiceImpl();
    int status;
    boolean active;
    
	
    public KhachSanModel() {
		super();
	}

	public KhachSanModel(int id, String ten, String diaChi, int idUser, int cachTrungTam, String moTa,
			boolean giapBien, int danhGia, int idDiaDiem, String tenDiaDiem, int idLoaiKhachSan,
			String tenLoaiKhachSan, String urlHinhAnhThanhPho, int status, boolean active) {
		super();
		this.id = id;
		this.ten = ten;
		this.diaChi = diaChi;
		this.idUser = idUser;
		this.cachTrungTam = cachTrungTam;
		this.moTa = moTa;
		this.giapBien = giapBien;
		this.danhGia = danhGia;
		this.idDiaDiem = idDiaDiem;
		this.tenDiaDiem = tenDiaDiem;
		this.idLoaiKhachSan = idLoaiKhachSan;
		this.tenLoaiKhachSan = tenLoaiKhachSan;
		this.urlHinhAnhThanhPho = urlHinhAnhThanhPho;
		this.status = status;
		this.active = active;
		sheller = userService.findById(idUser);
	}
	

	public KhachSanModel(int id, String ten, String diaChi, int idUser, int cachTrungTam, String moTa, boolean giapBien,
			int danhGia, int idDiaDiem, String tenDiaDiem, int idLoaiKhachSan, String tenLoaiKhachSan,
			String urlHinhAnhThanhPho) {
		super();
		this.id = id;
		this.ten = ten;
		this.diaChi = diaChi;
		this.idUser = idUser;
		this.cachTrungTam = cachTrungTam;
		this.moTa = moTa;
		this.giapBien = giapBien;
		this.danhGia = danhGia;
		this.idDiaDiem = idDiaDiem;
		this.tenDiaDiem = tenDiaDiem;
		this.idLoaiKhachSan = idLoaiKhachSan;
		this.tenLoaiKhachSan = tenLoaiKhachSan;
		this.urlHinhAnhThanhPho = urlHinhAnhThanhPho;
		sheller = userService.findById(idUser);
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getidUser() {
		return idUser;
	}

	public void setidUser(int idUser) {
		this.idUser = idUser;
	}

	public int getCachTrungTam() {
		return cachTrungTam;
	}

	public void setCachTrungTam(int cachTrungTam) {
		this.cachTrungTam = cachTrungTam;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public boolean isGiapBien() {
		return giapBien;
	}

	public void setGiapBien(boolean giapBien) {
		this.giapBien = giapBien;
	}

	public int getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}

	public int getIdDiaDiem() {
		return idDiaDiem;
	}

	public void setIdDiaDiem(int idDiaDiem) {
		this.idDiaDiem = idDiaDiem;
	}

	public String getTenDiaDiem() {
		return tenDiaDiem;
	}

	public void setTenDiaDiem(String tenDiaDiem) {
		this.tenDiaDiem = tenDiaDiem;
	}

	public int getIdLoaiKhachSan() {
		return idLoaiKhachSan;
	}

	public void setIdLoaiKhachSan(int idLoaiKhachSan) {
		this.idLoaiKhachSan = idLoaiKhachSan;
	}

	public String getTenLoaiKhachSan() {
		return tenLoaiKhachSan;
	}

	public void setTenLoaiKhachSan(String tenLoaiKhachSan) {
		this.tenLoaiKhachSan = tenLoaiKhachSan;
	}

	public String getUrlHinhAnhThanhPho() {
		return urlHinhAnhThanhPho;
	}

	public void setUrlHinhAnhThanhPho(String urlHinhAnhThanhPho) {
		this.urlHinhAnhThanhPho = urlHinhAnhThanhPho;
	}
	
	public UserModel getSheller() {
		return sheller;
	}

	public void setSheller(UserModel sheller) {
		this.sheller = sheller;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "KhachSanModel [id=" + id + ", ten=" + ten + ", diaChi=" + diaChi 
				+ ", cachTrungTam=" + cachTrungTam + ", moTa=" + moTa + ", giapBien=" + giapBien + ", danhGia="
				+ danhGia + ", idThanhPho=" + idDiaDiem + ", tenThanhPho=" + tenDiaDiem
				+ ", idLoaiKhachSan=" + idLoaiKhachSan + ", tenLoaiKhachSan=" + tenLoaiKhachSan
				+ ", urlHinhAnhThanhPho=" + urlHinhAnhThanhPho + "]";
	}
}
