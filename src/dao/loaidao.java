package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getdsloai () {
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		try {
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String  sql ="select * from loai";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			//Luu all du lie vao mang
			while (rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				ds.add(new loaibean(maloai, tenloai));
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
	
	public loaibean getloaiitem(String maloai) throws SQLException {
	
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String  sql ="select * from loai where maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,maloai);
			ResultSet rs = cmd.executeQuery();
			//Luu all du lie vao mang
			loaibean lbean = null;
			while (rs.next()) {
				String maLoai = rs.getString("maloai");
				String tenloai =rs.getString("tenloai");
				lbean = new loaibean(maLoai, tenloai);
			}
			//Dong ket noi
			rs.close();
			kn.cn.close();
			return lbean;
	}
	
	public int ktdemloai(String ml) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="select count(maloai) from mohinh where maloai=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
//			int soluong = 0;
			//Luu all du lie vao mang
			while (rs.next()) {
				return (int)rs.getInt(1);
			}
			//Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public int ktdemloai_loai(String ml) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="select count(maloai) from loai where maloai=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
//			int soluong = 0;
			//Luu all du lie vao mang
			while (rs.next()) {
				return (int)rs.getInt(1);
			}
			//Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public int themloai(String ml, String tl) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="insert into loai(maloai, tenloai) values(?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//Truyen cau lenh vao tham so
			cmd.setString(1,ml);
			cmd.setString(2,tl);
			return cmd.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int xoaloai(String ml) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="delete from loai where maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//Truyen cau lenh vao tham so
			cmd.setString(1,ml);
			return cmd.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int sualoai(String mlmoi, String tlmoi, String mlcu) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="UPDATE loai SET maloai = ?, tenloai = ? WHERE maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//Truyen cau lenh vao tham so
			cmd.setString(1,mlmoi);
			cmd.setString(2,tlmoi);
			cmd.setString(3,mlcu);
			return cmd.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
}
