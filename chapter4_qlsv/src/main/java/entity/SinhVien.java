package entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name ="Sinhvien")
public class SinhVien {
	@Id
	@Column(columnDefinition = "nvarchar(255)")
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng id
	private String mssv;
	
	private LocalDate ngaySinh;
	@Column( columnDefinition = "nvarchar(255)", nullable = false)
	private String ten;
	
	@Column(name = "hosv", columnDefinition = "nvarchar(255)")
	private String ho;
	@Column(name = "gioitinh",columnDefinition = "nvarchar(255)")
	private String gioiTinh;
	
	@Embedded
	private DiaChi diachi;

	//điện thoại là thuộc tính đa trị nên tạo ra bảng mới 
	//set là lưu trữ phần tử trùng
	@ElementCollection
	@CollectionTable(name= "Dienthoai",
			joinColumns = @JoinColumn (name ="mssv"))
	@Column(name = "dienthoai", nullable = false)
	private Set<String> dsDienThoai;
	
	//relationship
	@ManyToOne()
	@JoinColumn(name ="msLop")
	private LopHoc lophoc;
	
	@OneToMany(mappedBy = "sinhvien")
	private List<BangDiem> dsbd;

	public SinhVien() {
		super();
	}

	public SinhVien(String mssv, LocalDate ngaySinh, String ten, String ho, String gioiTinh) {
		super();
		this.mssv = mssv;
		this.ngaySinh = ngaySinh;
		this.ten = ten;
		this.ho = ho;
		this.gioiTinh = gioiTinh;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public DiaChi getDiachi() {
		return diachi;
	}

	public void setDiachi(DiaChi diachi) {
		this.diachi = diachi;
	}

	public Set<String> getDsDienThoai() {
		return dsDienThoai;
	}

	public void setDsDienThoai(Set<String> dsDienThoai) {
		this.dsDienThoai = dsDienThoai;
	}

	@Override
	public String toString() {
		return "SinhVien [mssv=" + mssv + ", ngaySinh=" + ngaySinh + ", ten=" + ten + ", ho=" + ho + ", gioiTinh="
				+ gioiTinh + ", diachi=" + diachi + ", dsDienThoai=" + dsDienThoai + "]";
	}
	

}
