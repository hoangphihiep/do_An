package vn.iotstar.services.impl;

import java.sql.Date;

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
}
