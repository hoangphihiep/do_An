package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IGiamGiaDao;
import vn.iotstar.dao.impl.GiamGiaDaoImpl;
import vn.iotstar.models.GiamGiaModel;
import vn.iotstar.services.IGiamGiaService;

public class GiamGiaServiceImpl implements IGiamGiaService {
	
	IGiamGiaDao giamGiaDao = new GiamGiaDaoImpl();
	@Override
	public void insert(GiamGiaModel giamGia) {
		giamGiaDao.insert(giamGia);
		
	}

	@Override
	public void update(GiamGiaModel giamGia) {
		giamGiaDao.update(giamGia);
	}

	@Override
	public void delete(int idGiamGia) {
		giamGiaDao.delete(idGiamGia);
	}

	@Override
	public List<GiamGiaModel> findByIdSheller(int idSheller) {
		return giamGiaDao.findByIdSheller(idSheller);
	}

	@Override
	public GiamGiaModel findById(int idGiamGia) {
		return giamGiaDao.findById(idGiamGia);
	}

	@Override
	public void insertMaGiamGiaCuaKhach(int idGiamGia, int idKhach) {
		giamGiaDao.insertMaGiamGiaCuaKhach(idGiamGia, idKhach);
	}

	@Override
	public void updateSoLanDaSuDung(int soLanDaSuDung, int idGiamGia) {
		giamGiaDao.updateSoLanDaSuDung(soLanDaSuDung, idGiamGia);
	}

	@Override
	public boolean checkExistIdUser(int idUser, int idGiamGia) {
		return giamGiaDao.checkExistIdUser(idUser, idGiamGia);
	}

}
