package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IThanhPhoDao;
import vn.iotstar.dao.impl.ThanhPhoDaoImpl;
import vn.iotstar.models.ThanhPhoModel;
import vn.iotstar.services.IThanhPhoService;

public class ThanhPhoServiceImpl implements IThanhPhoService {

	IThanhPhoDao thanhPhoDao = new ThanhPhoDaoImpl();
	@Override
	public List<ThanhPhoModel> findAll() {
		return thanhPhoDao.findAll();
	}

	@Override
	public void insert(ThanhPhoModel thanhpho) {
		thanhPhoDao.insert(thanhpho);
	}

	@Override
	public void update(ThanhPhoModel thanhpho) {
		thanhPhoDao.update(thanhpho);
	}

	@Override
	public void delete(int idthanhpho) {
		thanhPhoDao.delete(idthanhpho);
	}

	@Override
	public ThanhPhoModel findByName(String tenDiaDiem) {
		return thanhPhoDao.findByName(tenDiaDiem);
	}

}
