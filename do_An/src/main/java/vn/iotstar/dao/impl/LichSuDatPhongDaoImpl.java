package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQL;
import vn.iotstar.dao.ILichSuDatPhong;
import vn.iotstar.models.LichSuModel;

public class LichSuDatPhongDaoImpl extends DBConnectionSQL implements ILichSuDatPhong {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<LichSuModel> findByIdUser(int idUser) {
		String sql = "select D.Id as idThue, P.Ten as TenPhong, P.AnhPhong as anhPhong, K.Id as idKS, K.Ten as TenKS, D.NgayDat as ngayDat, D.NgayDen as ngayDen, D.NgayTra as ngayTra, D.GhiChu as ghiChu, D.ThanhTien as thanhTien, D.DaHuy as trangThai "
				+ "from KhachSan K, Phong P, DatPhong D, Users U "
				+ "where D.IdUser = ? and U.Id = D.IdUser and D.IdPhong = P.Id and P.IdKhachSan = K.Id";
		List<LichSuModel> list = new ArrayList<LichSuModel>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LichSuModel(
						rs.getInt("idThue"),
						rs.getString("TenPhong"),
						rs.getInt("idKS"),
						rs.getString("TenKS"),
						rs.getDate("ngayDat"),
						rs.getDate("ngayDen"),
						rs.getDate("ngayTra"),
						rs.getString("ghiChu"),
						rs.getString("thanhTien"),
						rs.getInt("trangThai"),
						rs.getString("anhPhong"),
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
			ILichSuDatPhong userDao = new LichSuDatPhongDaoImpl();

			List<LichSuModel> list = userDao.findByIdUser(1);
			for (LichSuModel user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
