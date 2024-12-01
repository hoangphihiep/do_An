package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IThichKhachSanDao;
import vn.iotstar.dao.impl.ThichKhachSanDaoImpl;
import vn.iotstar.models.ThichKhachSanModel;
import vn.iotstar.services.IThichKhachSanService;

public class ThichKhachSanServiceImpl implements IThichKhachSanService {
	
	IThichKhachSanDao thichKhachSanDao = new ThichKhachSanDaoImpl();
	@Override
	public boolean isHotelLikedByUser(int idUser, int idKS) {
		return thichKhachSanDao.isHotelLikedByUser(idUser, idKS);
	}

	@Override
	public void likeHotel(int idUser, int idKS) {
		thichKhachSanDao.likeHotel(idUser, idKS);
	}

	@Override
	public void unlikeHotel(int idUser, int idKS) {
		thichKhachSanDao.unlikeHotel(idUser, idKS);
	}

	@Override
	public List<ThichKhachSanModel> listLikeHotel(int idUser) {
		return thichKhachSanDao.listLikeHotel(idUser);
	}

	@Override
	public List<ThichKhachSanModel> findAll(int currentPage, int idUser) {
		return thichKhachSanDao.findAll(currentPage, idUser);
	}

	@Override
	public int countAll() {
		return thichKhachSanDao.countAll();
	}

}
