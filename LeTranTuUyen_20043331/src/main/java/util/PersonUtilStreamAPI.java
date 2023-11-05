package util;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import entity.Profile;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class PersonUtilStreamAPI {
	
	public static Profile readFile(String file) {
		String json  = "[\r\n"
				+ " {\r\n"
				+ " \"StateName\": \"Alabama\",\r\n"
				+ " \"Abbreviation\": \"AL\",\r\n"
				+ " \"Capital\": \"Montgomery\",\r\n"
				+ " \"Statehood\": 1819,\r\n"
				+ " \"ID\": 1\r\n"
				+ " },\r\n"
				+ " {\r\n"
				+ " \"StateName\": \"Alaska\",\r\n"
				+ " \"Abbreviation\": \"AK\",\r\n"
				+ " \"Capital\": \"Juneau\",\r\n"
				+ " \"Statehood\": 1959,\r\n"
				+ " \"ID\": 2 \r\n"
				+ " }]";
		Profile pr = null;
		String key = "";
		try {
			
			JsonParser parser = Json.createParser(new FileReader("data/profile.json"));
			Event event = parser.next();
			while(parser.hasNext()) {
			switch (event) {
			case START_OBJECT : {
				pr = new Profile();
				JsonValue f = parser.getValue();
				JsonObject ob = parser.getObject();
				
				break;
			}
			case KEY_NAME:
				/*
				 key = parser.getString();
				break;
			case START_ARRAY:
				JsonArray j = parser.getArray();
				List<String> a = new ArrayList();
				for (JsonValue jsonValue : j) {
					a.add(jsonValue.toString());
				}
				*/
				break;
			case VALUE_STRING :
				String value = parser.getString();
				if(key.equals("stateName"))
					pr.setStateName(value);
				else if(key.equals("abbreviation"))
					pr.setAbbreviation(value);
				else if(key.equals("capital"))
					pr.setCapital(value);
				break;
			case VALUE_NUMBER:
				int va = parser.getInt();
				if(key.equals("stateHood"))
					pr.setId(va);
				else if(key.equals("id"))
					pr.setId(va);
				break;
			
			}
		}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
		return pr;
	}

}
