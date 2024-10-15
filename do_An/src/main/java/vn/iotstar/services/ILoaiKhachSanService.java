package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.LoaiKhachSanModel;

public interface ILoaiKhachSanService {
	List<LoaiKhachSanModel> findAll();

	void insert(LoaiKhachSanModel loaikhachsan);

	void update(LoaiKhachSanModel loaikhachsan);

	void delete(int idloaikhachsan);
	
	List <LoaiKhachSanModel> listTenLoaiKhachSan();
}
