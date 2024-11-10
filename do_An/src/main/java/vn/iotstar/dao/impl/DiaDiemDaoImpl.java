package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IDiaDiemDao;
import vn.iotstar.models.DiaDiemModel;

public class DiaDiemDaoImpl extends DBConnectionSQL implements IDiaDiemDao  {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<DiaDiemModel> findAll() {
		String sql = "select T.Id as A, T.Ten as B, T.MoTa as C, T.UrlHinhAnh as D, count(K.Id) as E from DiaDiem T left join KhachSan K on T.Id = K.IdDiaDiem group by T.Id, T.Ten, T.MoTa, T.UrlHinhAnh";
		List<DiaDiemModel> list = new ArrayList<DiaDiemModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DiaDiemModel(rs.getInt("A"), rs.getString("B"), rs.getString("C"), rs.getString("D"), rs.getInt("E")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(DiaDiemModel diaDiem) {
		String sql = "INSERT INTO DiaDiem(Ten, MoTa, UrlHinhAnh) VALUES (?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, diaDiem.getTen());
			ps.setString(2, diaDiem.getMoTa());
			ps.setString(3, diaDiem.getUrlHinhAnh());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(DiaDiemModel diaDiem) {
		String sql = "UPDATE DiaDiem SET  Ten = ?, MoTa = ?, UrlHinhAnh = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, diaDiem.getTen());
			ps.setString(2, diaDiem.getMoTa());
			ps.setString(3, diaDiem.getUrlHinhAnh());
			ps.setInt(4, diaDiem.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int idDiaDiem) {
		String sql = "DELETE DiaDiem WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDiaDiem);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		try {
			IDiaDiemDao thanhphoDao = new DiaDiemDaoImpl();
			thanhphoDao.insert(new DiaDiemModel("Đồng Nai", "Thanh phố Biên Hòa", "imgae"));
			List<DiaDiemModel> list = thanhphoDao.findAll();
			for (DiaDiemModel user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public DiaDiemModel findByName(String tenDiaDiem) {
		String sql = "Select * from DiaDiem where Ten =  ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenDiaDiem);
			rs = ps.executeQuery();
			while (rs.next())
			{
				DiaDiemModel diaDiem = new DiaDiemModel();
				diaDiem.setId(rs.getInt("Id"));
				diaDiem.setTen(rs.getString("Ten"));
				diaDiem.setMoTa(rs.getString("MoTa"));
				diaDiem.setUrlHinhAnh(rs.getString("UrlHinhAnh"));
				return diaDiem;
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
