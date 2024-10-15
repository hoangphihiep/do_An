package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.PhongModel;

public interface IPhongDao {
	
	List<PhongModel> findAll();

	void insert(PhongModel phong);

	void update(PhongModel phong);

	void delete(int idPhong);
	
	List<PhongModel> findByIdKhachSan(int idKhachSan);
}
