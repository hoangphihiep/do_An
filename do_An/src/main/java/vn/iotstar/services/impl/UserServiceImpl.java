package vn.iotstar.services.impl;

import java.sql.Date;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserServices;

public class UserServiceImpl implements IUserServices {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}
	
	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean updatePassword(String usernameOrEmail, String newPassword) {
		UserModel user = userDao.findByUsernameOrEmail(usernameOrEmail);
		if (user != null) {
			user.setPassword(newPassword);
			userDao.update(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean register(String username, String fullname, Date createDate, String gender, String email,
			String phone, String password, String diaChi, int RoleId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if (userDao.checkExistUsername(username)) {
					return false;
				}
				userDao.insert(new UserModel(username, fullname, createDate, gender, email, phone, password, diaChi, RoleId));
				return true;
	}

	@Override
	public UserModel findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void update(UserModel user) {
		userDao.update(user);
	}

	@Override
	public UserModel findByUsernameOrEmail(String Email) {
		return userDao.findByUsernameOrEmail(Email);
	}
}
