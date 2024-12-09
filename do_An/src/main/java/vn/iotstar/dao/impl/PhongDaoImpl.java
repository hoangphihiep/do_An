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
		String sql = "select P.Id, P.Ten, P.DienTich, P.GiaThue, P.TienNghi, "
				+ "P.MoTa, P.SoPhongTrong, P.SoPhongDaDat, P.SucChuaToiDa, "
				+ "P.AnhPhong, P.IdKhachSan, K.Ten as TenKhachSan "
				+ "from Phong P, KhachSan K "
				+ "where P.IdKhachSan=K.Id";
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
						rs.getInt("IdKhachSan"),
						rs.getString("TenKhachSan"),
						rs.getInt("SoPhongTrong"),
						rs.getInt("SoPhongDaDat"),
						rs.getInt("SucChuaToiDa"),
						rs.getString("AnhPhong"),
						rs.getInt("TienThueSauKhiGiam")
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
		String sql = "INSERT INTO Phong(Ten, DienTich, GiaThue, TienNghi, MoTa, IdKhachSan, SoPhongTrong, SoPhongDaDat, SucChuaToiDa, AnhPhong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, phong.getTen());
			ps.setInt(2, phong.getDienTich());
			ps.setInt(3, phong.getGiaThue());
			ps.setString(4, phong.getTienNghi());
			ps.setString(5, phong.getMoTa());
			ps.setInt(6, phong.getIdKhachSan());
			ps.setInt(7, phong.getSoPhongTrong());
			ps.setInt(8, phong.getSoPhongDaDat());
			ps.setInt(9, phong.getSucChuaToiDa());
			ps.setString(10, phong.getAnhPhong());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void update(PhongModel phong) {
		String sql = "UPDATE Phong SET Ten=?, DienTich=?, GiaThue=?, TienNghi=?, MoTa=?, IdKhachSan=?, SoPhongTrong=?, SoPhongDaDat=?, SucChuaToiDa=?, AnhPhong=? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, phong.getTen());
			ps.setInt(2, phong.getDienTich());
			ps.setInt(3, phong.getGiaThue());
			ps.setString(4, phong.getTienNghi());
			ps.setString(5, phong.getMoTa());
			ps.setInt(6, phong.getIdKhachSan());
			ps.setInt(7, phong.getSoPhongTrong());
			ps.setInt(8, phong.getSoPhongDaDat());
			ps.setInt(9, phong.getSucChuaToiDa());
			ps.setString(10, phong.getAnhPhong());
			ps.setInt(11, phong.getId());
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
		String sql = "select P.Id, P.Ten, P.DienTich, P.GiaThue, P.TienNghi, "
				+ "P.MoTa, P.SoPhongTrong, P.SoPhongDaDat, "
				+ "P.SucChuaToiDa, P.AnhPhong, P.TienThueSauKhiGiam, P.IdKhachSan, K.Ten as TenKhachSan "
				+ "from Phong P, KhachSan K "
				+ "where K.Id = ? and P.IdKhachSan=K.Id";
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
						rs.getInt("IdKhachSan"),
						rs.getString("TenKhachSan"),
						rs.getInt("SoPhongTrong"),
						rs.getInt("SoPhongDaDat"),
						rs.getInt("SucChuaToiDa"),
						rs.getString("AnhPhong"),
						rs.getInt("TienThueSauKhiGiam")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PhongModel> phongMinByIdKhachSan(int idKhachSan) {
		String sql = "select P.IdKhachSan, MIN(P.TienThueSauKhiGiam) AS GiaThapNhat, MIN(P.GiaThue) AS GiaThue "
				+ "from Phong P, KhachSan K "
				+ "where K.Id = ? and P.IdKhachSan=K.Id GROUP BY P.IdKhachSan";
		List<PhongModel> list = new ArrayList<PhongModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new PhongModel(
						rs.getInt("IdKhachSan"),
						rs.getInt("GiaThapNhat"),
						rs.getInt("GiaThue")
						));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PhongModel findById(int id) {
		String sql = "select P.Id, P.Ten, P.DienTich, P.GiaThue, P.TienNghi, "
				+ "P.MoTa, P.SoPhongTrong, P.SoPhongDaDat, "
				+ "P.SucChuaToiDa, P.AnhPhong, P.TienThueSauKhiGiam, P.IdKhachSan, K.Ten as TenKhachSan "
				+ "from Phong P, KhachSan K "
				+ "where P.Id = ? and P.IdKhachSan=K.Id";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				PhongModel phong = new PhongModel();
				phong.setId(rs.getInt("Id"));
				phong.setIdKhachSan(rs.getInt("IdKhachSan"));
				phong.setTenKhachSan(rs.getString("TenKhachSan"));
				phong.setAnhPhong(rs.getString("AnhPhong"));
				phong.setGiaThue(rs.getInt("GiaThue"));
				phong.setSoPhongDaDat(rs.getInt("SoPhongDaDat"));
				phong.setSoPhongTrong(rs.getInt("SoPhongTrong"));
				phong.setSucChuaToiDa(rs.getInt("SucChuaToiDa"));
				phong.setTen(rs.getString("Ten"));
				phong.setTienNghi(rs.getString("TienNghi"));
				phong.setMoTa(rs.getString("MoTa"));
				phong.setDienTich(rs.getInt("DienTich"));
				phong.setTienThueSauKhiGiam(rs.getInt("TienThueSauKhiGiam"));
				return phong;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateSLPhong(int SLPhongDat, int soPhongTrong, int SLPhongD, int IdPhong) {
		
		soPhongTrong = (SLPhongD - SLPhongDat) + soPhongTrong;
		
		String sql = "UPDATE Phong SET SoPhongTrong = ?, SoPhongDaDat = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, soPhongTrong);
			ps.setInt(2, SLPhongDat);
			ps.setInt(3, IdPhong);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
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
	public void update2(PhongModel phong) {
		String sql = "UPDATE Phong SET Ten=?, DienTich=?, GiaThue=?, TienNghi=?, MoTa=?, IdKhachSan=?, SoPhongTrong=?, SoPhongDaDat=?, SucChuaToiDa=?, AnhPhong=?, TienThueSauKhiGiam=? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, phong.getTen());
			ps.setInt(2, phong.getDienTich());
			ps.setInt(3, phong.getGiaThue());
			ps.setString(4, phong.getTienNghi());
			ps.setString(5, phong.getMoTa());
			ps.setInt(6, phong.getIdKhachSan());
			ps.setInt(7, phong.getSoPhongTrong());
			ps.setInt(8, phong.getSoPhongDaDat());
			ps.setInt(9, phong.getSucChuaToiDa());
			ps.setString(10, phong.getAnhPhong());
			ps.setInt(11, phong.getTienThueSauKhiGiam());
			ps.setInt(12, phong.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
