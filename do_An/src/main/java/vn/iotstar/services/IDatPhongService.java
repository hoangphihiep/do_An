package vn.iotstar.services;

import java.sql.Date;

import vn.iotstar.models.DatPhongModel;

public interface IDatPhongService {
	int countPhongDaDat (Date ngayDen, Date ngayDi, int IdPhong);
	
	void insert (DatPhongModel datPhong);
}
