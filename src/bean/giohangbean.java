package bean;

public class giohangbean {
	private String mamohinh;
	private String tenmohinh;
	private long gia;
	private long soluong;
	private long thanhtien;
	private String anh;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String mamohinh, String tenmohinh, long gia, long soluong, String anh) {
		super();
		this.mamohinh = mamohinh;
		this.tenmohinh = tenmohinh;
		this.gia = gia;
		this.soluong = soluong;
		this.thanhtien = soluong*gia;
		this.anh = anh;
	}
	public String getMamohinh() {
		return mamohinh;
	}
	public void setMamohinh(String mamohinh) {
		this.mamohinh = mamohinh;
	}
	public String getTenmohinh() {
		return tenmohinh;
	}
	public void setTenmohinh(String tenmohinh) {
		this.tenmohinh = tenmohinh;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public long getThanhtien() {
		return soluong*gia;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	
	
}
