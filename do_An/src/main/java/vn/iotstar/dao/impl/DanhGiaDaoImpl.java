package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IDanhGiaDao;
import vn.iotstar.models.DanhGiaModel;

public class DanhGiaDaoImpl extends DBConnectionSQL implements IDanhGiaDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<DanhGiaModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(DanhGiaModel danhGia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DanhGiaModel danhGia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idDanhGia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DanhGiaModel> findByIdKhachSan(int idKhachSan) {
		String sql = "select * from DanhGia where IdKhachSan = ?";
		List<DanhGiaModel> list = new ArrayList<DanhGiaModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DanhGiaModel(
						rs.getInt("Id"),
						rs.getInt("Diem"),
						rs.getString("NoiDung"),
						rs.getInt("IdKhachHang"),
						rs.getInt("IdKhachSan")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DanhGiaModel> countUserByIdKhachSan(int idKhachSan) {
		// TODO Auto-generated method stub
		return null;
	}

}
