package Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import entity.Address;
import entity.Restaurant;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonWriter;
import jakarta.json.stream.JsonGenerator;

public class ObjectAPI {
	
	public static void writeObjectAPI(Restaurant rs,String file) throws IOException {
		
		JsonObjectBuilder jsonB = null;
		JsonArrayBuilder jsonA = null;
		JsonWriter writer = null;
		Address addr = rs.getAddress();
		
		jsonB = Json.createObjectBuilder();
		jsonA = Json.createArrayBuilder();
		writer = Json.createWriter(new FileWriter(file));
		
				
		jsonB.add("restaurant_id", rs.getRestaurant_id())
			 .add("is_closed", rs.isIs_closed())
			 .add("name", rs.getName())
			 .build();
			 
			 
			 
		
		
		
	}

}
