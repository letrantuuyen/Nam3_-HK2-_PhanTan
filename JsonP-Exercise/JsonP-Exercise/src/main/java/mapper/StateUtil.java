package mapper;

import java.io.FileReader;

import entity.State;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

//The Streaming API
public class StateUtil {
private static final String PATH = "data/states.json";

	//	+ findByAb(abb:String): State
	public State findByAb(String abb) {
		
		JsonParser parser = null;
		State state = null;
		
		try {
			parser = Json.createParser(new FileReader(PATH));
			
			while(parser.hasNext()) {
				Event event = parser.next();
				if(event.equals(Event.START_OBJECT)) {
					JsonObject jo = parser.getObject();
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
			parser.close();
		}
		
		return state;
		
	}
	
}
