package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IDatPhongDao;
import vn.iotstar.models.DatPhongModel;

public class DatPhongDaoImpl extends DBConnectionSQL implements IDatPhongDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public int countPhongDaDat(Date ngayDen, Date ngayDi, int IdPhong) {
		String sql = "SELECT SUM(SoPhongDaDat) " +
	             "FROM DatPhong " +
	             "WHERE IdPhong = ? AND ((NgayDen <= ?  AND NgayTra >= ?) OR(NgayDen >= ?  AND NgayDen <= ?) OR (NgayTra >= ?  AND NgayTra <= ?) OR (NgayTra >= ?  AND NgayTra >= ? AND (NgayDen <= ? OR (NgayDen >= ? AND NgayDen <= ?))))";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, IdPhong);
			ps.setDate(2, ngayDen);
			ps.setDate(3, ngayDi);
			ps.setDate(4, ngayDen);
			ps.setDate(5, ngayDi);
			ps.setDate(6, ngayDen);
			ps.setDate(7, ngayDi);
			ps.setDate(8, ngayDen);
			ps.setDate(9, ngayDi);
			ps.setDate(10, ngayDen);
			ps.setDate(11, ngayDen);
			ps.setDate(12, ngayDi);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return 0;
	}
	
	public List<DatPhongModel> findAll(Date ngayDen, Date ngayDi, int IdPhong) {
		String sql = "SELECT * " +
	             "FROM DatPhong " +
	             "WHERE IdPhong = ? AND ((NgayDen <= ?  AND NgayTra >= ?) OR(NgayDen >= ?  AND NgayDen <= ?) OR (NgayTra >= ?  AND NgayTra <= ?) OR (NgayTra >= ?  AND NgayTra >= ? AND (NgayDen <= ? OR (NgayDen >= ? AND NgayDen <= ?))))";
		List<DatPhongModel> list = new ArrayList<DatPhongModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, IdPhong);
			ps.setDate(2, ngayDen);
			ps.setDate(3, ngayDi);
			ps.setDate(4, ngayDen);
			ps.setDate(5, ngayDi);
			ps.setDate(6, ngayDen);
			ps.setDate(7, ngayDi);
			ps.setDate(8, ngayDen);
			ps.setDate(9, ngayDi);
			ps.setDate(10, ngayDen);
			ps.setDate(11, ngayDen);
			ps.setDate(12, ngayDi);
			rs = ps.executeQuery();
			while (rs.next()) {

				list.add(new DatPhongModel(
						rs.getInt("Id"),
						rs.getInt("IdUser"),
						rs.getInt("IdPhong"),
						rs.getDate("NgayDat"),
						rs.getDate("NgayDen"),
						rs.getDate("NgayTra"),
						rs.getString("GhiChu"),
						rs.getInt("ThanhTien"),
						rs.getInt("DaHuy"),
						rs.getInt("SoPhongDaDat"),
						rs.getBoolean("ThanhToan"),
						rs.getString("PhuongThucThanhToan")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) {
		  
		  try { 
			  IDatPhongDao datPhong = new DatPhongDaoImpl();
			  Date ngayDen = Date.valueOf("2024-11-03");
		      Date ngayDi = Date.valueOf("2024-11-07");
			    
		       List<DatPhongModel> dp = datPhong.findAll(ngayDen, ngayDi, 1);
		       for (DatPhongModel dat : dp) {
		    	   System.out.println ("Ten phong: " + dat.getIdPhong() + "ngayDen: " + dat.getNgayDen() + "So Phong Da Dat: " + dat.getSoPhongDaDat());
		       }
			    // Gọi phương thức với các tham số Date và int
			    int count = datPhong.countPhongDaDat(ngayDen, ngayDi, 1);
			    System.out.println("Số phòng đã đặt: " + count);
		  
		  } catch (Exception e) {
		  
		  e.printStackTrace(); }
		  
		 }
	@Override
	public void insert(DatPhongModel datPhong) {
		String sql = "INSERT INTO DatPhong(IdUser, IdPhong, NgayDat, NgayDen, NgayTra, GhiChu, ThanhTien, DaHuy, SoPhongDaDat, ThanhToan, PhuongThucThanhToan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, datPhong.getIdUser());
			ps.setInt(2, datPhong.getIdPhong());
			ps.setDate(3, datPhong.getNgayDat());
			ps.setDate(4, datPhong.getNgayDen());
			ps.setDate(5, datPhong.getNgayTra());
			ps.setString(6, datPhong.getGhiChu());
			ps.setInt(7, datPhong.getThanhTien());
			ps.setInt(8, datPhong.isDaHuy());
			ps.setInt(9, datPhong.getSoPhongDaDat());
			ps.setBoolean(10, datPhong.isThanhToan());
			ps.setString(11, datPhong.getPhuongThucTT());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<DatPhongModel> listPhongDaDatByIdSheller(int idSheller) {
		String sql = "SELECT dp.Id,dp.IdUser,dp.IdPhong,dp.NgayDat,dp.NgayDen,dp.NgayTra,dp.GhiChu,dp.ThanhTien,dp.DaHuy,dp.SoPhongDaDat,dp.ThanhToan,dp.PhuongThucThanhToan " +
	             "FROM DatPhong dp, Phong p, KhachSan k, Users u " +
	             "WHERE u.Id = ? AND u.Id = k.IdUser AND k.Id = p.IdKhachSan AND p.Id = dp.IdPhong";
		List<DatPhongModel> list = new ArrayList<DatPhongModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idSheller);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DatPhongModel(
						rs.getInt("Id"),
						rs.getInt("IdUser"),
						rs.getInt("IdPhong"),
						rs.getDate("NgayDat"),
						rs.getDate("NgayDen"),
						rs.getDate("NgayTra"),
						rs.getString("GhiChu"),
						rs.getInt("ThanhTien"),
						rs.getInt("DaHuy"),
						rs.getInt("SoPhongDaDat"),
						rs.getBoolean("ThanhToan"),
						rs.getString("PhuongThucThanhToan")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateTrangThaiTT(int idDatPhong) {
		String sql = "UPDATE DatPhong SET ThanhToan = ? WHERE Id = ?";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setBoolean(1, true);
			ps.setInt(2, idDatPhong);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int idDatPhong) {
		String sql = "DELETE DatPhong WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDatPhong);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DatPhongModel> listKhachDatPhong(int idSheller) {
		String sql = "SELECT dp.Id, dp.IdUser, dp.IdPhong, dp.NgayDat, dp.NgayDen, dp.NgayTra, dp.GhiChu, dp.ThanhTien, dp.DaHuy, dp.SoPhongDaDat, dp.ThanhToan, dp.PhuongThucThanhToan " +
	             "FROM DatPhong dp, Phong p, KhachSan k, Users u " +
	             "WHERE u.Id = ? " +
	             "AND u.Id = k.IdUser " +
	             "AND k.Id = p.IdKhachSan " +
	             "AND p.Id = dp.IdPhong " +
	             "AND dp.Id IN ( " +
	             "    SELECT MIN(dp1.Id) " +
	             "    FROM DatPhong dp1 " +
	             "    GROUP BY dp1.IdUser " +
	             ")";
		List<DatPhongModel> list = new ArrayList<DatPhongModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idSheller);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DatPhongModel(
						rs.getInt("Id"),
						rs.getInt("IdUser"),
						rs.getInt("IdPhong"),
						rs.getDate("NgayDat"),
						rs.getDate("NgayDen"),
						rs.getDate("NgayTra"),
						rs.getString("GhiChu"),
						rs.getInt("ThanhTien"),
						rs.getInt("DaHuy"),
						rs.getInt("SoPhongDaDat"),
						rs.getBoolean("ThanhToan"),
						rs.getString("PhuongThucThanhToan")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countDatPhongByIdUser(int idUser) {
		String sql = "SELECT COUNT(IdUser) " +
	             "FROM DatPhong " +
	             "WHERE IdUser = ?";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public int sumTienDatPhongByIdUser(int idUser, int idKS) {
		String sql = "SELECT SUM(ThanhTien) " +
	             "FROM DatPhong dp, Phong p, KhachSan k " +
	             "WHERE dp.IdUser = ? AND k.Id = ? AND p.IdKhachSan = k.id AND p.Id = dp.IdPhong";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idKS);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return 0;
	}
}
