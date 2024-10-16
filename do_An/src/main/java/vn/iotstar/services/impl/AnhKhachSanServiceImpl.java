package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IAnhKhachSanDao;
import vn.iotstar.dao.impl.AnhKhachSanDaoImpl;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.services.IAnhKhachSanService;

public class AnhKhachSanServiceImpl implements IAnhKhachSanService {

	IAnhKhachSanDao anhKhachSanDao = new AnhKhachSanDaoImpl();
	@Override
	public List<AnhKhachSanModel> findAll() {
		return anhKhachSanDao.findAll();
	}

	@Override
	public void insert(AnhKhachSanModel anhKhachSan) {
		anhKhachSanDao.insert(anhKhachSan);
	}

	@Override
	public void update(AnhKhachSanModel anhKhachSan) {
		anhKhachSanDao.update(anhKhachSan);
	}

	@Override
	public void delete(int idAnhKhachSan) {
		anhKhachSanDao.delete(idAnhKhachSan);
	}

	@Override
	public List<AnhKhachSanModel> findByIdKhachSan(int idKhachSan) {
		return anhKhachSanDao.findByIdKhachSan(idKhachSan);
	}

}
