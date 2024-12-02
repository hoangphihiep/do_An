package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IChiecKhauDao;
import vn.iotstar.models.ChiecKhauModel;

public class ChiecKhauDaoImpl extends DBConnectionSQL implements IChiecKhauDao{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<ChiecKhauModel> findAll() {
		String sql = "SELECT * FROM ChiecKhau ";
		List<ChiecKhauModel> list = new ArrayList<ChiecKhauModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ChiecKhauModel(
						rs.getInt("Id"),
						rs.getInt("IdKS"),
						rs.getInt("TiLeChiecKhau")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(ChiecKhauModel chiecKhau) {
		String sql = "INSERT INTO ChiecKhau(IdKS, TiLeChiecKhau) VALUES (?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, chiecKhau.getIdKS());
			ps.setInt(2, chiecKhau.getTiLeChiecKhau());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(ChiecKhauModel chiecKhau) {
		String sql = "UPDATE ChiecKhau SET  IdKS = ?, TiLeChiecKhau = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, chiecKhau.getIdKS());
			ps.setInt(2, chiecKhau.getTiLeChiecKhau());
			ps.setInt(3, chiecKhau.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idChiecKhau) {
		String sql = "DELETE ChiecKhau WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idChiecKhau);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ChiecKhauModel findById(int idChiecKhau) {
		String sql = "SELECT * " +
	             "FROM ChiecKhau " +
	             "WHERE ChiecKhau.Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idChiecKhau);
			rs = ps.executeQuery();
			while (rs.next())
			{
				ChiecKhauModel chiecKhau = new ChiecKhauModel();
				chiecKhau.setId(rs.getInt("Id"));
				chiecKhau.setIdKS(rs.getInt("IdKS"));
				chiecKhau.setTiLeChiecKhau(rs.getInt("TiLeChiecKhau"));
				return chiecKhau;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ChiecKhauModel> findByIdSheller(int idSheller) {
		String sql = "SELECT ChiecKhau.Id, ChiecKhau.IdKS, ChiecKhau.TiLeChiecKhau " +
	             "FROM ChiecKhau, KhachSan " +
	             "WHERE KhachSan.IdUser = ? AND KhachSan.Id = ChiecKhau.IdKS";
		List<ChiecKhauModel> list = new ArrayList<ChiecKhauModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idSheller);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ChiecKhauModel(
						rs.getInt("Id"),
						rs.getInt("IdKS"),
						rs.getInt("TiLeChiecKhau")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ChiecKhauModel findByIdKS(int idKS) {
		String sql = "SELECT * " +
	             "FROM ChiecKhau " +
	             "WHERE ChiecKhau.IdKS = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKS);
			rs = ps.executeQuery();
			while (rs.next())
			{
				ChiecKhauModel chiecKhau = new ChiecKhauModel();
				chiecKhau.setId(rs.getInt("Id"));
				chiecKhau.setIdKS(rs.getInt("IdKS"));
				chiecKhau.setTiLeChiecKhau(rs.getInt("TiLeChiecKhau"));
				return chiecKhau;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
