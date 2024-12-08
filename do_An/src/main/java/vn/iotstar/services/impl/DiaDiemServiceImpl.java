package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.IDiaDiemDao;
import vn.iotstar.dao.impl.DiaDiemDaoImpl;
import vn.iotstar.models.DiaDiemModel;
import vn.iotstar.services.IDiaDiemService;

public class DiaDiemServiceImpl implements IDiaDiemService {

	IDiaDiemDao diaDiemDao = new DiaDiemDaoImpl();
	@Override
	public List<DiaDiemModel> findAll() {
		return diaDiemDao.findAll();
	}

	@Override
	public void insert(DiaDiemModel diaDiem) {
		diaDiemDao.insert(diaDiem);
	}

	@Override
	public void update(DiaDiemModel diaDiem) {
		diaDiemDao.update(diaDiem);
	}

	@Override
	public void delete(int idDiaDiem) {
		diaDiemDao.delete(idDiaDiem);
	}

	@Override
	public DiaDiemModel findByName(String tenDiaDiem) {
		return diaDiemDao.findByName(tenDiaDiem);
	}

	@Override
	public DiaDiemModel findById(int id) {
		return diaDiemDao.findById(id);
	}

}
