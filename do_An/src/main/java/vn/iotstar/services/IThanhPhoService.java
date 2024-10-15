package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.ThanhPhoModel;

public interface IThanhPhoService {
	List<ThanhPhoModel> findAll();

	void insert(ThanhPhoModel thanhpho);

	void update(ThanhPhoModel thanhpho);

	void delete(int idthanhpho);
	
	ThanhPhoModel findByName(String tenDiaDiem);
}
