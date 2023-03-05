package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.khachhangbean;

public class khachhangdao {
	public khachhangbean ktdangnhap(String tenDN, String Pass) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql="select * from KhachHang where tendn = ? and pass = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		//Truyen cau lenh vao tham so
		cmd.setString(1,tenDN);
		cmd.setString(2,Pass);
		        
		//Thuc hien
		ResultSet rs = cmd.executeQuery();
		khachhangbean khb =null;
		while (rs.next()){
			long makh = rs.getLong("makh");
			String ht = rs.getString("hoten");
			String dc = rs.getString("diachi");
			String sdt = rs.getString("sdt");
			String email = rs.getString("email");
			String tdn = rs.getString("tendn");
			String pass = rs.getString("pass");
			khb = new khachhangbean(makh, ht, dc, sdt, email, tdn, pass);
	    }
		rs.close();
		kn.cn.close();
		return khb;
		
	}
	
	public int dangKy(String hoten, String diachi, String sdt, String email, String tendn, String pass)throws SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql="insert into KhachHang(hoten, diachi, sdt, email, tendn,pass) values (?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		//Truyen cau lenh vao tham so
		cmd.setString(1,hoten);
		cmd.setString(2,diachi);
		cmd.setString(3,sdt);
		cmd.setString(4,email);
		cmd.setString(5,tendn);
		cmd.setString(6,pass);
		
		return cmd.executeUpdate();
	}
	
	public int thaydoi(String hoten, String diachi, String sdt, String email, String tendn, String pass, long makh )throws SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql="update khachhang set hoten = ?, diachi = ?, sdt = ?, email = ?, tendn = ?, pass = ? where makh = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		//Truyen cau lenh vao tham so
		cmd.setString(1,hoten);
		cmd.setString(2,diachi);
		cmd.setString(3,sdt);
		cmd.setString(4,email);
		cmd.setString(5,tendn);
		cmd.setString(6,pass);
		cmd.setLong(7,makh);
		
		return cmd.executeUpdate();
	}
	
	public static String getMd5Hash(String input) {
	    try {
	      MessageDigest md = MessageDigest.getInstance("MD5");
	      byte[] messageDigest = md.digest(input.getBytes());
	      BigInteger no = new BigInteger(1, messageDigest);
	      String hashtext = no.toString(16);
	      while (hashtext.length() < 32) {
	        hashtext = "0" + hashtext;
	      }
	      return hashtext;
	    } catch (NoSuchAlgorithmException e) {
	      throw new RuntimeException(e);
	    }
	  }
}
