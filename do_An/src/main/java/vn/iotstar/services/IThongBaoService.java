package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.ThongBaoModel;

public interface IThongBaoService {

	List<ThongBaoModel> listFindByIdUser (int idUser);
	
	void insert (ThongBaoModel thongBao);
	
	void update (ThongBaoModel thongBao);
	
	void delete (int idThongBao);
}
