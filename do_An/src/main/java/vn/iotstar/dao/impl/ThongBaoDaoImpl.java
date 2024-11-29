package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IThongBaoDao;
import vn.iotstar.models.ThongBaoModel;

public class ThongBaoDaoImpl extends DBConnectionSQL implements IThongBaoDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public void insert(ThongBaoModel thongBao) {
		String sql = "INSERT INTO ThongBao(IdUser, NgayGui, NoiDung) VALUES (?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, thongBao.getIdUser());
			ps.setTimestamp(2, thongBao.getNgayGui());
			ps.setString(3, thongBao.getNoiDung());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(ThongBaoModel thongBao) {
		String sql = "UPDATE ThongBao SET IdUser=?, NgayGui=?, NoiDung=? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, thongBao.getIdUser());
			ps.setTimestamp(2, thongBao.getNgayGui());
			ps.setString(3, thongBao.getNoiDung());
			ps.setInt(4, thongBao.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idThongBao) {
		String sql = "DELETE ThongBao WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idThongBao);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ThongBaoModel> listFindByIdUser(int idUser) {
		String sql = "select * "
				+ "from ThongBao "
				+ "where IdUser = ?";
		List<ThongBaoModel> list = new ArrayList<ThongBaoModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ThongBaoModel(
						rs.getInt("Id"),
						rs.getInt("IdUser"),
						rs.getTimestamp("NgayGui"),
						rs.getString("NoiDung")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
