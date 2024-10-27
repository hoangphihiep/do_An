package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ILichSuDatPhong;
import vn.iotstar.dao.impl.LichSuDatPhongDaoImpl;
import vn.iotstar.models.LichSuModel;
import vn.iotstar.services.ILichSuDatPhongService;

public class LichSuDatPhongServiceImpl implements ILichSuDatPhongService {
	
	ILichSuDatPhong lichSuDatPhongDao = new LichSuDatPhongDaoImpl();
	@Override
	public List<LichSuModel> findByIdUser(int idUser) {
		return lichSuDatPhongDao.findByIdUser(idUser);
	}

}
