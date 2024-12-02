package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.ChiecKhauModel;

public interface IChiecKhauService {

	List<ChiecKhauModel> findAll();
	
	void insert (ChiecKhauModel chiecKhau);
	
	void update (ChiecKhauModel chiecKhau);
	
	void delete (int idChiecKhau);
	
	ChiecKhauModel findById (int idChiecKhau);
	
	List<ChiecKhauModel> findByIdSheller (int idSheller);
	
	ChiecKhauModel findByIdKS (int idKS);
}
