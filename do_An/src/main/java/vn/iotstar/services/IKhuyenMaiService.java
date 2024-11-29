package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.KhuyenMaiModel;

public interface IKhuyenMaiService {
	
	void insert (KhuyenMaiModel khuyenMai);
	
	void insert2 (KhuyenMaiModel khuyenMai);
	
	void update (KhuyenMaiModel khuyenMai);
	
	void delete (int idKhuyenMai);
	
	List<KhuyenMaiModel> findByIdSheller (int idSheller);
	
	KhuyenMaiModel findById (int idKhuyenMai);
	
	List<KhuyenMaiModel> findAll ();
}
