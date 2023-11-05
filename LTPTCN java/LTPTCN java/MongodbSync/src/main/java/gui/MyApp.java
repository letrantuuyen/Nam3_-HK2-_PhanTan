package gui;

import java.util.Scanner;

import org.bson.types.ObjectId;

import bus.ZipService;
import bus.ZipServiceImpl;
import entity.Location;
import entity.Zip;

public class MyApp {
	public static void main(String[] args) {
		Zip zip = new Zip(new ObjectId(), "ba", "xyz", new Location(100, 1000), 200, "AS");
		
		ZipService service = new ZipServiceImpl();
		
		service.getPopByCity("FISHERS ISLAND").forEach(sts->System.out.println(sts));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Chon cau");
		int so  = scanner.nextInt();
		switch (so) {
		case 1: {
			service.listDocument().forEach(sts -> System.out.println(sts));
			break;
		}
		case 2:{
			boolean result = service.addZip(zip);
			System.out.println(result);
		}
		case 3:{
			Zip zipNew = new Zip(new ObjectId("5c8eccc1caa187d17ca69999"), 
					"sdf", "sdf", new Location(100, 120), 130, "AL");
			boolean updateZip = service.updateZip(zipNew );
		}
		case 4:{
			service.getZipsByCity("PALMER").forEach(z -> System.out.println(z));

		}
		case 5:{
			int pop =100000;
			service.getZipsByPop(pop).forEach(sts->System.out.println(sts));
			break;
		}
		case 6:{
			service.getPopByCity("FISHERS ISLAND").forEach(sts->System.out.println(sts));
		}
		case 7:{
			service.getCityByPop().forEach(sts->System.out.println(sts));
			break;
		}
		case 8:{
			service.getCityByStateAndPop("MA", 500).forEach(sts->System.out.println(sts));
			break;
		}
		case 9:{
			service.getStates().forEach(sts -> System.out.println(sts));
			break;
		}
		case 11:{
			service.getAvgByState().forEach(sts->System.out.println(sts));
			break;
		}
		case 12:{
			service.getDocByStateAndCity("CT", "WATERBURY").forEach(sts->System.out.println(sts));
			break;
		}
		case 13:{
			service.getCountCityByState().forEach(sts->System.out.println(sts));
			break;
		}
		case 14:{
			service.getCountCityByStateSort().forEach(sts->System.out.println(sts));
			break;	
		}
		case 15:{
			service.getStateBy1000000(10000000).forEach(sts->System.out.println(sts));
			break;
		}
		default:
			break;
		}
		
	}
}

