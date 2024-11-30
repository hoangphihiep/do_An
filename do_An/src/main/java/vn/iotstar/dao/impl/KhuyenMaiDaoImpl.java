package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IKhuyenMaiDao;
import vn.iotstar.models.KhuyenMaiModel;

public class KhuyenMaiDaoImpl extends DBConnectionSQL implements IKhuyenMaiDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public void insert(KhuyenMaiModel khuyenMai) {
		String sql = "INSERT INTO KhuyenMai(name, moTa, giaTriGiam, thoiGianBatDau, thoiGianKetThuc, idPhong, idKhachSan, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khuyenMai.getTen());
			ps.setString(2, khuyenMai.getMoTa());
			ps.setInt(3, khuyenMai.getGiaTriGiam());
			ps.setDate(4, khuyenMai.getThoiGianBatDau());
			ps.setDate(5, khuyenMai.getThoiGianKetThuc());
			if (khuyenMai.getIdPhong() == null) {
		        ps.setNull(6, java.sql.Types.INTEGER); // Gán null cho cột idPhong
		    } else {
		        ps.setInt(6, khuyenMai.getIdPhong()); // Gán giá trị nếu không null
		    }
			ps.setInt(7, khuyenMai.getIdKS());
			ps.setInt(8, khuyenMai.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(KhuyenMaiModel khuyenMai) {
		String sql = "UPDATE KhuyenMai SET  name = ?, moTa = ?, giaTriGiam = ?, thoiGianBatDau = ?, thoiGianKetThuc = ?, idPhong = ?, idKhachSan = ?, status = ? WHERE id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khuyenMai.getTen());
			ps.setString(2, khuyenMai.getMoTa());
			ps.setInt(3, khuyenMai.getGiaTriGiam());
			ps.setDate(4, khuyenMai.getThoiGianBatDau());
			ps.setDate(5, khuyenMai.getThoiGianKetThuc());
			if (khuyenMai.getIdPhong() == null) {
		        ps.setNull(6, java.sql.Types.INTEGER); // Gán null cho cột idPhong
		    } else {
		        ps.setInt(6, khuyenMai.getIdPhong()); // Gán giá trị nếu không null
		    }
			ps.setInt(7, khuyenMai.getIdKS());
			ps.setInt(8, khuyenMai.getStatus());
			ps.setInt(9, khuyenMai.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idKhuyenMai) {
		String sql = "DELETE KhuyenMai WHERE id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhuyenMai);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<KhuyenMaiModel> findByIdSheller(int idSheller) {
		String sql = "SELECT KhuyenMai.id as id, KhuyenMai.name as ten, "
				+ "KhuyenMai.moTa as moTa, KhuyenMai.giaTriGiam as giaTriGiam,"
				+ "KhuyenMai.thoiGianBatDau as thoiGianBatDau, KhuyenMai.thoiGianKetThuc as thoiGianKetThuc, "
				+ "KhuyenMai.idPhong as idPhong, KhuyenMai.idKhachSan as idKS,"
				+ "KhuyenMai.status as status " +
	             "FROM KhuyenMai, KhachSan " +
	             "WHERE KhachSan.IdUser = ? AND KhachSan.Id = KhuyenMai.idKhachSan";
		List<KhuyenMaiModel> list = new ArrayList<KhuyenMaiModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idSheller);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhuyenMaiModel(
						rs.getInt("id"),
						rs.getString("ten"),
						rs.getString("moTa"),
						rs.getInt("giaTriGiam"),
						rs.getDate("thoiGianBatDau"),
						rs.getDate("thoiGianKetThuc"),
						rs.getInt("idPhong"),
						rs.getInt("idKS"),
						rs.getInt("status")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert2(KhuyenMaiModel khuyenMai) {
		String sql = "INSERT INTO KhuyenMai(name, moTa, giaTriGiam, thoiGianBatDau, thoiGianKetThuc, idKhachSan, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khuyenMai.getTen());
			ps.setString(2, khuyenMai.getMoTa());
			ps.setInt(3, khuyenMai.getGiaTriGiam());
			ps.setDate(4, khuyenMai.getThoiGianBatDau());
			ps.setDate(5, khuyenMai.getThoiGianKetThuc());
			ps.setInt(6, khuyenMai.getIdKS());
			ps.setInt(7, khuyenMai.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public KhuyenMaiModel findById(int idKhuyenMai) {
		String sql = "Select * from KhuyenMai where id =  ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhuyenMai);
			rs = ps.executeQuery();
			while (rs.next())
			{
				KhuyenMaiModel khuyenMai = new KhuyenMaiModel();
				khuyenMai.setId(rs.getInt("id"));
				khuyenMai.setTen(rs.getString("name"));
				khuyenMai.setMoTa(rs.getString("moTa"));
				khuyenMai.setGiaTriGiam(rs.getInt("giaTriGiam"));
				khuyenMai.setThoiGianBatDau(rs.getDate("thoiGianBatDau"));
				khuyenMai.setThoiGianKetThuc(rs.getDate("thoiGianKetThuc"));
				khuyenMai.setIdPhong(rs.getInt("idPhong"));
				khuyenMai.setIdKS(rs.getInt("idKhachSan"));
				khuyenMai.setStatus(rs.getInt("status"));
				return khuyenMai;
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
	public void update2(KhuyenMaiModel khuyenMai) {
		String sql = "UPDATE KhuyenMai SET  name = ?, moTa = ?, giaTriGiam = ?, thoiGianBatDau = ?, thoiGianKetThuc = ?, idPhong = ?, idKhachSan = ?, status = ? WHERE id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khuyenMai.getTen());
			ps.setString(2, khuyenMai.getMoTa());
			ps.setInt(3, khuyenMai.getGiaTriGiam());
			ps.setDate(4, khuyenMai.getThoiGianBatDau());
			ps.setDate(5, khuyenMai.getThoiGianKetThuc());
			ps.setInt(6, khuyenMai.getIdPhong());
			ps.setInt(7, khuyenMai.getIdKS());
			ps.setInt(8, khuyenMai.getStatus());
			ps.setInt(9, khuyenMai.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<KhuyenMaiModel> findAll() {
		String sql = "SELECT * FROM KhuyenMai";
		List<KhuyenMaiModel> list = new ArrayList<KhuyenMaiModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhuyenMaiModel(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("moTa"),
						rs.getInt("giaTriGiam"),
						rs.getDate("thoiGianBatDau"),
						rs.getDate("thoiGianKetThuc"),
						rs.getInt("idPhong"),
						rs.getInt("idKhachSan"),
						rs.getInt("status")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<KhuyenMaiModel> findByIdKhachSan(int idKhachSan) {
		String sql = "SELECT * "
				+ "FROM KhuyenMai WHERE KhuyenMai.IdKhachSan = ?";
		List<KhuyenMaiModel> list = new ArrayList<KhuyenMaiModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhuyenMaiModel(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("moTa"),
						rs.getInt("giaTriGiam"),
						rs.getDate("thoiGianBatDau"),
						rs.getDate("thoiGianKetThuc"),
						rs.getInt("idPhong"),
						rs.getInt("idKhachSan"),
						rs.getInt("status")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
