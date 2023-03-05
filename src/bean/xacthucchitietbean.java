package bean;

public class xacthucchitietbean {
	private long machitietHD;
	private long mahoadon;
	private String hoten;
	private long soluongmua;
	private String tenmohinh;
	private String anh;
	private long gia;
	private long thanhtien;
	private boolean damua;
	public xacthucchitietbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xacthucchitietbean(long machitietHD, long mahoadon, String hoten, long soluongmua, String tenmohinh,
			String anh, long gia, long thanhtien, boolean damua) {
		super();
		this.machitietHD = machitietHD;
		this.mahoadon = mahoadon;
		this.hoten = hoten;
		this.soluongmua = soluongmua;
		this.tenmohinh = tenmohinh;
		this.anh = anh;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}
	public long getMachitietHD() {
		return machitietHD;
	}
	public void setMachitietHD(long machitietHD) {
		this.machitietHD = machitietHD;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public String getTenmohinh() {
		return tenmohinh;
	}
	public void setTenmohinh(String tenmohinh) {
		this.tenmohinh = tenmohinh;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
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
	
	
}
