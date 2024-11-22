package vn.iotstar.services.impl;

import java.sql.Date;
import java.util.List;

import vn.iotstar.dao.IDatPhongDao;
import vn.iotstar.dao.impl.DatPhongDaoImpl;
import vn.iotstar.models.DatPhongModel;
import vn.iotstar.services.IDatPhongService;

public class DatPhongServiceImpl implements IDatPhongService {

	IDatPhongDao datPhongDao = new DatPhongDaoImpl();
	@Override
	public int countPhongDaDat(Date ngayDen, Date ngayDi, int IdPhong) {
		return datPhongDao.countPhongDaDat(ngayDen, ngayDi, IdPhong);
	}
	@Override
	public void insert(DatPhongModel datPhong) {
		datPhongDao.insert(datPhong);
	}
	@Override
	public List<DatPhongModel> listPhongDaDatByIdSheller(int idSheller) {
		return datPhongDao.listPhongDaDatByIdSheller(idSheller);
	}
	@Override
	public void updateTrangThaiTT(int idDatPhong) {
		datPhongDao.updateTrangThaiTT(idDatPhong);	
	}
	@Override
	public void delete(int idDatPhong) {
		datPhongDao.delete(idDatPhong);
	}
	@Override
	public List<DatPhongModel> listKhachDatPhong(int idSheller) {
		return datPhongDao.listKhachDatPhong(idSheller);
	}
	@Override
	public int countDatPhongByIdUser(int idUser) {
		return datPhongDao.countDatPhongByIdUser(idUser);
	}
	@Override
	public int sumTienDatPhongByIdUser(int idUser, int idKS) {
		return datPhongDao.sumTienDatPhongByIdUser(idUser, idKS);
	}
}
