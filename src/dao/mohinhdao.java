package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.mohinhbean;

public class mohinhdao {
	public ArrayList<mohinhbean> getdsmohinh(int index) {
		ArrayList<mohinhbean> ds = new ArrayList<mohinhbean>();
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from mohinh order by mamohinh OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, (index - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			// Luu all du lie vao mang
			while (rs.next()) {
				String mamohinh = rs.getString("mamohinh");
				String tenmohinh = rs.getString("tenmohinh");
				int soluong = rs.getInt("soluong");
				int gia = rs.getInt("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String nhasanxuat = rs.getString("nhasanxuat");
				String idriview = rs.getString("idreview");
				ds.add(new mohinhbean(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat, idriview));
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<mohinhbean> getdsrandommohinh() {
		ArrayList<mohinhbean> ds = new ArrayList<mohinhbean>();
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "SELECT TOP 5 mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat, idreview FROM mohinh\r\n"
					+ "ORDER BY NEWID()";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// Luu all du lie vao mang
			while (rs.next()) {
				String mamohinh = rs.getString("mamohinh");
				String tenmohinh = rs.getString("tenmohinh");
				int soluong = rs.getInt("soluong");
				int gia = rs.getInt("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String nhasanxuat = rs.getString("nhasanxuat");
				String idriview = rs.getString("idreview");
				ds.add(new mohinhbean(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat, idriview));
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public mohinhbean getctmohinh(String mamh) throws SQLException {
		
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from mohinh where mamohinh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, mamh);
			ResultSet rs = cmd.executeQuery();
			mohinhbean mhbean = null;
			// Luu all du lie vao mang
			while (rs.next()) {
				String mamohinh = rs.getString("mamohinh");
				String tenmohinh = rs.getString("tenmohinh");
				int soluong = rs.getInt("soluong");
				int gia = rs.getInt("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String nhasanxuat = rs.getString("nhasanxuat");
				String idriviw = rs.getString("idreview");
				mhbean = new mohinhbean(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat, idriviw);
			}
			rs.close();
			kn.cn.close();
			return mhbean;
			
	}

	public ArrayList<mohinhbean> getdsloaimohinh(String key, int index) {
		ArrayList<mohinhbean> ds = new ArrayList<mohinhbean>();
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from mohinh where maloai = ? order by mamohinh OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, key);
			cmd.setInt(2, (index - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			// Luu all du lie vao mang
			while (rs.next()) {
				String mamohinh = rs.getString("mamohinh");
				String tenmohinh = rs.getString("tenmohinh");
				int soluong = rs.getInt("soluong");
				int gia = rs.getInt("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String nhasanxuat = rs.getString("nhasanxuat");
				String idriviw = rs.getString("idreview");
				ds.add(new mohinhbean(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat,idriviw));
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<mohinhbean> getdstimkiemmohinh(String key, int index) {
		ArrayList<mohinhbean> ds = new ArrayList<mohinhbean>();
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from mohinh where tenmohinh like ? order by mamohinh OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			cmd.setInt(2, (index - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			// Luu all du lie vao mang
			while (rs.next()) {
				String mamohinh = rs.getString("mamohinh");
				String tenmohinh = rs.getString("tenmohinh");
				int soluong = rs.getInt("soluong");
				int gia = rs.getInt("gia");
				String maloai = rs.getString("maloai");
				String anh = rs.getString("anh");
				String nhasanxuat = rs.getString("nhasanxuat");
				String idriviw = rs.getString("idreview");
				ds.add(new mohinhbean(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat,idriviw));
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public int totalmohinh() {
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select count(mamohinh) as soluong from mohinh";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
//			int soluong = 0;
			// Luu all du lie vao mang
			while (rs.next()) {
				return (int) rs.getInt(1);
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int totalmohinh_ml(String key) {
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select count(mamohinh) as soluong  from mohinh where maloai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, key);
			ResultSet rs = cmd.executeQuery();
//			int soluong = 0;
			// Luu all du lie vao mang
			while (rs.next()) {
				return (int) rs.getInt(1);
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int totalmohinh_td(String key) {
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select count(mamohinh) as soluong  from mohinh where tenmohinh like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			ResultSet rs = cmd.executeQuery();
//			int soluong = 0;
			// Luu all du lie vao mang
			while (rs.next()) {
				return (int) rs.getInt(1);
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public int ktdemmohinh(String mmh) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="select count(mamohinh) from mohinh where mamohinh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, mmh);
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
	
	public int ktdemmohinh_chitiethd(String mmh) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql="select count(mamohinh) from chitiethoadon where mamohinh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, mmh);
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
	
	public int themmohinh (String mamohinh, String tenmohinh, int soluong, int gia, String maloai, String anh,
			String nhasanxuat, String idreview) {
		try {
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: lay du lieu ve
			String  sql ="insert into mohinh(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat, idreview) values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			//Truyen cau lenh vao tham so
			cmd.setString(1,mamohinh);
			cmd.setString(2,tenmohinh);
			cmd.setInt(3,soluong);
			cmd.setInt(4,gia);
			cmd.setString(5,maloai);
			cmd.setString(6,anh);
			cmd.setString(7,nhasanxuat);
			cmd.setString(8,idreview);
			
			
			return cmd.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int xoamohinh (String mamohinh) {
		try {
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: lay du lieu ve
			String  sql ="delete from mohinh where mamohinh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			//Truyen cau lenh vao tham so
			cmd.setString(1,mamohinh);
			return cmd.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int suamohinh (String mamohinh, String tenmohinh, int soluong, int gia, String maloai, String anh,
			String nhasanxuat, String idreview) {
		try {
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			
			//b2: lay du lieu ve
			String  sql ="update mohinh set tenmohinh = ?, soluong = ?, gia = ?, maloai = ?, anh = ?, nhasanxuat = ?, idreview = ? where mamohinh = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			
			//Truyen cau lenh vao tham so
			cmd.setString(1,tenmohinh);
			cmd.setInt(2,soluong);
			cmd.setInt(3,gia);
			cmd.setString(4,maloai);
			cmd.setString(5,anh);
			cmd.setString(6,nhasanxuat);
			cmd.setString(7,idreview);
			cmd.setString(8,mamohinh);
			
			return cmd.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}
