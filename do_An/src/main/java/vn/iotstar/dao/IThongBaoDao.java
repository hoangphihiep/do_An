package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.ThongBaoModel;

public interface IThongBaoDao {
	
	List<ThongBaoModel> listFindByIdUser (int idUser);
	
	void insert (ThongBaoModel thongBao);
	
	void update (ThongBaoModel thongBao);
	
	void delete (int idThongBao);
}
