package bo;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	public khachhangbean KTDangNhap(String tendn, String pass) {
		khachhangdao khdao = new khachhangdao();
		try {
			return khdao.ktdangnhap(tendn, pass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int DangKy(String hoten, String diachi, String sdt, String email, String tendn, String pass) {
		khachhangdao khdao = new khachhangdao();
		try {
			return khdao.dangKy(hoten, diachi, sdt, email, tendn, pass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int ThayDoiThongTin(String hoten, String diachi, String sdt, String email, String tendn, String pass, long makh ) {
		khachhangdao khdao = new khachhangdao();
		try {
			return khdao.thaydoi(hoten, diachi, sdt, email, tendn, pass, makh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String ConvertPassMD5(String pass) {
		String mk ="";
		khachhangdao khdao = new khachhangdao();
		mk = khdao.getMd5Hash(pass);
		return mk;
	}
}
