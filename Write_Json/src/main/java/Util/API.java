package Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import entity.Address;

import entity.Grades;
import entity.Restaurant;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class API {

	public static void writeData(Restaurant rs, String file) throws FileNotFoundException {
		Address ad = rs.getAddress();
		List<Grades> grads = new ArrayList();
		FileReader reader = new FileReader(file);
		JsonGenerator gen = Json.createGenerator(new FileOutputStream("data/rs.json"));
		gen.writeStartObject()
		.write("restaurant_id",rs.getRestaurant_id())
		.write("is_closed",rs.isIs_closed())
		.write("name",rs.getName());
		gen.writeStartObject("address")
		.write("building",ad.getBuilding())
		.writeStartArray("coord");
			for (Float fl : ad.getCoord()) 
				gen.write(fl.toString())
				.write(fl.toString());
			gen.writeEnd()
			
		.write("street", ad.getStreet())
		.write("zipcode",ad.getZipcode())
		.writeEnd()
		.write("borough",rs.getBorough())
		.write("cuisine",rs.getCuisine())
		.writeStartArray("grades");
			for (Grades grades : rs.getGrades()) 
					gen.writeStartObject()
					.writeStartObject("date")
						.write("year",grades.getDate().getDay())
						.write("month",grades.getDate().getMonth())
						.write("day",grades.getDate().getDay())
						.writeEnd()
						.write("grade",grades.getGrade())
						.write("score",grades.getScore())
					.writeEnd();
			gen.writeEnd()
			.writeEnd().close();
						
					
		
		
		
		
		
	}
}
