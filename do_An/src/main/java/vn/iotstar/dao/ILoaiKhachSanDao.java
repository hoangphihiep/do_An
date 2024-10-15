package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.LoaiKhachSanModel;

public interface ILoaiKhachSanDao {
	
	List <LoaiKhachSanModel> findAll();
	
	void insert (LoaiKhachSanModel loaikhachsan);
	
	void update (LoaiKhachSanModel loaikhachsan);
	
	void delete (int idloaikhachsan);
	
	List <LoaiKhachSanModel> listTenLoaiKhachSan();
}
