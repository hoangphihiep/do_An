package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.TienIchModel;

public interface ITienIchService {
	
	List<TienIchModel> findAll();

	void insert(TienIchModel anhKhachSan);

	void update(TienIchModel anhKhachSan);

	void delete(int idTienIch);

	List<TienIchModel> findByIdKhachSan(int idKhachSan);
}
