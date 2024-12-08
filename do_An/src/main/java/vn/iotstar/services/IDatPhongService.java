package vn.iotstar.services;

import java.sql.Date;
import java.util.List;

import vn.iotstar.models.DatPhongModel;
import vn.iotstar.models.DoanhThuModel;

public interface IDatPhongService {
	
	int countPhongDaDat (Date ngayDen, Date ngayDi, int IdPhong);
	
	void insert (DatPhongModel datPhong);
	
	List<DatPhongModel> listPhongDaDatByIdSheller (int idSheller);
	
	void updateTrangThaiTT (int idDatPhong, int tienSauKhiChiecKhau, Date ngayThanhToan);
	
	void delete (int idDatPhong);
	
	List<DatPhongModel> listKhachDatPhong (int idSheller);
	
	int countDatPhongByIdUser (int idUser);
	
	int sumTienDatPhongByIdUser (int idUser, int idKS);
	
	List <DoanhThuModel> findAllDoanhThu (Date ngayBatDau, Date ngayKetThuc, int idKhachSan);
	
	DatPhongModel findById (int idDatPhong);
	
	List <DoanhThuModel> findAllDoanhThuChiecKhau (Date ngayBatDau, Date ngayKetThuc);
}
