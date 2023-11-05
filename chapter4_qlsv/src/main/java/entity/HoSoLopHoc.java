package entity;

import java.util.Date;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class HoSoLopHoc {

	@Id
	private String mshs;
	@Column(columnDefinition = "datetime")
	private Date ngayLap;
	
	@Column(columnDefinition = "text")
	private String ghiChu;
	
	
	@OneToOne()
	@PrimaryKeyJoinColumn
	private LopHoc lophoc;

	public HoSoLopHoc(Date ngayLap, String ghiChu, LopHoc lophoc) {
		super();
		this.ngayLap = ngayLap;
		this.ghiChu = ghiChu;
		this.lophoc = lophoc;
	}

	public HoSoLopHoc() {
		super();
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public LopHoc getLophoc() {
		return lophoc;
	}

	public void setLophoc(LopHoc lophoc) {
		this.lophoc = lophoc;
	}

	@Override
	public String toString() {
		return "HoSoLopHoc [ngayLap=" + ngayLap + ", ghiChu=" + ghiChu + ", lophoc=" + lophoc + "]";
	}


	
	
}
