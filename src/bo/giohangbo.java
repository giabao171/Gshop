package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();

	public void Them(String mamh, String tmh, long gia, long soluong, String anh) {
		for (giohangbean h : ds)
			if (h.getMamohinh().equals(mamh)) {
				h.setSoluong(h.getSoluong() + soluong);
				return;
			}
		ds.add(new giohangbean(mamh, tmh, gia, soluong, anh));
	}
	
	public long TongTien() {
		  long s=0;
		  for(giohangbean h: ds)
			  s=s+h.getThanhtien();
		  return s;
	  }
	
	public void SolLuong(String mmh, long sl) {
		  for(giohangbean h: ds)
			  if(h.getMamohinh().equals(mmh)) {
				  h.setSoluong(sl);
				  return;
			  }
	  }
	
	public void XoaMH(String mmh) {
		  for(giohangbean h: ds)
			  if(h.getMamohinh().equals(mmh)) {
				  ds.remove(h);
				  return;
			  }
	  }
	
	public void XoaAll() {
		  ds.clear();
	  }
}
