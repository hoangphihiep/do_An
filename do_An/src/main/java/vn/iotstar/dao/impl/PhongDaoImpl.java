package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IPhongDao;
import vn.iotstar.models.PhongModel;

public class PhongDaoImpl extends DBConnectionSQL implements IPhongDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<PhongModel> findAll() {
		String sql = "select P.Id, P.Ten, P.DienTich, P.GiaThue, P.TienNghi, P.MoTa, P.LoaiGiuong, P.SoPhongTrong, P.SoPhongDaDat, P.SucChuaToiDa, P.AnhPhong, P.IdKhachSan, K.Ten as TenKhachSan from Phong P, KhachSan K where P.IdKhachSan=K.Id";
		List<PhongModel> list = new ArrayList<PhongModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PhongModel(
						rs.getInt("Id"),
						rs.getString("Ten"),
						rs.getInt("DienTich"),
						rs.getInt("GiaThue"),
						rs.getString("TienNghi"),
						rs.getString("MoTa"),
						rs.getInt("LoaiGiuong"),
						rs.getInt("IdKhachSan"),
						rs.getString("TenKhachSan"),
						rs.getInt("SoPhongTrong"),
						rs.getInt("SoPhongDaDat"),
						rs.getInt("SucChuaToiDa"),
						rs.getString("AnhPhong")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(PhongModel phong) {
		String sql = "INSERT INTO Phong(Ten, DienTich, GiaThue, TienNghi, MoTa, LoaiGiuong, IdKhachSan) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, phong.getTen());
			ps.setInt(2, phong.getDienTich());
			ps.setInt(3, phong.getGiaThue());
			ps.setString(4, phong.getTienNghi());
			ps.setString(5, phong.getMoTa());
			ps.setInt(6, phong.getLoaiGiuong());
			ps.setInt(7, phong.getIdKhachSan());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(PhongModel phong) {
		String sql = "UPDATE Phong SET Ten=?, DienTich=?, GiaThue=?, TienNghi=?, MoTa=?, LoaiGiuong=?, IdKhachSan=? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, phong.getTen());
			ps.setInt(2, phong.getDienTich());
			ps.setInt(3, phong.getGiaThue());
			ps.setString(4, phong.getTienNghi());
			ps.setString(5, phong.getMoTa());
			ps.setInt(6, phong.getLoaiGiuong());
			ps.setInt(7, phong.getIdKhachSan());
			ps.setInt(8, phong.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idPhong) {
		String sql = "DELETE Phong WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPhong);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PhongModel> findByIdKhachSan(int idKhachSan) {
		String sql = "select P.Id, P.Ten, P.DienTich, P.GiaThue, P.TienNghi, P.MoTa, P.LoaiGiuong, P.SoPhongTrong, P.SoPhongDaDat, P.SucChuaToiDa, P.AnhPhong, P.IdKhachSan, K.Ten as TenKhachSan from Phong P, KhachSan K where K.Id = ? and P.IdKhachSan=K.Id";
		List<PhongModel> list = new ArrayList<PhongModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PhongModel(
						rs.getInt("Id"),
						rs.getString("Ten"),
						rs.getInt("DienTich"),
						rs.getInt("GiaThue"),
						rs.getString("TienNghi"),
						rs.getString("MoTa"),
						rs.getInt("LoaiGiuong"),
						rs.getInt("IdKhachSan"),
						rs.getString("TenKhachSan"),
						rs.getInt("SoPhongTrong"),
						rs.getInt("SoPhongDaDat"),
						rs.getInt("SucChuaToiDa"),
						rs.getString("AnhPhong")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {

		try {
			IPhongDao phongDao = new PhongDaoImpl();
			List<PhongModel> list = phongDao.phongMinByIdKhachSan(1);
			for (PhongModel user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<PhongModel> phongMinByIdKhachSan(int idKhachSan) {
		String sql = "select P.IdKhachSan, MIN(P.GiaThue) AS GiaThapNhat from Phong P, KhachSan K where K.Id = ? and P.IdKhachSan=K.Id GROUP BY P.IdKhachSan";
		List<PhongModel> list = new ArrayList<PhongModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PhongModel(
						rs.getInt("IdKhachSan"),
						rs.getInt("GiaThapNhat")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
