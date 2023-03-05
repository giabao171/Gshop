package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class chitiethoadondao {
	public int themcthd(String maMoHinh, int soLuongMua, Long maHoaDon, Boolean damua) throws SQLException {
		KetNoi kn =new KetNoi();
		kn.KetNoi();
		String sql="insert into chitiethoadon(mamohinh, soluongmua, mahoadon, damua) values (?, ?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		//Truyen cau lenh vao tham so
		
		cmd.setString(1,maMoHinh);
		cmd.setInt(2,soLuongMua);
		cmd.setLong(3,maHoaDon);
		cmd.setBoolean(4,damua);
				
		return cmd.executeUpdate();
	}
}
