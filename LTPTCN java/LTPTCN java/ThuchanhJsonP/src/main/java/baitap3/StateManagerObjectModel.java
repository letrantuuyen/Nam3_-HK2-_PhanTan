package baitap3;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class StateManagerObjectModel {
	private String fileName;

	public StateManagerObjectModel(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	
//	+ findByAb(abb:String): State
	public State findByAb(String abb) throws FileNotFoundException {
		
		State state = null;
		
		JsonReader reader = Json.createReader(new FileReader(fileName));
		
		JsonArray ja = reader.readArray();
		for(JsonValue jv : ja) {
			JsonObject jo = (JsonObject) jv;
			if(jo.getString("Abbreviation").equalsIgnoreCase(abb)) {
				state = new State(jo.getString("StateName"), 
						jo.getString("Abbreviation"),
						jo.getString("Capital"), 
						jo.getInt("Statehood"), 
						jo.getInt("ID"));
				break;
			}
		}
		
		
		return state;
	}
}
