package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class BangDiem {
	
	private float diemThi;
	
	@Id
	@Column(name ="lanthi")
	private int lanThi;
	
	@Id
	@ManyToOne
	@JoinColumn(name ="mssv")
	private SinhVien sinhvien;
	
	@Id
	@ManyToOne()
	@JoinColumn(name ="msmh")
	private MonHoc monhoc;

	public BangDiem() {
		super();
	}

	public BangDiem(float diemThi, int lanThi) {
		super();
		this.diemThi = diemThi;
		this.lanThi = lanThi;
	}
	
	

}
