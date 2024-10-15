package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IAnhKhachSanDao;
import vn.iotstar.dao.IKhachSanDao;
import vn.iotstar.models.AnhKhachSanModel;
import vn.iotstar.models.KhachSanModel;

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
		// TODO Auto-generated method stub
		
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
			List<AnhKhachSanModel> list = anhkhachsanDao.findByIdKhachSan(1);
			for (AnhKhachSanModel khachsan : list) {
				System.out.println(khachsan);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
