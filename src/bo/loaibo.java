package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {

	loaidao ldao = new loaidao();
	public ArrayList<loaibean> GetDsLoai() {
		return ldao.getdsloai();
	}
	
	public loaibean GetLoaiItem(String ml) throws SQLException {
		return ldao.getloaiitem(ml);
	}
	
	
	public int themloai(String ml, String tl) throws SQLException {
		int kq = ldao.themloai(ml, tl);
		return kq;
	}
	
	public int xoaloai(String ml) throws SQLException {
		int kq = ldao.xoaloai(ml);
		return kq;
	}
	
	public int sualoai(String mlmoi, String tlmoi, String mlcu) throws SQLException {
		int kq = ldao.sualoai(mlmoi, tlmoi, mlcu);
		return kq;
	}
	
	public int CountLoai_MoHinh(String ml) {
		return ldao.ktdemloai(ml);
	}
	
	public int CountLoai_Loai(String ml) {
		return ldao.ktdemloai_loai(ml);
	}
}
