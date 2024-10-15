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
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi,SoDienThoai, CachTrungTam, K.MoTa, GiapBien, DanhGia, BuaAn, IdThanhPho,T.Ten as TenThanhPho, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh from KhachSan K, ThanhPho T,LoaiKhachSan L where K.IdThanhPho = T.Id and K.IdLoaiKhachSan = L.Id";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getString("SoDienThoai"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"), 
						rs.getInt("BuaAn"), 
						rs.getInt("IdThanhPho"), 
						rs.getString("TenThanhPho"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(KhachSanModel khachsan) {
		String sql = "INSERT INTO KhachSan(Ten, DiaChi, SoDienthoai, CachTrungTam, MoTa, GiapBien, DanhGia, BuaAn, IdThanhPho, IdLoaiKhachSan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khachsan.getTen());
			ps.setString(2, khachsan.getDiaChi());
			ps.setString(3, khachsan.getSoDienThoai());
			ps.setInt(4, khachsan.getCachTrungTam());
			ps.setString(5, khachsan.getMoTa());
			ps.setBoolean(6, khachsan.isGiapBien());
			ps.setInt(7, khachsan.getDanhGia());
			ps.setInt(8, khachsan.getBuaAn());
			ps.setInt(9, khachsan.getIdThanhPho());
			ps.setInt(10, khachsan.getIdLoaiKhachSan());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(KhachSanModel khachsan) {
		String sql = "UPDATE KhachSan SET  Ten = ?, DiaChi = ?, SoDienthoai = ?, CachTrungTam = ?, MoTa = ?, GiapBien = ?, DanhGia = ?, BuaAn = ?, IdThanhPho = ?, IdLoaiKhachSan = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, khachsan.getTen());
			ps.setString(2, khachsan.getDiaChi());
			ps.setString(3, khachsan.getSoDienThoai());
			ps.setInt(4, khachsan.getCachTrungTam());
			ps.setString(5, khachsan.getMoTa());
			ps.setBoolean(6, khachsan.isGiapBien());
			ps.setInt(7, khachsan.getDanhGia());
			ps.setInt(8, khachsan.getBuaAn());
			ps.setInt(9, khachsan.getIdThanhPho());
			ps.setInt(10, khachsan.getIdLoaiKhachSan());
			ps.setInt(11, khachsan.getId());
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
			List<KhachSanModel> list = khachsanDao.findAll();
			for (KhachSanModel khachsan : list) {
				System.out.println(khachsan);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<KhachSanModel> findByIdThanhPho(int idThanhPho) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi,SoDienThoai, CachTrungTam, K.MoTa, GiapBien, DanhGia, BuaAn, IdThanhPho,T.Ten as TenThanhPho, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh from KhachSan K, ThanhPho T,LoaiKhachSan L where T.Id = ? and K.IdThanhPho = T.Id and K.IdLoaiKhachSan = L.Id";
		List<KhachSanModel> list = new ArrayList<KhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idThanhPho);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachSanModel(rs.getInt("Id"), 
						rs.getString("Ten"), 
						rs.getString("DiaChi"), 
						rs.getString("SoDienThoai"), 
						rs.getInt("CachTrungTam"),
						rs.getString("MoTa"),
						rs.getBoolean("GiapBien"),
						rs.getInt("DanhGia"), 
						rs.getInt("BuaAn"), 
						rs.getInt("IdThanhPho"), 
						rs.getString("TenThanhPho"),
						rs.getInt("IdLoaiKhachSan"),
						rs.getString("TenLoaiKhachSan"),
						rs.getString("UrlHinhAnh")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public KhachSanModel findById(int id) {
		String sql = "select K.Id as Id, K.Ten as Ten, DiaChi,SoDienThoai, CachTrungTam, K.MoTa, GiapBien, DanhGia, BuaAn, IdThanhPho,T.Ten as TenThanhPho, IdLoaiKhachSan, L.Ten as TenLoaiKhachSan, T.UrlHinhAnh from KhachSan K, ThanhPho T,LoaiKhachSan L where K.Id = ? and K.IdThanhPho = T.Id and K.IdLoaiKhachSan = L.Id";
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
				khachsan.setSoDienThoai(rs.getString("SoDienThoai"));
				khachsan.setCachTrungTam(rs.getInt("CachTrungTam"));
				khachsan.setMoTa(rs.getString("MoTa"));
				khachsan.setGiapBien(rs.getBoolean("GiapBien"));
				khachsan.setDanhGia(rs.getInt("DanhGia"));
				khachsan.setBuaAn(rs.getInt("BuaAn"));
				khachsan.setIdThanhPho(rs.getInt("IdThanhPho"));
				khachsan.setTenThanhPho(rs.getString("TenThanhPho"));
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
}
