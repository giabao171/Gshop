package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;

public class hoadondao {

	public int themhoadon(Long makh, Date ngayMua, Boolean damua) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "insert into hoadon(makh, ngaymua, damua) values (?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// Truyen cau lenh vao tham so
		java.sql.Date ns = new java.sql.Date(ngayMua.getTime());

		cmd.setLong(1, makh);
		cmd.setDate(2, ns);
		cmd.setBoolean(3, damua);

		return cmd.executeUpdate();
	}
	
	public long getmhd_moinhat() throws SQLException {
		KetNoi kn =new KetNoi();
		kn.KetNoi();
		String sql="select top 1 mahoadon from hoadon order by mahoadon desc";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		long mhd = 0;
		while (rs.next()){
			mhd = rs.getLong("mahoadon");
	    }
		rs.close();
		return mhd;
	}
	
	public long sethd_damua(long mhd) throws SQLException {
		KetNoi kn =new KetNoi();
		kn.KetNoi();
		String sql="update hoadon set damua = 1 where mahoadon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, mhd);
		return cmd.executeUpdate();
	}
	
	public ArrayList<hoadonbean> gethd_chuamua() throws SQLException {
		try {
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String  sql ="select * from hoadon where damua = 0";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			 ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
			//Luu all du lie vao mang
			while (rs.next()) {
				Long maHoaDon = rs.getLong("mahoadon");
				Long makh = rs.getLong("makh");
				Date ngayMua = rs.getDate("ngaymua");
				Boolean damua = rs.getBoolean("damua");
				ds.add(new hoadonbean(maHoaDon, makh, ngayMua, damua));
			}
			//Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<hoadonbean> gethd_damua() throws SQLException {
		try {
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String  sql ="select * from hoadon where damua = 1";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			 ArrayList<hoadonbean> ds = new ArrayList<hoadonbean>();
			//Luu all du lie vao mang
			while (rs.next()) {
				Long maHoaDon = rs.getLong("mahoadon");
				Long makh = rs.getLong("makh");
				Date ngayMua = rs.getDate("ngaymua");
				Boolean damua = rs.getBoolean("damua");
				ds.add(new hoadonbean(maHoaDon, makh, ngayMua, damua));
			}
			//Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
