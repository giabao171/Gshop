package bean;

import java.util.Date;

public class lichsumuahangbean {
	private long mahoadon;
	private String tenmohinh;
	private Date ngaymua;
	private int soluongmua;
	private long gia;
	private long thanhtien;
	private boolean damua;
	private String anh;
	private String mamohinh;
	public lichsumuahangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsumuahangbean(long mahoadon, String tenmohinh, Date ngaymua, int soluongmua, long gia, long thanhtien,
			boolean damua, String anh, String mamohinh) {
		super();
		this.mahoadon = mahoadon;
		this.tenmohinh = tenmohinh;
		this.ngaymua = ngaymua;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.damua = damua;
		this.anh = anh;
		this.mamohinh = mamohinh;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getTenmohinh() {
		return tenmohinh;
	}
	public void setTenmohinh(String tenmohinh) {
		this.tenmohinh = tenmohinh;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMamohinh() {
		return mamohinh;
	}
	public void setMamohinh(String mamohinh) {
		this.mamohinh = mamohinh;
	}
	
}
