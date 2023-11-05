package app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Util.API;
import entity.Address;
import entity.Date;
import entity.Grades;
import entity.Restaurant;

public class demo {

	public static void main(String[] args) throws FileNotFoundException {
		List<Float> coord = new ArrayList<Float>();
		
		coord.add((float) -73.871194);
		coord.add((float) 40.6730256);
		
		Address adr = new Address(1269, coord, "sutter avennue", 22250);
		
		List<Grades> grs = new ArrayList<Grades>();
		grs.add(new Grades(new Date(2014, 9, 16), "8", 21));
		grs.add(new Grades(new Date(2013, 8, 28), "A", 7));
		
		
		
		Restaurant r = new Restaurant("40358429", false, "may may kitchen", adr, "brooklyn", "chinese", grs);
		
		API.writeData(r, "data/rs.json");
		
	}
}
