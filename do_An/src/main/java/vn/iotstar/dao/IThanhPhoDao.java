package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.ThanhPhoModel;

public interface IThanhPhoDao {
	
	List <ThanhPhoModel> findAll();
	
	void insert (ThanhPhoModel thanhpho);
	
	void update (ThanhPhoModel thanhpho);
	
	void delete (int idthanhpho);
	
	ThanhPhoModel findByName(String tenDiaDiem);
}
