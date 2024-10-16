package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IDanhGiaDao;
import vn.iotstar.dao.impl.DanhGiaDaoImpl;
import vn.iotstar.models.DanhGiaModel;
import vn.iotstar.services.IDanhGiaService;

public class DanhGiaServiceImpl implements IDanhGiaService {

	IDanhGiaDao danhGiaDao = new DanhGiaDaoImpl();
	@Override
	public List<DanhGiaModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(DanhGiaModel danhGia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DanhGiaModel danhGia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idDanhGia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DanhGiaModel> findByIdKhachSan(int idKhachSan) {
		return danhGiaDao.findByIdKhachSan(idKhachSan);
	}

	@Override
	public List<DanhGiaModel> countUserByIdKhachSan(int idKhachSan) {
		// TODO Auto-generated method stub
		return null;
	}

}
