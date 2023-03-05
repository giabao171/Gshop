package bo;

import java.util.ArrayList;

import bean.lichsumuahangbean;
import dao.lichsumuahangdao;

public class lichsumuahangbo {
	public ArrayList<lichsumuahangbean> GetLSMH(long MaKh) {
		lichsumuahangdao lsmhdao = new lichsumuahangdao();
		try {
			return lsmhdao.getlsmh(MaKh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
