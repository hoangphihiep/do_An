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
	public void insert(TienIchModel anhKhachSan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TienIchModel anhKhachSan) {
		// TODO Auto-generated method stub
		
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

}
