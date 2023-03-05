package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.lichsumuahangbean;

public class lichsumuahangdao {
	public ArrayList<lichsumuahangbean> getlsmh(long maKH) throws SQLException {
		ArrayList<lichsumuahangbean> ds = new ArrayList<lichsumuahangbean>();
		KetNoi kn = new KetNoi();
		kn.KetNoi();

		String sql = "select * from VLSMH where makh = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// Truyen cau lenh vao tham so
		cmd.setLong(1, maKH);

		// Thuc hien
		ResultSet rs = cmd.executeQuery();
		lichsumuahangbean lsmh = null;
		while (rs.next()) {
			long maHoaDon = rs.getLong("mahoadon");
			String tensach = rs.getString("tenmohinh");
			Date ngayMua = rs.getDate("ngaymua");
			int soLuongMua = rs.getInt("soluongmua");
			long gia = rs.getLong("gia");
			long thanhTien = rs.getLong("thanhtien");
			boolean damua = rs.getBoolean("damua");
			String anh = rs.getString("anh");
			String mamh = rs.getString("mamohinh");
			lsmh = new lichsumuahangbean(maHoaDon, tensach, ngayMua, soLuongMua, gia, thanhTien, damua, anh, mamh);
			ds.add(lsmh);
		}
		rs.close();
		return ds;

	}

}
