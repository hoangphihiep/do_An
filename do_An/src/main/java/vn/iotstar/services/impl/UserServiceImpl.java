package vn.iotstar.services.impl;

import java.sql.Date;
import java.util.List;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserServices;
import vn.iotstar.utils.AESUtil;

public class UserServiceImpl implements IUserServices {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		String encryptedPassword = user.getPassword();
		String decryptedPassword = null;
		try {
			decryptedPassword = AESUtil.decrypt(encryptedPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null && password.equals(decryptedPassword)) {
			return user;
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}
	
	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
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
		String phone, String password, String diaChi, int RoleId, boolean active) {
		userDao.insert(new UserModel(username, fullname, createDate, gender, email, phone, password, diaChi, RoleId, active));
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

	@Override
	public List<UserModel> findAll() {
		return userDao.findAll();
	}
}
