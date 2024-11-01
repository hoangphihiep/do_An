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
	public List<KhachSanModel> findByIdThanhPho(int currentPage, int idThanhPho) {
		return khachSanDao.findByIdThanhPho(currentPage, idThanhPho);
	}

	@Override
	public KhachSanModel findById(int id) {
		return khachSanDao.findById(id);
	}

	@Override
	public List<KhachSanModel> findByIdLoaiKhachSan(int currentPage, int idLoaiKhachSan) {
		return khachSanDao.findByIdLoaiKhachSan(currentPage, idLoaiKhachSan);
	}

	@Override
	public int countAllByIdThanhPho(int idThanhPho) {
		return khachSanDao.countAllByIdThanhPho(idThanhPho);
	}

	@Override
	public int countAllByIdLoaiKS(int idLoaiKS) {
		// TODO Auto-generated method stub
		return khachSanDao.countAllByIdLoaiKS(idLoaiKS);
	}

	@Override
	public List<KhachSanModel> findByIdThanhPho(int idThanhPho) {
		return khachSanDao.findByIdThanhPho(idThanhPho);
	}

	@Override
	public List<KhachSanModel> findByIdLoaiKhachSan(int idLoaiKhachSan) {
		return khachSanDao.findByIdLoaiKhachSan(idLoaiKhachSan);
	}

}
