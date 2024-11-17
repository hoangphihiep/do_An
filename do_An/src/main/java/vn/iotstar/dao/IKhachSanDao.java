package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.KhachSanModel;

public interface IKhachSanDao {
	List<KhachSanModel> findAll();

	void insert(KhachSanModel khachsan);

	void update(KhachSanModel khachsan);

	void delete(int idkhachsan);
	
	List<KhachSanModel> findByIdDiaDiem(int currentPage, int idDiaDiem);
	
	List<KhachSanModel> findByIdDiaDiem(int idDiaDiem);
	
	KhachSanModel findById(int id);
	
	List<KhachSanModel> findByIdLoaiKhachSan(int currentPage, int idLoaiKhachSan);
	
	List<KhachSanModel> findByIdLoaiKhachSan(int idLoaiKhachSan);
	
	List<KhachSanModel> findAllPage (int indexp);
	
	List<KhachSanModel> findByIdUser(int idUser);
	
	int countAllByIdDiaDiem(int idDiaDiem);
	
	int countAllByIdLoaiKS(int idLoaiKS);
	
	int maxId ();
	
	KhachSanModel findByName(String tenKS);
}
