package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ILoaiKhachSanDao;
import vn.iotstar.dao.impl.LoaiKhachSanImpl;
import vn.iotstar.models.LoaiKhachSanModel;
import vn.iotstar.services.ILoaiKhachSanService;

public class LoaiKhachSanServiceImpl implements ILoaiKhachSanService{

	ILoaiKhachSanDao loaiKhachSanDao = new LoaiKhachSanImpl();
	@Override
	public List<LoaiKhachSanModel> findAll() {
		return loaiKhachSanDao.findAll();
	}

	@Override
	public void insert(LoaiKhachSanModel loaikhachsan) {
		loaiKhachSanDao.insert(loaikhachsan);
	}

	@Override
	public void update(LoaiKhachSanModel loaikhachsan) {
		loaiKhachSanDao.update(loaikhachsan);
	}

	@Override
	public void delete(int idloaikhachsan) {
		loaiKhachSanDao.delete(idloaikhachsan);
	}

	@Override
	public List<LoaiKhachSanModel> listTenLoaiKhachSan() {
		return loaiKhachSanDao.listTenLoaiKhachSan();
	}

}
