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
		String sql = "INSERT INTO DanhGia(Diem, NoiDung, IdKhachHang, IdKhachSan, UrlHinhAnhDanhGia) VALUES (?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, danhGia.getDiem());
			ps.setString(2, danhGia.getNoiDung());
			ps.setInt(3, danhGia.getIdKhachHang());
			ps.setInt(4, danhGia.getIdKhachSan());
			ps.setString(5, danhGia.getUrlHinhAnhDanhGia());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(DanhGiaModel danhGia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idDanhGia) {
		String sql = "DELETE DanhGia WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDanhGia);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<DanhGiaModel> findByIdKhachSan(int currentPage, int idKhachSan) {
		String sql = "select d.Id as Id, d.Diem as Diem, d.NoiDung as NoiDung, d.IdKhachHang as IdKhachHang, d.IdKhachSan as IdKhachSan, u.Fullname as Ten, d.UrlHinhAnhDanhGia as HinhAnhDanhGia "
				+ "from DanhGia d, Users u "
				+ "where d.IdKhachSan = ? and d.IdKhachHang = u.Id ORDER BY d.Id DESC "
				+ "OFFSET " + ((currentPage - 1) * 3) + " ROWS FETCH NEXT " + 3 + " ROWS ONLY";
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
						rs.getInt("IdKhachSan"),
						rs.getString("Ten"),
						rs.getString("HinhAnhDanhGia")));
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

	@Override
	public int countAllByIdKhachSan(int idKhachSan) {
		String sql = "select count (*)"
				+ "from DanhGia d, Users u "
				+ "where d.IdKhachSan = ? and d.IdKhachHang = u.Id";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idKhachSan);
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
	public List<DanhGiaModel> findByIdKhachSan(int idKhachSan) {
		String sql = "select d.Id as Id, d.Diem as Diem, d.NoiDung as NoiDung, d.IdKhachHang as IdKhachHang, d.IdKhachSan as IdKhachSan, u.Fullname as Ten, d.UrlHinhAnhDanhGia as HinhAnhDanhGia "
				+ "from DanhGia d, Users u "
				+ "where d.IdKhachSan = ? and d.IdKhachHang = u.Id";
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
						rs.getInt("IdKhachSan"),
						rs.getString("Ten"),
						rs.getString("HinhAnhDanhGia")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	  public static void main(String[] args) {
	 
			  try { 
				  IDanhGiaDao danhGiaDao = new DanhGiaDaoImpl();
				  danhGiaDao.insert(new DanhGiaModel(5,"khoong cos",1005,1,"image"));
			  } catch (Exception e) {
			  
			  e.printStackTrace(); }
	  
	  }

	@Override
	public List<DanhGiaModel> findByIdSheller(int idSheller) {
		String sql = "select d.Id as Id, d.Diem as Diem, d.NoiDung as NoiDung, d.IdKhachHang as IdKhachHang, d.IdKhachSan as IdKhachSan, u.Fullname as Ten, d.UrlHinhAnhDanhGia as HinhAnhDanhGia "
				+ "from DanhGia d, Users u, KhachSan k "
				+ "where u.Id = ? and u.Id = k.IdUser and k.Id = d.IdKhachSan";
		List<DanhGiaModel> list = new ArrayList<DanhGiaModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idSheller);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DanhGiaModel(
						rs.getInt("Id"),
						rs.getInt("Diem"),
						rs.getString("NoiDung"),
						rs.getInt("IdKhachHang"),
						rs.getInt("IdKhachSan"),
						rs.getString("Ten"),
						rs.getString("HinhAnhDanhGia")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 

}
