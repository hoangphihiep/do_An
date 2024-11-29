package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IThongBaoDao;
import vn.iotstar.dao.impl.ThongBaoDaoImpl;
import vn.iotstar.models.ThongBaoModel;
import vn.iotstar.services.IThongBaoService;

public class ThongBaoServiceImpl implements IThongBaoService {

	IThongBaoDao thongBaoDao = new ThongBaoDaoImpl();
	@Override
	public List<ThongBaoModel> listFindByIdUser(int idUser) {
		return thongBaoDao.listFindByIdUser(idUser);
	}

	@Override
	public void insert(ThongBaoModel thongBao) {
		thongBaoDao.insert(thongBao);
	}

	@Override
	public void update(ThongBaoModel thongBao) {
		thongBaoDao.update(thongBao);
	}

	@Override
	public void delete(int idThongBao) {
		thongBaoDao.delete(idThongBao);
	}

}
