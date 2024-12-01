package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IThichKhachSanDao;
import vn.iotstar.models.KhachSanModel;
import vn.iotstar.models.ThichKhachSanModel;

public class ThichKhachSanDaoImpl extends DBConnectionSQL implements IThichKhachSanDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public boolean isHotelLikedByUser(int idUser, int idKS) {
		String sql = "SELECT * FROM KhachSanThich WHERE IdUser = ? AND IdKhachSan = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
            ps.setInt(2, idKS);
			rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void likeHotel(int idUser, int idKS) {
		String sql = "INSERT INTO KhachSanThich(IdUser, IdKhachSan) VALUES (?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idKS);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void unlikeHotel(int idUser, int idKS) {
		String sql = "DELETE KhachSanThich WHERE IdUser = ? AND IdKhachSan = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idKS);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ThichKhachSanModel> listLikeHotel(int idUser) {
		String sql = "select * "
				+ "from KhachSanThich "
				+ "where KhachSanThich.IdUser = ?";
		List<ThichKhachSanModel> list = new ArrayList<ThichKhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ThichKhachSanModel(
						rs.getInt("Id"),
						rs.getInt("IdUser"),
						rs.getInt("IdKhachSan")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ThichKhachSanModel> findAll(int currentPage, int idUser) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi,K.IdUser AS IdSheller, "
				+ "CachTrungTam, K.MoTa, GiapBien, DanhGia, IdDiaDiem,"
				+ "T.Ten as TenDiaDiem, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, "
				+ "T.UrlHinhAnh, K.Status as Status, K.Active as Active, KT.Id as IdThichKS, KT.IdUser as IdNguoiDung "
				+ "from KhachSan K, DiaDiem T,LoaiKhachSan L, KhachSanThich KT "
				+ "where KT.IdUser = ? and K.Id = KT.IdKhachSan and K.IdDiaDiem = T.Id and K.IdLoaiKhachSan = L.Id ORDER BY K.Id DESC " 
				+ "OFFSET " + ((currentPage - 1) * 5) + " ROWS FETCH NEXT " + 5 + " ROWS ONLY";
		List<ThichKhachSanModel> list = new ArrayList<ThichKhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ThichKhachSanModel(
						rs.getInt("IdThichKS"),
						rs.getInt("IdNguoiDung"),
						rs.getInt("Id"),
						new KhachSanModel(rs.getInt("Id"), 
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
								rs.getBoolean("Active"))));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countAll() {
		String sql = "select count (*) from KhachSanThich";
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

}
