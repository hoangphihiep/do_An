package vn.iotstar.models;

import java.io.Serializable;

import vn.iotstar.services.IKhachSanService;
import vn.iotstar.services.impl.KhachSanServiceImpl;

public class ChiecKhauModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int idKS;
	private int tiLeChiecKhau;
	private KhachSanModel ks;
	
	IKhachSanService khachSanService = new KhachSanServiceImpl();
	
	public ChiecKhauModel() {
		super();
	}

	public ChiecKhauModel(int id, int idKS, int tiLeChiecKhau) {
		super();
		this.id = id;
		this.idKS = idKS;
		this.tiLeChiecKhau = tiLeChiecKhau;
		ks = khachSanService.findById(idKS);
	}

	public ChiecKhauModel(int idKS, int tiLeChiecKhau) {
		super();
		this.idKS = idKS;
		this.tiLeChiecKhau = tiLeChiecKhau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdKS() {
		return idKS;
	}

	public void setIdKS(int idKS) {
		this.idKS = idKS;
	}

	public int getTiLeChiecKhau() {
		return tiLeChiecKhau;
	}

	public void setTiLeChiecKhau(int tiLeChiecKhau) {
		this.tiLeChiecKhau = tiLeChiecKhau;
	}

	public KhachSanModel getKs() {
		return ks;
	}

	public void setKs(KhachSanModel ks) {
		this.ks = ks;
	}
}
