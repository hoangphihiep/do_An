package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectionSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Users WHERE username = ? ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("Id"));
				user.setUsername(rs.getString("Username"));
				user.setFullname(rs.getString("Fullname"));
				user.setCreatedDate(rs.getDate("Dateofbirth"));
				user.setGender(rs.getString("Gender"));
				user.setEmail(rs.getString("Email"));
				user.setPhone(rs.getString("Phone"));
				user.setPassword(rs.getString("Password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Users";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				list.add(new UserModel(rs.getInt("Id"), rs.getString("Username"), rs.getString("Fullname"), rs.getDate("Dateofbirth"), rs.getString("Gender"), rs.getString("Email"),rs.getString("Phone"),
						rs.getString("Password")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Users WHERE id = ? ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("Id"));
				user.setUsername(rs.getString("Username"));
				user.setFullname(rs.getString("Fullname"));
				user.setCreatedDate(rs.getDate("Dateofbirth"));
				user.setGender(rs.getString("Gender"));
				user.setEmail(rs.getString("Email"));
				user.setPhone(rs.getString("Phone"));
				user.setPassword(rs.getString("Password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Users(Username, Fullname, Dateofbirth, Gender, Email, Phone, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFullname());
			ps.setDate(3, user.getCreatedDate());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDaoImpl();

			userDao.insert(
					new UserModel("khanh1", "Nguyen Van Khanh1", null , "Nam", "khanh1@gmail.com", "07242841241", "123"));

			List<UserModel> list = userDao.findAll();
			for (UserModel user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from Users where Email = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from Users where Username = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String query = "select * from Users where Phone = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public UserModel findByUsernameOrEmail(String usernameOrEmail) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Users WHERE Username = ? OR Email = ?"; // Giả sử bảng của bạn có tên là `users`

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, usernameOrEmail);
			ps.setString(2, usernameOrEmail);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					UserModel user = new UserModel();
					user.setId(rs.getInt("Id"));
					user.setUsername(rs.getString("Username"));
					user.setFullname(rs.getString("Fullname"));
					user.setCreatedDate(rs.getDate("Dateofbirth"));
					user.setGender(rs.getString("Gender"));
					user.setEmail(rs.getString("Email"));
					user.setPhone(rs.getString("Phone"));
					user.setPassword(rs.getString("Password"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Users SET  Password = ? WHERE Username = ? OR Email = ?";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
