package vn.iotstar.services;

import java.sql.Date;
import java.util.List;

import vn.iotstar.models.DatPhongModel;

public interface IDatPhongService {
	
	int countPhongDaDat (Date ngayDen, Date ngayDi, int IdPhong);
	
	void insert (DatPhongModel datPhong);
	
	List<DatPhongModel> listPhongDaDatByIdSheller (int idSheller);
	
	void updateTrangThaiTT (int idDatPhong);
	
	void delete (int idDatPhong);
}
