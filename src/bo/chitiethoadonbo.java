package bo;

import dao.chitiethoadondao;

public class chitiethoadonbo {
	public int ThemCTHD(String maMoHinh, int soLuongMua, Long maHoaDon, Boolean damua) {
		chitiethoadondao cthddao = new chitiethoadondao();
		try {
			return cthddao.themcthd(maMoHinh, soLuongMua, maHoaDon, damua);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}
