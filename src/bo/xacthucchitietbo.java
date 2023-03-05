package bo;

import java.util.ArrayList;

import bean.xacthucchitietbean;
import dao.xacthucchitietdao;

public class xacthucchitietbo {
	public ArrayList<xacthucchitietbean> GetCTHoaDon(long mahd) {
		xacthucchitietdao xtcthddao = new xacthucchitietdao();
		return xtcthddao.getcthd(mahd);
	}
	
	public int  CountDonHangChuaMua(long mahd) {
		xacthucchitietdao xtcthddao = new xacthucchitietdao();
		return xtcthddao.countchuamua(mahd);
	}
	
	public long SetDaMua(long macthd) {
		xacthucchitietdao xtcthddao = new xacthucchitietdao();
		return xtcthddao.setdamua(macthd);
	}
}
