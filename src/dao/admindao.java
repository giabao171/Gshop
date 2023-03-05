package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.adminbean;

public class admindao {
	
	public int dangKy(String tdn, String pass, boolean quyen)throws SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql="insert into admin(tendn, pass, quyen) values(?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		//Truyen cau lenh vao tham so
		cmd.setString(1,tdn);
		cmd.setString(2,pass);
		cmd.setBoolean(3,quyen);
		
		return cmd.executeUpdate();
	}
	
	public adminbean ktdangnhap(String tenDN, String Pass) throws SQLException {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql="select * from admin where tendn = ? and pass = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		//Truyen cau lenh vao tham so
		cmd.setString(1,tenDN);
		cmd.setString(2,Pass);
		        
		//Thuc hien
		ResultSet rs = cmd.executeQuery();
		adminbean adbean = null;
		while (rs.next()){
			
			String tdn = rs.getString("tendn");
			String pass = rs.getString("pass");
			boolean quyen = rs.getBoolean("quyen");
			adbean = new adminbean(tenDN, pass, quyen);
	    }
		rs.close();
		kn.cn.close();
		return  adbean;
		
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
