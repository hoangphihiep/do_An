package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.TienIchModel;

public interface ITienIchDao {
	List<TienIchModel> findAll();

	void insert(TienIchModel anhKhachSan);

	void update(TienIchModel anhKhachSan);

	void delete(int idTienIch);
	
	List<TienIchModel> findByIdKhachSan(int idKhachSan);
}
