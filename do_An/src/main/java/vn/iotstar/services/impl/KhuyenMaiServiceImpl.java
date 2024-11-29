package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IKhuyenMaiDao;
import vn.iotstar.dao.impl.KhuyenMaiDaoImpl;
import vn.iotstar.models.KhuyenMaiModel;
import vn.iotstar.services.IKhuyenMaiService;

public class KhuyenMaiServiceImpl implements IKhuyenMaiService {

	IKhuyenMaiDao khuyenMaiDao = new KhuyenMaiDaoImpl();
	@Override
	public void insert(KhuyenMaiModel khuyenMai) {
		khuyenMaiDao.insert(khuyenMai);
	}

	@Override
	public void update(KhuyenMaiModel khuyenMai) {
		khuyenMaiDao.update(khuyenMai);
	}

	@Override
	public void delete(int idKhuyenMai) {
		khuyenMaiDao.delete(idKhuyenMai);
	}

	@Override
	public List<KhuyenMaiModel> findByIdSheller(int idSheller) {
		return khuyenMaiDao.findByIdSheller(idSheller);
	}

	@Override
	public void insert2(KhuyenMaiModel khuyenMai) {
		khuyenMaiDao.insert2(khuyenMai);
	}

	@Override
	public KhuyenMaiModel findById(int idKhuyenMai) {
		return khuyenMaiDao.findById(idKhuyenMai);
	}

	@Override
	public List<KhuyenMaiModel> findAll() {
		return khuyenMaiDao.findAll();
	}

}
