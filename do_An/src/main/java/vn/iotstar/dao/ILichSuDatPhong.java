package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.LichSuModel;

public interface ILichSuDatPhong {
	
	List<LichSuModel> findByIdUser(int idUser);
}
