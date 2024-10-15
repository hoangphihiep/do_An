package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.PhongModel;

public interface IPhongService {
	
	List<PhongModel> findAll();

	void insert(PhongModel phong);

	void update(PhongModel phong);

	void delete(int idPhong);

	List<PhongModel> findByIdKhachSan(int idKhachSan);
}
