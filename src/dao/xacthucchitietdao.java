package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.xacthucchitietbean;

public class xacthucchitietdao {
	public ArrayList<xacthucchitietbean> getcthd(long mahd){
    	try {
    		ArrayList<xacthucchitietbean> ds= new ArrayList<xacthucchitietbean>();
			KetNoi kn= new KetNoi();
			kn.KetNoi();
			String sql="select * from VXTCT where mahoadon = ?";
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahd);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				  long MaChiTietHD=rs.getLong("machitietHD");
				  long MaHoaDon=rs.getLong("mahoadon");
				  String hoten=rs.getString("hoten");
				  long SoLuongMua=rs.getLong("soluongmua");
				  String tenmh=rs.getString("tenmohinh");
				  String anh=rs.getString("anh");
				  long gia=rs.getLong("gia");
				  long ThanhTien=rs.getLong("thanhtien");
				  boolean damua=rs.getBoolean("damua");
				  ds.add(new xacthucchitietbean(MaChiTietHD, MaHoaDon, hoten, SoLuongMua, tenmh, anh, gia, ThanhTien, damua));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	public int countchuamua( long mahd)  {
		try {
			//B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			//b2: lay du lieu ve
			String  sql ="select count(damua) as sl from VXTCT where MaHoaDon = ? and damua = 0";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahd);
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
		}
		return 0;
	}
	
	public long setdamua( long mact) {
		try {
			KetNoi kn= new KetNoi();
			kn.KetNoi();
			String sql="update chitiethoadon set damua = 'true' where machitietHD = ?";
	        PreparedStatement cmd= kn.cn.prepareStatement(sql);        
	        cmd.setLong(1, mact);
	        
	        return cmd.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}

