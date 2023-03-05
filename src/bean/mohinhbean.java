package bean;

public class mohinhbean {
	private String mamohinh;
	private String tenmohinh;
	private int soluong;
	private int gia;
	private String maloai;
	private String anh;
	private String nhasanxuat;
	private String idreview;
	public mohinhbean(String mamohinh, String tenmohinh, int soluong, int gia, String maloai, String anh,
			String nhasanxuat, String idreview) {
		super();
		this.mamohinh = mamohinh;
		this.tenmohinh = tenmohinh;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.anh = anh;
		this.nhasanxuat = nhasanxuat;
		this.idreview = idreview;
	}
	public mohinhbean() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getNhasanxuat() {
		return nhasanxuat;
	}
	public void setNhasanxuat(String nhasanxuat) {
		this.nhasanxuat = nhasanxuat;
	}
	public String getIdreview() {
		return idreview;
	}
	public void setIdreview(String idreview) {
		this.idreview = idreview;
	}
	
}
