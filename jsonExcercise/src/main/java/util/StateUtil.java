package util;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import entity.State;

public class StateUtil {

	private static final String PATH = "data/state.json";
	public static State findAB(String abb) {
		State state = null;
		JsonParser jsonparser = null;
		
		try {
			jsonparser = Json.createParser(new FileReader(PATH));
			while(jsonparser.hasNext()) {
				Event event = jsonparser.next();
				if(event.equals(Event.START_OBJECT)) {
					JsonObject jo = jsonparser.getObject();
					if(jo.getString("abbreviation").equalsIgnoreCase(abb)) {
						state = new State(jo.getString("stateName"),jo.getString("abbreviation"),jo.getString("capital"),jo.getInt("stateHood"),jo.getInt("ID"));
						
					}
				}
			}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		jsonparser.close();
	}
		return state;
	}
	
}
