package demo;

import dao.ZipDao;
import entity.Location;
import entity.Zip;

public class InsertZipTask {
	public static void main(String[] args) {
		ZipDao zipDao = new ZipDao();
		Zip zip = new Zip("city abc", "zip xyz", new Location(10.5, 40.4), 100, "state");
		
		String id = zipDao.insertZip(zip);
		System.out.println(id);
	}
}
