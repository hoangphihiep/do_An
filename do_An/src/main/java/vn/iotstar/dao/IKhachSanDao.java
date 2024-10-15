package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.KhachSanModel;

public interface IKhachSanDao {
	List<KhachSanModel> findAll();

	void insert(KhachSanModel khachsan);

	void update(KhachSanModel khachsan);

	void delete(int idkhachsan);
	
	List<KhachSanModel> findByIdThanhPho(int idThanhPho);
	
	KhachSanModel findById(int id);
}
