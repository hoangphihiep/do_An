package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.AnhKhachSanModel;

public interface IAnhKhachSanService {
	List<AnhKhachSanModel> findAll();

	void insert(AnhKhachSanModel anhKhachSan);

	void update(AnhKhachSanModel anhKhachSan);

	void delete(int idAnhKhachSan);
	
	List<AnhKhachSanModel> findByIdKhachSan(int idKhachSan);
}
