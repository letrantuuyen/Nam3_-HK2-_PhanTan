package demo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;

import dao.StaffDao;
import entity.Phone;
import entity.Staff;

public class StaffDemo {
	public static void main(String[] args) {
		Gson gson = new Gson();
		Phone p = new Phone("null","123");
		Staff s = new Staff(2434l);
		Staff s1 = new Staff(32424, "sf", "null", null, "null", s);
		Staff staff = new Staff(9100, "Tu", "Uyen", p, "lttu", s);
		Staff staff1 = new Staff(9100, "Tu", "Uyen", p, "lttu", s);
		Staff staff2 = new Staff(9100, "Bac", "Van", p, "lttu", s);
		StaffDao staffDao = new StaffDao();
		System.out.println(	staffDao.addStaff(staff));
		
		List<Staff> staffs = new ArrayList<Staff>();
		staffs.add(staff);
		staffs.add(staff2);
		
	//	staffDao.update(9100, staff2);
		
	//	staffDao.getList();

}
}
