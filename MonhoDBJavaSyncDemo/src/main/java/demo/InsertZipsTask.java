package demo;

import java.util.List;

import dao.ZipDao;
import entity.Location;
import entity.Zip;

public class InsertZipsTask {
	public static void main(String[] args) {
		List<Zip> zips = List.of(
				new Zip("city abc1", "zip xyz1", new Location(101.5, 401.4), 1001, "state"),
				new Zip("city abc12", "zip xyz12", new Location(1012.5, 4012.4), 10012, "state")
				);
		
		ZipDao zipDao = new ZipDao();
		List<String> rs = zipDao.insertZips(zips);
		rs.forEach(x -> System.out.println(x));
	}
}
