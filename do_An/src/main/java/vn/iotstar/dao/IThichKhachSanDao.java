package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.ThichKhachSanModel;

public interface IThichKhachSanDao {
	
	boolean isHotelLikedByUser(int idUser, int idKS);
	
	void likeHotel(int idUser, int idKS);
	
	void unlikeHotel(int idUser, int idKS);
	
	List<ThichKhachSanModel> listLikeHotel (int idUser); 
	
	List<ThichKhachSanModel> findAll(int currentPage, int idUser);
	
	int countAll();
}
