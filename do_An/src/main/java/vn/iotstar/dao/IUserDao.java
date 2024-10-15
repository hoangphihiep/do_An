package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	UserModel findByUserName (String username);
	
	UserModel findByUsernameOrEmail(String usernameOrEmail);
	
	List<UserModel> findAll();
	
	UserModel findById (int id);
	
	void insert(UserModel user);
	
	void update(UserModel user);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
}
