package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.DiaDiemModel;

public interface IDiaDiemService {
	List<DiaDiemModel> findAll();

	void insert(DiaDiemModel diaDiem);

	void update(DiaDiemModel diaDiem);

	void delete(int idDiaDiem);
	
	DiaDiemModel findByName(String tenDiaDiem);
}
