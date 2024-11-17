package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ITienIchDao;
import vn.iotstar.dao.impl.TienIchDaoImpl;
import vn.iotstar.models.TienIchModel;
import vn.iotstar.services.ITienIchService;

public class TienIchServiceImpl implements ITienIchService {

	ITienIchDao tienIchDao = new TienIchDaoImpl();
	@Override
	public List<TienIchModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TienIchModel tienIch) {
		tienIchDao.insert(tienIch);	}

	@Override
	public void update(TienIchModel tienIch) {
		tienIchDao.update(tienIch);
		
	}

	@Override
	public void delete(int idTienIch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TienIchModel> findByIdKhachSan(int idKhachSan) {
		return tienIchDao.findByIdKhachSan(idKhachSan);
	}

	@Override
	public void deleteByIdKhachSan(int idKhachSan) {
		tienIchDao.deleteByIdKhachSan(idKhachSan);
	}

}
