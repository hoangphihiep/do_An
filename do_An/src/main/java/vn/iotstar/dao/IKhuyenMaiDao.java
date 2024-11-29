package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.KhuyenMaiModel;

public interface IKhuyenMaiDao {

	void insert (KhuyenMaiModel khuyenMai);
	
	void insert2 (KhuyenMaiModel khuyenMai);
	
	void update (KhuyenMaiModel khuyenMai);
	
	void update2 (KhuyenMaiModel khuyenMai);
	
	void delete (int idKhuyenMai);
	
	List<KhuyenMaiModel> findByIdSheller (int idSheller);
	
	KhuyenMaiModel findById (int idKhuyenMai);
	
	List<KhuyenMaiModel> findAll ();
}
