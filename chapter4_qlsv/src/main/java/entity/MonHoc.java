package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class MonHoc {

	
	@Column(name ="hockygd")
	private int hocKiGD;
	@Id
	private String msmh;
	
	private int soTinChi;
	@Column(name ="tenmh")
	private String tenMh;
	
	
	@OneToMany(mappedBy = "monhoc")
	private List<BangDiem> dsbd;


	public MonHoc(int hocKiGD, String msmh, int soTinChi, String tenMh, List<BangDiem> dsbd) {
		super();
		this.hocKiGD = hocKiGD;
		this.msmh = msmh;
		this.soTinChi = soTinChi;
		this.tenMh = tenMh;
		this.dsbd = dsbd;
	}


	public MonHoc() {
		super();
	}


	public int getHocKiGD() {
		return hocKiGD;
	}


	public void setHocKiGD(int hocKiGD) {
		this.hocKiGD = hocKiGD;
	}


	public String getMsmh() {
		return msmh;
	}


	public void setMsmh(String msmh) {
		this.msmh = msmh;
	}


	public int getSoTinChi() {
		return soTinChi;
	}


	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}


	public String getTenMh() {
		return tenMh;
	}


	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}


	public List<BangDiem> getDsbd() {
		return dsbd;
	}


	public void setDsbd(List<BangDiem> dsbd) {
		this.dsbd = dsbd;
	}


	@Override
	public String toString() {
		return "MonHoc [hocKiGD=" + hocKiGD + ", msmh=" + msmh + ", soTinChi=" + soTinChi + ", tenMh=" + tenMh
				+ ", dsbd=" + dsbd + "]";
	}
	
	
	
}
