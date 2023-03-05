package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.mohinhbean;
import dao.mohinhdao;

public class mohinhbo {
	mohinhdao mhdao = new mohinhdao();
	
	public ArrayList<mohinhbean> GetDsMoHinh(int page) {
		return mhdao.getdsmohinh(page);
	}
	
	public ArrayList<mohinhbean> GetDsRandomMoHinh() {
		return mhdao.getdsrandommohinh();
	}
	
	public int GetTotalMoHinh() {
		return mhdao.totalmohinh();
	}
	
	public ArrayList<mohinhbean> GetDsMoHinh_Loai(String key, int page) {
		return mhdao.getdsloaimohinh(key, page);
	}
	
	public int GetTotalMoHinh_Loai(String key) {
		return mhdao.totalmohinh_ml(key);
	}
	
	public ArrayList<mohinhbean> GetDsMoHinh_Td(String key, int page) {
		return mhdao.getdstimkiemmohinh(key, page);
	}
	
	public int GetTotalMoHinh_Td(String key) {
		return mhdao.totalmohinh_td(key);
	}
	
	public mohinhbean GetCTMoHinh(String mamh) throws SQLException {
		return mhdao.getctmohinh(mamh);
	}
	
	public int KTDemMoHinh(String mamohinh) {
		return mhdao.ktdemmohinh(mamohinh);
	}
	
	public int KTDemMoHinh_CTHD(String mamohinh) {
		return mhdao.ktdemmohinh_chitiethd(mamohinh);
	}
	
	public int ThemMoHinh(String mamohinh, String tenmohinh, int soluong, int gia, String maloai, String anh,
			String nhasanxuat, String idreview) {
		return mhdao.themmohinh(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat, idreview);
	}
	public int XoaMoHinh(String mamohinh) {
		return mhdao.xoamohinh(mamohinh);
	}
	public int SuaMoHinh(String mamohinh, String tenmohinh, int soluong, int gia, String maloai, String anh,
			String nhasanxuat, String idreview) {
		return mhdao.suamohinh(mamohinh, tenmohinh, soluong, gia, maloai, anh, nhasanxuat, idreview);
	}
}
