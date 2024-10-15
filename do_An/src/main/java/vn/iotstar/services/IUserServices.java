package vn.iotstar.services;

import java.sql.Date;

import vn.iotstar.models.UserModel;

public interface IUserServices {
	
	UserModel findByUserName(String username);
	
	UserModel login(String username, String password);
	
	void insert(UserModel user);
	
	boolean register(String username, String fullname, Date createDate, String gender,  String email, String phone, String password);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	boolean updatePassword(String usernameOrEmail, String newPassword);
}
