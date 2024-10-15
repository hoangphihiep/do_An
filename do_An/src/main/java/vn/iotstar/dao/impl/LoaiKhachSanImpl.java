package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.ILoaiKhachSanDao;
import vn.iotstar.models.LoaiKhachSanModel;

public class LoaiKhachSanImpl extends DBConnectionSQL implements ILoaiKhachSanDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<LoaiKhachSanModel> findAll() {
		String sql = "select L.Id as A, L.Ten as B, L.MoTa as C, L.UrlHinhAnh as D, count(L.Id) as E from LoaiKhachSan L left join KhachSan K on L.Id = K.IdLoaiKhachSan group by L.Id, L.Ten, L.MoTa, L.UrlHinhAnh";
		List<LoaiKhachSanModel> list = new ArrayList<LoaiKhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LoaiKhachSanModel(rs.getInt("A"), rs.getString("B"), rs.getString("C"), rs.getString("D"), rs.getInt("E")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(LoaiKhachSanModel loaikhachsan) {
		String sql = "INSERT INTO LoaiKhachSan(Ten, MoTa, UrlHinhAnh) VALUES (?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, loaikhachsan.getTen());
			ps.setString(2, loaikhachsan.getMoTa());
			ps.setString(3, loaikhachsan.getUrlHinhAnh());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(LoaiKhachSanModel loaikhachsan) {
		String sql = "UPDATE LoaiKhachSan SET  Ten = ?, MoTa = ?, UrlHinhAnh = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, loaikhachsan.getTen());
			ps.setString(2, loaikhachsan.getMoTa());
			ps.setString(3, loaikhachsan.getUrlHinhAnh());
			ps.setInt(4, loaikhachsan.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idloaikhachsan) {
		String sql = "DELETE LoaiKhachSan WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idloaikhachsan);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		try {
			ILoaiKhachSanDao loaikhachsanDao = new LoaiKhachSanImpl();
			//thanhphoDao.insert(new ThanhPhoModel("Đồng Nai", "Thanh phố Biên Hòa", "imgae"));
			List<LoaiKhachSanModel> list = loaikhachsanDao.findAll();
			for (LoaiKhachSanModel loaikhachsan : list) {
				System.out.println(loaikhachsan);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<LoaiKhachSanModel> listTenLoaiKhachSan() {
		String sql = "select Ten from LoaiKhachSan";
		List<LoaiKhachSanModel> listTen = new ArrayList<LoaiKhachSanModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listTen.add(new LoaiKhachSanModel(rs.getString("Ten")));
			}
			return listTen;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
