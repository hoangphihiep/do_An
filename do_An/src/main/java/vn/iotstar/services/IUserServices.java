package vn.iotstar.services;

import java.sql.Date;

import vn.iotstar.models.UserModel;

public interface IUserServices {
	
	UserModel findByUserName(String username);
	
	UserModel login(String username, String password);
	
	UserModel findById (int id);
	
	void insert(UserModel user);
	
	void update(UserModel user);
	
	boolean register(String username, String fullname, Date createDate, String gender,  String email, String phone, String password, String diaChi, int RoleId);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	boolean updatePassword(String usernameOrEmail, String newPassword);
}
