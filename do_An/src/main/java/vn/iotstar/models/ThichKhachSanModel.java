package vn.iotstar.models;

import java.io.Serializable;

public class ThichKhachSanModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int idUser;
	private int idKS;
	private KhachSanModel ks;
	
	public ThichKhachSanModel() {
		super();
	}
	
	public ThichKhachSanModel(int id, int idUser, int idKS) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idKS = idKS;
	}

	public ThichKhachSanModel(int id, int idUser, int idKS, KhachSanModel ks) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idKS = idKS;
		this.ks = ks;
	}

	public ThichKhachSanModel(int idUser, int idKS) {
		super();
		this.idUser = idUser;
		this.idKS = idKS;
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

	public int getIdKS() {
		return idKS;
	}

	public void setIdKS(int idKS) {
		this.idKS = idKS;
	}

	public KhachSanModel getKs() {
		return ks;
	}

	public void setKs(KhachSanModel ks) {
		this.ks = ks;
	}
}
