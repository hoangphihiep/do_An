package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.AnhKhachSanModel;

public interface IAnhKhachSanDao {
	
	List<AnhKhachSanModel> findAll();

	void insert(AnhKhachSanModel anhKhachSan);

	void update(AnhKhachSanModel anhKhachSan);

	void delete(int idAnhKhachSan);
	
	List<AnhKhachSanModel> findByIdKhachSan(int idKhachSan);
	
	void deleteByIdKhachSan (int idKS);
	
	AnhKhachSanModel anhChinhCuaKS (int idKS);
}
