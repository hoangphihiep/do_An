package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IKhachSanDao;
import vn.iotstar.dao.impl.KhachSanImpl;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.services.IKhachSanService;

public class KhachSanServiceImpl implements IKhachSanService {

	IKhachSanDao khachSanDao = new KhachSanImpl();
	@Override
	public List<KhachSanModel> findAll() {
		return khachSanDao.findAll();
	}

	@Override
	public void insert(KhachSanModel khachsan) {
		khachSanDao.insert(khachsan);
	}

	@Override
	public void update(KhachSanModel khachsan) {
		khachSanDao.update(khachsan);
	}

	@Override
	public void delete(int idkhachsan) {
		khachSanDao.delete(idkhachsan);
	}

	@Override
	public List<KhachSanModel> findByIdThanhPho(int idThanhPho) {
		return khachSanDao.findByIdThanhPho(idThanhPho);
	}

	@Override
	public KhachSanModel findById(int id) {
		return khachSanDao.findById(id);
	}

}
