package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.PhongModel;

public interface IPhongDao {
	
	List<PhongModel> findAll();

	void insert(PhongModel phong);

	void update(PhongModel phong);

	void delete(int idPhong);
	
	void update2 (PhongModel phong);
	
	void updateSLPhong (int SLPhongDat, int soPhongTrong, int SLPhongD,  int IdPhong);
	
	List<PhongModel> findByIdKhachSan(int idKhachSan);
	
	PhongModel findById (int id);
	
	List<PhongModel> phongMinByIdKhachSan (int idKhachSan);
}
