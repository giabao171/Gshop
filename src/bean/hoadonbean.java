package bean;

import java.util.Date;

public class hoadonbean {
	private long mahoadon;
	private long makh;
	private Date ngaymua;
	private Boolean damua;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(long mahoadon, long makh, Date ngaymua, Boolean damua) {
		super();
		this.mahoadon = mahoadon;
		this.makh = makh;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public Boolean getDamua() {
		return damua;
	}
	public void setDamua(Boolean damua) {
		this.damua = damua;
	}
	
	
}
