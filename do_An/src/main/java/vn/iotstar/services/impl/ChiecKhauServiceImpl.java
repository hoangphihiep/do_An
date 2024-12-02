package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IChiecKhauDao;
import vn.iotstar.dao.impl.ChiecKhauDaoImpl;
import vn.iotstar.models.ChiecKhauModel;
import vn.iotstar.services.IChiecKhauService;

public class ChiecKhauServiceImpl implements IChiecKhauService {

	IChiecKhauDao chiecKhauDao = new ChiecKhauDaoImpl();
	@Override
	public List<ChiecKhauModel> findAll() {
		return chiecKhauDao.findAll();
	}

	@Override
	public void insert(ChiecKhauModel chiecKhau) {
		chiecKhauDao.insert(chiecKhau);
	}

	@Override
	public void update(ChiecKhauModel chiecKhau) {
		chiecKhauDao.update(chiecKhau);
	}

	@Override
	public void delete(int idChiecKhau) {
		chiecKhauDao.delete(idChiecKhau);
	}

	@Override
	public ChiecKhauModel findById(int idChiecKhau) {
		return chiecKhauDao.findById(idChiecKhau);
	}

	@Override
	public List<ChiecKhauModel> findByIdSheller(int idSheller) {
		return chiecKhauDao.findByIdSheller(idSheller);
	}

	@Override
	public ChiecKhauModel findByIdKS(int idKS) {
		return chiecKhauDao.findByIdKS(idKS);
	}

}
