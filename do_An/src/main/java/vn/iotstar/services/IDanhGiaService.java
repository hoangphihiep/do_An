package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.DanhGiaModel;

public interface IDanhGiaService {
	
	List<DanhGiaModel> findAll();

	void insert(DanhGiaModel danhGia);

	void update(DanhGiaModel danhGia);

	void delete(int idDanhGia);
	
	List<DanhGiaModel> findByIdKhachSan(int idKhachSan);
	
	List<DanhGiaModel> countUserByIdKhachSan(int idKhachSan);
}