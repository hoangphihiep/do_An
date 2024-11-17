package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.TienIchModel;

public interface ITienIchDao {
	List<TienIchModel> findAll();

	void insert(TienIchModel tienIch);

	void update(TienIchModel tienIch);

	void delete(int idTienIch);
	
	void deleteByIdKhachSan(int idKhachSan);
	
	List<TienIchModel> findByIdKhachSan(int idKhachSan);
}
