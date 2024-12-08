package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.LichSuModel;

public interface ILichSuDatPhong {
	
	List<LichSuModel> findByIdUser(int idUser);
	
	List<LichSuModel> findAll(int currentPage, int idUser);
	
	int countAll(int idUser);
}
