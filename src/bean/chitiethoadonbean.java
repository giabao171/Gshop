package bean;

public class chitiethoadonbean {
	private long machitietHD;
	private String mamohinh;
	private int soluongmua;
	private long mahoadon;
	private Boolean damua;
	public chitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitiethoadonbean(long machitietHD, String mamohinh, int soluongmua, long mahoadon, Boolean damua) {
		super();
		this.machitietHD = machitietHD;
		this.mamohinh = mamohinh;
		this.soluongmua = soluongmua;
		this.mahoadon = mahoadon;
		this.damua = damua;
	}
	public long getMachitietHD() {
		return machitietHD;
	}
	public void setMachitietHD(long machitietHD) {
		this.machitietHD = machitietHD;
	}
	public String getMamohinh() {
		return mamohinh;
	}
	public void setMamohinh(String mamohinh) {
		this.mamohinh = mamohinh;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public Boolean getDamua() {
		return damua;
	}
	public void setDamua(Boolean damua) {
		this.damua = damua;
	}
	
	
}
