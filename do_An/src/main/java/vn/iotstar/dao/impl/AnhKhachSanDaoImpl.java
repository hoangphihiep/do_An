package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IAnhKhachSanDao;
import vn.iotstar.models.AnhKhachSanModel;

public class AnhKhachSanDaoImpl extends DBConnectionSQL implements IAnhKhachSanDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<AnhKhachSanModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AnhKhachSanModel anhKhachSan) {
		String sql = "INSERT INTO AnhKhachSan(TenAnh, AnhKhachSan, IdKhachSan) VALUES (?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, anhKhachSan.getVaiTroCuaAnh());
			ps.setString(2, anhKhachSan.getUrlAnhKhachSan());
			ps.setInt(3, anhKhachSan.getIdKhachSan());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(AnhKhachSanModel anhKhachSan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idAnhKhachSan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AnhKhachSanModel> findByIdKhachSan(int idKhachSan) {
		String sql = "select * from AnhKhachSan where IdKhachSan = ?";
		List<AnhKhachSanModel> list = new ArrayList<AnhKhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new AnhKhachSanModel(
						rs.getInt("Id"),
						rs.getString("TenAnh"),
						rs.getString("AnhKhachSan"),
						rs.getInt("IdKhachSan")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {

		try {
			IAnhKhachSanDao anhkhachsanDao = new AnhKhachSanDaoImpl();
			//thanhphoDao.insert(new ThanhPhoModel("Đồng Nai", "Thanh phố Biên Hòa", "imgae"));
			anhkhachsanDao.insert(new AnhKhachSanModel("anhChinh", "123", 2));
			List<AnhKhachSanModel> list = anhkhachsanDao.findByIdKhachSan(2);
			for (AnhKhachSanModel khachsan : list) {
				System.out.println(khachsan);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteByIdKhachSan(int idKS) {
		String sql = "DELETE AnhKhachSan WHERE IdKhachSan = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKS);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
