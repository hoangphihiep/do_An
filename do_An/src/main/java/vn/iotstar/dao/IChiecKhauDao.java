package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.ChiecKhauModel;

public interface IChiecKhauDao {
	
	List<ChiecKhauModel> findAll();
	
	void insert (ChiecKhauModel chiecKhau);
	
	void update (ChiecKhauModel chiecKhau);
	
	void delete (int idChiecKhau);
	
	ChiecKhauModel findById (int idChiecKhau);
	
	List<ChiecKhauModel> findByIdSheller (int idSheller);
	
	ChiecKhauModel findByIdKS (int idKS);
}
