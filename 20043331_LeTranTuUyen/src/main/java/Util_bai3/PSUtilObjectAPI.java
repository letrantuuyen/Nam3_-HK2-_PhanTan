package Util_bai3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

import entity_bai3.PS;

public class PSUtilObjectAPI {
	
	private  static final  String PATH = "data/ps.json"; 
	
	public static List<PS> ObjectAPI() throws IOException {
		PS per = new  PS();
		List<PS> list = new ArrayList<PS>();
		
		JsonReader reader = Json.createReader(new FileReader(PATH));
		JsonArray ar = reader.readArray();
		
		for (JsonValue jsonValue : ar) {
			JsonObject ob = (JsonObject) jsonValue;
			PS ps = new PS(ob.getString("StateName"), ob.getString("Abbreviation"), ob.getString("Capital"), ob.getInt("Statehood"), ob.getInt("ID"));
			list.add(ps);
			
		}
		
		
		return list;
	}
}