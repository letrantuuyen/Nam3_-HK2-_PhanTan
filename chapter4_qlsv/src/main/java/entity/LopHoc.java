package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="Lophoc")
public class LopHoc {
	@Id
	private String msLop;
	@Column(name ="sisoDukien")
	private int siSoDuKien;
	@Column(name ="tenlop", columnDefinition = "nvarchar(250)")
	private String tenLop;
	
	@OneToMany(mappedBy = "lophoc")
	//relationship
	private List<SinhVien> dssv;
	
	@MapsId
	@OneToOne()
	@JoinColumn(name ="lophoc")
	private HoSoLopHoc hslh;
	
	public LopHoc() {
		super();
	}
	

	public LopHoc(String msLop, int siSoDuKien, String tenLop) {
		super();
		this.msLop = msLop;
		this.siSoDuKien = siSoDuKien;
		this.tenLop = tenLop;
	}
	public String getMsLop() {
		return msLop;
	}
	public void setMsLop(String msLop) {
		this.msLop = msLop;
	}
	public int getSiSoDuKien() {
		return siSoDuKien;
	}
	public void setSiSoDuKien(int siSoDuKien) {
		this.siSoDuKien = siSoDuKien;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	@Override
	public String toString() {
		return "LopHoc [msLop=" + msLop + ", siSoDuKien=" + siSoDuKien + ", tenLop=" + tenLop + "]";
	}
	
	
}
