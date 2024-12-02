package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.ITienIchDao;
import vn.iotstar.models.TienIchModel;

public class TienIchDaoImpl extends DBConnectionSQL implements ITienIchDao{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<TienIchModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TienIchModel tienIch) {
		String sql = "INSERT INTO TienIchKhachSan(Ten, IdKhachSan, IdLoaiTienIch) VALUES (?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, tienIch.getTenTienNghi());
			ps.setInt(2, tienIch.getIdKhachSan());
			ps.setInt(3, tienIch.getIdLoaiTienNghi());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		  
		ITienIchDao userDao = new TienIchDaoImpl();
		  
		  userDao.insert(new TienIchModel("máy giặc 1", 1, 3));
	}
	@Override
	public void update(TienIchModel tienIch) {
		String sql = "UPDATE KhachSan SET  Ten = ?, IdKhachSan = ?, IdLoaiTienIch = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, tienIch.getTenTienNghi());
			ps.setInt(2, tienIch.getIdKhachSan());
			ps.setInt(3, tienIch.getIdLoaiTienNghi());
			ps.setInt(4, tienIch.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int idTienIch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TienIchModel> findByIdKhachSan(int idKhachSan) {
		String sql = "select * from TienIchKhachSan where IdKhachSan = ?";
		List<TienIchModel> list = new ArrayList<TienIchModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TienIchModel(
						rs.getInt("Id"),
						rs.getString("Ten"),
						rs.getInt("IdKhachSan"),
						rs.getInt("IdLoaiTienIch")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByIdKhachSan(int idKhachSan) {
		String sql = "DELETE TienIchKhachSan WHERE IdKhachSan = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
