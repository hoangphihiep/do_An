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
	public List<KhachSanModel> findByIdDiaDiem(int currentPage, int idDiaDiem) {
		return khachSanDao.findByIdDiaDiem(currentPage, idDiaDiem);
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
	public int countAllByIdDiaDiem(int idDiaDiem) {
		return khachSanDao.countAllByIdDiaDiem(idDiaDiem);
	}

	@Override
	public int countAllByIdLoaiKS(int idLoaiKS) {
		// TODO Auto-generated method stub
		return khachSanDao.countAllByIdLoaiKS(idLoaiKS);
	}

	@Override
	public List<KhachSanModel> findByIdDiaDiem(int idDiaDiem) {
		return khachSanDao.findByIdDiaDiem(idDiaDiem);
	}

	@Override
	public List<KhachSanModel> findByIdLoaiKhachSan(int idLoaiKhachSan) {
		return khachSanDao.findByIdLoaiKhachSan(idLoaiKhachSan);
	}

	@Override
	public int maxId() {
		return khachSanDao.maxId();
	}

	@Override
	public boolean register(KhachSanModel khachSan) {
		return true;
	}

	@Override
	public KhachSanModel findByName(String tenKS) {
		return khachSanDao.findByName(tenKS);
	}

	@Override
	public List<KhachSanModel> findByIdUser(int idUser) {
		return khachSanDao.findByIdUser(idUser);
	}

	@Override
	public List<KhachSanModel> findByDatPhong() {
		return khachSanDao.findByDatPhong();
	}

}
