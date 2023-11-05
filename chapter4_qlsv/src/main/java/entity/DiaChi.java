package entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//nhúng
@Embeddable
public class DiaChi {
	
	private String duong;
	
	private String phuong;
	
	private String soNha;
	
	private String thanhPho;
	
	private String quan;

	public DiaChi() {
		super();
	}

	public DiaChi(String duong, String phuong, String soNha, String thanhPho, String quan) {
		super();
		this.duong = duong;
		this.phuong = phuong;
		this.soNha = soNha;
		this.thanhPho = thanhPho;
		this.quan = quan;
	}

	public String getDuong() {
		return duong;
	}

	public void setDuong(String duong) {
		this.duong = duong;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}
	
	
	

}
