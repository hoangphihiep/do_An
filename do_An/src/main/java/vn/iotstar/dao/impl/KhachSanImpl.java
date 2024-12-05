package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IKhachSanDao;
import vn.iotstar.models.KhachSanModel;

public class KhachSanImpl extends DBConnectionSQL implements IKhachSanDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<KhachSanModel> findAll() {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi, IdUser, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,T.Ten as TenDiaDiem, "
				+ "IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh, K.Status as Status, K.Active as Active "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdUser"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"), 
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(KhachSanModel khachsan) {
		String sql = "INSERT INTO KhachSan(Ten, DiaChi, IdUser, CachTrungTam, MoTa, GiapBien, DanhGia, IdDiaDiem, IdLoaiKhachSan, Status, Active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khachsan.getTen());
			ps.setString(2, khachsan.getDiaChi());
			ps.setInt(3, khachsan.getidUser());
			ps.setInt(4, khachsan.getCachTrungTam());
			ps.setString(5, khachsan.getMoTa());
			ps.setBoolean(6, khachsan.isGiapBien());
			ps.setInt(7, khachsan.getDanhGia());
			ps.setInt(8, khachsan.getIdDiaDiem());
			ps.setInt(9, khachsan.getIdLoaiKhachSan());
			ps.setInt(10, khachsan.getStatus());
			ps.setBoolean(11, khachsan.isActive());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(KhachSanModel khachsan) {
		String sql = "UPDATE KhachSan SET  Ten = ?, DiaChi = ?, IdUser = ?, CachTrungTam = ?, MoTa = ?, GiapBien = ?, DanhGia = ?, IdDiaDiem = ?, IdLoaiKhachSan = ?, Status = ?, Active = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khachsan.getTen());
			ps.setString(2, khachsan.getDiaChi());
			ps.setInt(3, khachsan.getidUser());
			ps.setInt(4, khachsan.getCachTrungTam());
			ps.setString(5, khachsan.getMoTa());
			ps.setBoolean(6, khachsan.isGiapBien());
			ps.setInt(7, khachsan.getDanhGia());
			ps.setInt(8, khachsan.getIdDiaDiem());
			ps.setInt(9, khachsan.getIdLoaiKhachSan());
			ps.setInt(10, khachsan.getStatus());
			ps.setBoolean(11, khachsan.isActive());
			ps.setInt(12, khachsan.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idkhachsan) {
		String sql = "DELETE KhachSan WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idkhachsan);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

		try {
			IKhachSanDao khachsanDao = new KhachSanImpl();
			//thanhphoDao.insert(new ThanhPhoModel("Đồng Nai", "Thanh phố Biên Hòa", "imgae"));
			khachsanDao.update(new KhachSanModel());
			List<KhachSanModel> list = khachsanDao.findByIdUser(5);
			for(KhachSanModel ks : list) {
				System.out.println (ks.getId() + ks.getTen());
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<KhachSanModel> findByIdDiaDiem(int currentPage, int idDiaDiem) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi,IdUser, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,"
				+ "T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, "
				+ "T.UrlHinhAnh, K.Status as Status, K.Active as Active "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where T.Id = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id AND K.Status = 1 ORDER BY K.Id DESC " 
				+ "OFFSET " + ((currentPage - 1) * 5) + " ROWS FETCH NEXT " + 5 + " ROWS ONLY";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDiaDiem);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdUser"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"), 
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public KhachSanModel findById(int id) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi,IdUser, CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where K.Id = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next())
			{
				KhachSanModel khachsan = new KhachSanModel();
				khachsan.setId(rs.getInt("Id"));;
				khachsan.setTen(rs.getString("Ten"));
				khachsan.setDiaChi(rs.getString("DiaChi"));
				khachsan.setidUser(rs.getInt("IdUser"));
				khachsan.setCachTrungTam(rs.getInt("CachTrungTam"));
				khachsan.setMoTa(rs.getString("MoTa"));
				khachsan.setGiapBien(rs.getBoolean("GiapBien"));
				khachsan.setDanhGia(rs.getInt("DanhGia"));
				khachsan.setIdDiaDiem(rs.getInt("IdDiaDiem"));
				khachsan.setTenDiaDiem(rs.getString("TenDiaDiem"));
				khachsan.setIdLoaiKhachSan(rs.getInt("IdLoaiKhachSan"));
				khachsan.setTenLoaiKhachSan(rs.getString("TenLoaiKhachSan"));
				khachsan.setUrlHinhAnhThanhPho(rs.getString("UrlHinhAnh"));
				return khachsan;
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
	public List<KhachSanModel> findByIdLoaiKhachSan(int currentPage,int idLoaiKhachSan) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi, IdUser, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,"
				+ "T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, "
				+ "T.UrlHinhAnh, K.Status as Status, K.Active as Active "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where L.Id = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id AND K.Status = 1 ORDER BY K.Id DESC "
				+ "OFFSET " + ((currentPage - 1) * 5) + " ROWS FETCH NEXT " + 5 + " ROWS ONLY";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idLoaiKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(
						rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdUser"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"),  
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<KhachSanModel> findAllPage(int indexp) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi, IdUser, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,"
				+ "T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, "
				+ "T.UrlHinhAnh, K.Status as Status, K.Active as Active "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id AND K.Status = 1 "
				+ "ORDER BY K.Id DESC OFFSET ? rows fetch next 3 rows only";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(
						rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdUser"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"),  
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countAllByIdDiaDiem(int idDiaDiem) {
		String sql = "select count (*)"
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where T.Id = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id AND K.Status = 1 ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDiaDiem);
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
	public int countAllByIdLoaiKS(int idLoaiKS) {
		String sql = "select count (*)"
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where L.Id = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id AND K.Status = 1 ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idLoaiKS);
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
	public List<KhachSanModel> findByIdDiaDiem(int idDiaDiem) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi, IdUser, CachTrungTam, "
				+ "K.MoTa, GiapBien, DanhGia, K.Status as Status, K.Active as Active, "
				+ "K.IdDiaDiem as IdDiaDiem,T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where T.Id = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id AND K.Status = 1 ORDER BY K.Id DESC ";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDiaDiem);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(
						rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdUser"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"),
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<KhachSanModel> findByIdLoaiKhachSan(int idLoaiKhachSan) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi, IdUser, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem, "
				+ "T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, "
				+ "T.UrlHinhAnh, K.Status as Status, K.Active as Active "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where L.Id = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id AND K.Status = 1 ORDER BY K.Id DESC ";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idLoaiKhachSan);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(
						rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdUser"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"),
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int maxId() {
		String sql = "select MAX(Id) from KhachSan";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
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
	public KhachSanModel findByName(String tenKS) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi, IdUser, CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "where K.Ten = ? and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenKS);
			rs = ps.executeQuery();
			while (rs.next())
			{
				KhachSanModel khachsan = new KhachSanModel();
				khachsan.setId(rs.getInt("Id"));;
				khachsan.setTen(rs.getString("Ten"));
				khachsan.setDiaChi(rs.getString("DiaChi"));
				khachsan.setidUser(rs.getInt("IdUser"));;
				khachsan.setCachTrungTam(rs.getInt("CachTrungTam"));
				khachsan.setMoTa(rs.getString("MoTa"));
				khachsan.setGiapBien(rs.getBoolean("GiapBien"));
				khachsan.setDanhGia(rs.getInt("DanhGia"));
				khachsan.setIdDiaDiem(rs.getInt("IdDiaDiem"));
				khachsan.setTenDiaDiem(rs.getString("TenDiaDiem"));
				khachsan.setIdLoaiKhachSan(rs.getInt("IdLoaiKhachSan"));
				khachsan.setTenLoaiKhachSan(rs.getString("TenLoaiKhachSan"));
				khachsan.setUrlHinhAnhThanhPho(rs.getString("UrlHinhAnh"));
				return khachsan;
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
	public List<KhachSanModel> findByIdUser(int idUser) {
		String sql = "select K.Id as Id, K.Ten as Ten, K.DiaChi as DiaChi, IdUser, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem, "
				+ "T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, "
				+ "T.UrlHinhAnh, K.Status as Status, K.Active as Active "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L, Users U "
				+ "where U.Id = ? and U.Id = K.IdUser and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id ORDER BY K.Id DESC ";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(
						rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdUser"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"),
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<KhachSanModel> findByDatPhong() {
		String sql = "SELECT p.IdKhachSan AS MaKhachSan, "
				+ "SUM(dp.SoPhongDaDat) AS TongSoPhongDaDat, K.Id as Id, K.Ten as Ten, DiaChi, K.IdUser as IdSheller, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,T.Ten as TenDiaDiem, "
				+ "IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh, K.Status as Status, K.Active as Active "
				+ "FROM "
				+ "Phong p LEFT JOIN DatPhong dp ON p.Id = dp.IdPhong, KhachSan K, DiaDiem T,LoaiKhachSan L "
				+ "WHERE K.Id = p.IdKhachSan AND K.Status = 1 AND K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id "
				+ "GROUP BY p.IdKhachSan, K.Id, K.Ten, K.DiaChi, K.IdUser, K.CachTrungTam, K.MoTa, K.GiapBien, K.DanhGia, K.IdDiaDiem, "
				+ "T.Ten, K.IdLoaiKhachSan, L.Ten, T.UrlHinhAnh, K.Status, K.Active "
				+ "ORDER BY TongSoPhongDaDat DESC;";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getInt("IdSheller"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"), 
						rs.getInt("IdDiaDiem"), 
						rs.getString("TenDiaDiem"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh"),
						rs.getInt("Status"),
						rs.getBoolean("Active")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
