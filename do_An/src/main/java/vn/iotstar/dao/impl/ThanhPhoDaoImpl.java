package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.IThanhPhoDao;
import vn.iotstar.models.ThanhPhoModel;

public class ThanhPhoDaoImpl extends DBConnectionSQL implements IThanhPhoDao  {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<ThanhPhoModel> findAll() {
		String sql = "select T.Id as A, T.Ten as B, T.MoTa as C, T.UrlHinhAnh as D, count(K.Id) as E from ThanhPho T left join KhachSan K on T.Id = K.IdThanhPho group by T.Id, T.Ten, T.MoTa, T.UrlHinhAnh";
		List<ThanhPhoModel> list = new ArrayList<ThanhPhoModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ThanhPhoModel(rs.getInt("A"), rs.getString("B"), rs.getString("C"), rs.getString("D"), rs.getInt("E")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(ThanhPhoModel thanhpho) {
		String sql = "INSERT INTO ThanhPho(Ten, MoTa, UrlHinhAnh) VALUES (?, ?, ?)";

		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, thanhpho.getTen());
			ps.setString(2, thanhpho.getMoTa());
			ps.setString(3, thanhpho.getUrlHinhAnh());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(ThanhPhoModel thanhpho) {
		String sql = "UPDATE ThanhPho SET  Ten = ?, MoTa = ?, UrlHinhAnh = ? WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, thanhpho.getTen());
			ps.setString(2, thanhpho.getMoTa());
			ps.setString(3, thanhpho.getUrlHinhAnh());
			ps.setInt(4, thanhpho.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int idthanhpho) {
		String sql = "DELETE ThanhPho WHERE Id = ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idthanhpho);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		try {
			IThanhPhoDao thanhphoDao = new ThanhPhoDaoImpl();
			thanhphoDao.insert(new ThanhPhoModel("Đồng Nai", "Thanh phố Biên Hòa", "imgae"));
			List<ThanhPhoModel> list = thanhphoDao.findAll();
			for (ThanhPhoModel user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public ThanhPhoModel findByName(String tenDiaDiem) {
		String sql = "Select * from ThanhPho where Ten =  ?";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenDiaDiem);
			rs = ps.executeQuery();
			while (rs.next())
			{
				ThanhPhoModel thanhpho = new ThanhPhoModel();
				thanhpho.setId(rs.getInt("Id"));
				thanhpho.setTen(rs.getString("Ten"));
				thanhpho.setMoTa(rs.getString("MoTa"));
				thanhpho.setUrlHinhAnh(rs.getString("UrlHinhAnh"));
				return thanhpho;
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
