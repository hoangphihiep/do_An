package vn.iotstar.dao;

import java.sql.Date;
import java.util.List;

import vn.iotstar.models.DatPhongModel;

public interface IDatPhongDao {

	int countPhongDaDat (Date ngayDen, Date ngayDi, int IdPhong);
	
	List<DatPhongModel> findAll(Date ngayDen, Date ngayDi, int IdPhong);
	
	void insert (DatPhongModel datPhong);
	
	List<DatPhongModel> listPhongDaDatByIdSheller (int idSheller);
	
	void updateTrangThaiTT (int idDatPhong);
	
	void delete (int idDatPhong);
}
