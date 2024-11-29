package vn.iotstar.services;

import java.sql.Date;
import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserServices {
	
	List<UserModel> findAll();
	
	UserModel findByUserName(String username);
	
	UserModel login(String username, String password);
	
	UserModel findById (int id);
	
	UserModel findByUsernameOrEmail(String usernameOrEmail);
	
	void insert(UserModel user);
	
	void update(UserModel user);
	
	boolean register(String username, String fullname, Date createDate, String gender,  String email, String phone, String password, String diaChi, int RoleId, boolean active);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	boolean updatePassword(String usernameOrEmail, String newPassword);
}
