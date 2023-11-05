package entity;

public class SinhVien {
	
	private String msvv;
	private String ho;
	private String ten;
	private int tuoi;
	public SinhVien(String msvv, String ho, String ten, int tuoi) {
		super();
		this.msvv = msvv;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
	}
	public SinhVien() {
		super();
	}
	public String getMsvv() {
		return msvv;
	}
	public void setMsvv(String msvv) {
		this.msvv = msvv;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	@Override
	public String toString() {
		return "SinhVien [msvv=" + msvv + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + "]";
	}
	

}
