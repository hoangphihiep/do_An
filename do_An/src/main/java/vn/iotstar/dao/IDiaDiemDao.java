package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.DiaDiemModel;

public interface IDiaDiemDao {
	
	List <DiaDiemModel> findAll();
	
	void insert (DiaDiemModel diaDiem);
	
	void update (DiaDiemModel diaDiem);
	
	void delete (int idDiaDiem);
	
	DiaDiemModel findByName(String tenDiaDiem);
}
