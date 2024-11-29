package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.PhongModel;

public interface IPhongService {
	
	List<PhongModel> findAll();

	void insert(PhongModel phong);

	void update(PhongModel phong);
	
	void update2 (PhongModel phong);

	void delete(int idPhong);

	List<PhongModel> findByIdKhachSan(int idKhachSan);
	
	PhongModel findById (int id);
	
	List<PhongModel> phongMinByIdKhachSan (int idKhachSan);
	
	void updateSLPhong (int SLPhongDat, int soPhongTrong, int SLPhongD, int IdPhong);
}
