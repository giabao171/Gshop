package bo;

import bean.adminbean;
import dao.admindao;

public class adminbo {
	public adminbean KTDangNhap(String tendn, String pass) {
		admindao addao = new admindao();
		try {
			return addao.ktdangnhap(tendn, pass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int DangKy(String tdn, String pass, boolean quyen) {
		admindao addao = new admindao();
		try {
			return addao.dangKy(tdn, pass, quyen);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String ConvertPassMD5(String pass) {
		String mk ="";
		admindao addao = new admindao();
		mk = addao.getMd5Hash(pass);
		return mk;
	}
}
