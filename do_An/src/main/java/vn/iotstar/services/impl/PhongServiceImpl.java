package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IPhongDao;
import vn.iotstar.dao.impl.PhongDaoImpl;
import vn.iotstar.models.PhongModel;
import vn.iotstar.services.IPhongService;

public class PhongServiceImpl implements IPhongService {

	IPhongDao phongDao = new PhongDaoImpl();
	@Override
	public List<PhongModel> findAll() {
		return phongDao.findAll();
	}

	@Override
	public void insert(PhongModel phong) {
		phongDao.insert(phong);
	}

	@Override
	public void update(PhongModel phong) {
		phongDao.update(phong);
	}

	@Override
	public void delete(int idPhong) {
		phongDao.delete(idPhong);
	}

	@Override
	public List<PhongModel> findByIdKhachSan(int idKhachSan) {
		return phongDao.findByIdKhachSan(idKhachSan);
	}

	@Override
	public List<PhongModel> phongMinByIdKhachSan(int idKhachSan) {
		return phongDao.phongMinByIdKhachSan(idKhachSan);
	}

	@Override
	public PhongModel findById(int id) {
		return phongDao.findById(id);
	}

	@Override
	public void updateSLPhong(int SLPhongDat, int soPhongTrong, int SLPhongD, int IdPhong) {
		phongDao.updateSLPhong(SLPhongDat, soPhongTrong, SLPhongD, IdPhong);
	}

	@Override
	public void update2(PhongModel phong) {
		phongDao.update2(phong);
	}

}
