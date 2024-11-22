package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.GiamGiaModel;

public interface IGiamGiaService {

	void insert (GiamGiaModel giamGia);
	
	void update (GiamGiaModel giamGia);
	
	void delete (int idGiamGia);
	
	List<GiamGiaModel> findByIdSheller (int idSheller);
	
	GiamGiaModel findById (int idGiamGia);
	
	void insertMaGiamGiaCuaKhach (int idGiamGia, int idKhach);
	
	void updateSoLanDaSuDung (int soLanDaSuDung, int idGiamGia);
	
	boolean checkExistIdUser (int idUser, int idGiamGia);
}
