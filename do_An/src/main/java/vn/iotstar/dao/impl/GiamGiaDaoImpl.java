package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IGiamGiaDao;
import vn.iotstar.models.GiamGiaModel;

public class GiamGiaDaoImpl extends DBConnectionSQL implements IGiamGiaDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public void insert(GiamGiaModel giamGia) {
		String sql = "INSERT INTO MaGiamGia(code, giaTriGiam, ngayBatDau, ngayKetThuc, soLanSuDung, soLanDaSuDung, idUser, apDung) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, giamGia.getMaGiamGia());
			ps.setInt(2, giamGia.getPhanTramGiamGia());
			ps.setDate(3, giamGia.getNgayBatDau());
			ps.setDate(4, giamGia.getNgayKetThuc());
			ps.setInt(5, giamGia.getSoLuongMa());
			ps.setInt(6, giamGia.getSoLanDaSuDung());
			ps.setInt(7, giamGia.getIdUser());
			ps.setString(8, giamGia.getApDung());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(GiamGiaModel giamGia) {
		String sql = "UPDATE MaGiamGia SET  code = ?, giaTriGiam = ?, ngayBatDau = ?, ngayKetThuc = ?, soLanSuDung = ?, soLanDaSuDung = ?, apDung = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, giamGia.getMaGiamGia());
			ps.setInt(2, giamGia.getPhanTramGiamGia());
			ps.setDate(3, giamGia.getNgayBatDau());
			ps.setDate(4, giamGia.getNgayKetThuc());
			ps.setInt(5, giamGia.getSoLuongMa());
			ps.setInt(6, giamGia.getSoLanDaSuDung());
			ps.setString(7, giamGia.getApDung());
			ps.setInt(8, giamGia.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idGiamGia) {
		String sql = "DELETE MaGiamGia WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idGiamGia);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		  
		  IGiamGiaDao giamGia = new GiamGiaDaoImpl();
		  GiamGiaModel giam = giamGia.findById(1);
		  System.out.println (giam.getMaGiamGia());
		  
		 }

	@Override
	public List<GiamGiaModel> findByIdSheller(int idSheller) {
		String sql = "SELECT * " +
	             "FROM MaGiamGia " +
	             "WHERE MaGiamGia.idUser = ?";
		List<GiamGiaModel> list = new ArrayList<GiamGiaModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idSheller);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new GiamGiaModel(
						rs.getInt("id"),
						rs.getString("code"),
						rs.getInt("giaTriGiam"),
						rs.getDate("ngayBatDau"),
						rs.getDate("ngayKetThuc"),
						rs.getInt("SoLanSuDung"),
						rs.getString("apDung"),
						rs.getInt("soLanDaSuDung"),
						rs.getInt("idUser")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GiamGiaModel findById(int idGiamGia) {
		String sql = "Select * from MaGiamGia where id =  ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idGiamGia);
			rs = ps.executeQuery();
			while (rs.next())
			{
				GiamGiaModel giamGia = new GiamGiaModel();
				giamGia.setId(rs.getInt("id"));
				giamGia.setMaGiamGia(rs.getString("code"));
				giamGia.setPhanTramGiamGia(rs.getInt("giaTriGiam"));
				giamGia.setNgayBatDau(rs.getDate("ngayBatDau"));
				giamGia.setNgayKetThuc(rs.getDate("ngayKetThuc"));
				giamGia.setSoLuongMa(rs.getInt("soLanSuDung"));
				giamGia.setSoLanDaSuDung(rs.getInt("soLanDaSuDung"));
				giamGia.setIdUser(rs.getInt("idUser"));
				giamGia.setApDung(rs.getString("apDung"));
				return giamGia;
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
	public void insertMaGiamGiaCuaKhach(int idGiamGia, int idKhach) {
		String sql = "INSERT INTO User_MaGiamGia(IdUser, IdCode) VALUES (?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, idKhach);
			ps.setInt(2, idGiamGia);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateSoLanDaSuDung(int soLanDaSuDung, int idGiamGia) {
		String sql = "UPDATE MaGiamGia SET  soLanDaSuDung = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, soLanDaSuDung);
			ps.setInt(2, idGiamGia);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistIdUser(int idUser, int idGiamGia) {
		boolean duplicate = false;
		String query = "select * from User_MaGiamGia where IdUser = ? AND IdCode = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idUser);
			ps.setInt(2, idGiamGia);
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
}
