package App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import dao.SinhVienDAO;
import entity.SinhVien;

public class Demo {
	public static void main(String[] args) {
		MongoClient client = MongoClients.create();
		SinhVienDAO sinhviendao = new SinhVienDAO(client);
		
		SinhVien sv = new SinhVien("103", "Le", "Uyen", 21);
		SinhVien sv1 = new SinhVien("234", "Phu", "Van", 21);
		SinhVien sv2 = new SinhVien("345", "Chang", "Vi", 22);
		SinhVien sv3 = new SinhVien("456", "Tham", "Thanh", 23);
		SinhVien sv4 = new SinhVien("987", "Tran", "Long", 22);
		//sinhviendao.add(sv);
		
		
		List<SinhVien> ds =  Arrays.asList(sv,sv1,sv2,sv3,sv4);
		
		sinhviendao.themDSSinhvien(ds);
		
	//	sinhviendao.getDSSinhVien(5, 2);
		
		sinhviendao.capNhatTuoiSV("123", 20);
		sinhviendao.xoaSinhVien("123");

		
	}

}
