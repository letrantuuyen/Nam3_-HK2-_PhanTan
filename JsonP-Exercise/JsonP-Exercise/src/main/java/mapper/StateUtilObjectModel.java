package mapper;

import java.io.FileReader;

import entity.State;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

public class StateUtilObjectModel {
private static final String PATH = "data/states.json";

	//	+ findByAb(abb:String): State
	public State findByAb(String abb) {
		
		State state = null;
		
		JsonReader reader = null;
		
		try {
			reader = Json.createReader(new FileReader(PATH));
			
			JsonArray ja = reader.readArray();
			
			for(JsonValue jv : ja) {
				if(jv instanceof JsonObject) {
					JsonObject jo = jv.asJsonObject();
					System.out.println(jo);
					if(jo.getString("Abbreviation").equalsIgnoreCase(abb)) {
						state = new State();
						state.setAbbreviation(jo.getString("Abbreviation"));
						state.setStateName(jo.getString("StateName"));
						state.setCapital(jo.getString("Capital"));
						state.setId(jo.getInt("ID"));
						state.setStatehood(jo.getInt("Statehood"));
						
						return state;
					}
				}
					
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			reader.close();
		}
		
		return state;
	}
}
