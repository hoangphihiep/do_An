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
			AnhKhachSanModel anhks = anhkhachsanDao.anhChinhCuaKS(1);
			System.out.println (anhks.getIdAnhKhachSan() + " tên: " + anhks.getUrlAnhKhachSan());

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

	@Override
	public AnhKhachSanModel anhChinhCuaKS(int idKS) {
		String sql = "select * "
				+ "from AnhKhachSan "
				+ "where AnhKhachSan.TenAnh = ? and AnhKhachSan.IdKhachSan = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "AnhChinh");
			ps.setInt(2, idKS);
			rs = ps.executeQuery();
			while (rs.next())
			{
				AnhKhachSanModel anhKS = new AnhKhachSanModel();
				anhKS.setIdAnhKhachSan(rs.getInt("Id"));
				anhKS.setVaiTroCuaAnh(rs.getString("TenAnh"));
				anhKS.setUrlAnhKhachSan(rs.getString("AnhKhachSan"));
				anhKS.setIdKhachSan(rs.getInt("IdKhachSan"));
				return anhKS;
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
