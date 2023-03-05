package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.hoadonbean;
import dao.hoadondao;

public class hoadonbo {
	public int ThemHD(long makh, Date ngaymua, Boolean damua) {
		hoadondao hddao = new hoadondao();
		try {
			return hddao.themhoadon(makh, ngaymua, damua);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public long MaHoaDon() {
		hoadondao hddao = new hoadondao();
		try {
			return hddao.getmhd_moinhat();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public long SetHDDaMua(long mhd) {
		try {
			hoadondao hddao = new hoadondao();
			return hddao.sethd_damua(mhd);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public ArrayList<hoadonbean> GetHDDaMua() {
		try {
			hoadondao hddao = new hoadondao();
			ArrayList<hoadonbean> ds = hddao.gethd_damua();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public ArrayList<hoadonbean> GetHDChuaMua() {
		try {
			hoadondao hddao = new hoadondao();
			ArrayList<hoadonbean> ds = hddao.gethd_chuamua();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
