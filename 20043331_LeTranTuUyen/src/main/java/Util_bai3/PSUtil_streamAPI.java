package Util_bai3;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.xml.crypto.dsig.keyinfo.KeyName;

import entity_bai3.PS;
import entity_bai3.listPS;

public class PSUtil_streamAPI {
	
	public static List<PS> read(String file) {
		List<PS> list = new ArrayList<PS>();
		PS ps = null;
		file = "[\r\n"
				+ "  {\r\n"
				+ "    \"StateName\": \"Alabama\",\r\n"
				+ "    \"Abbreviation\": \"AL\",\r\n"
				+ "    \"Capital\": \"Montgomery\",\r\n"
				+ "    \"Statehood\": 1819,\r\n"
				+ "    \"ID\": 1\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"StateName\": \"Alaska\",\r\n"
				+ "    \"Abbreviation\": \"AK\",\r\n"
				+ "    \"Capital\": \"Juneau\",\r\n"
				+ "    \"Statehood\": 1959,\r\n"
				+ "    \"ID\": 2\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"StateName\": \"American Samoa\",\r\n"
				+ "    \"Abbreviation\": \"AS\",\r\n"
				+ "    \"Capital\": \"Pago Pago\",\r\n"
				+ "    \"Statehood\": 1899,\r\n"
				+ "    \"ID\": 3\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"StateName\": \"Arizona\",\r\n"
				+ "    \"Abbreviation\": \"AZ\",\r\n"
				+ "    \"Capital\": \"Phoenix\",\r\n"
				+ "    \"Statehood\": 1912,\r\n"
				+ "    \"ID\": 4\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"StateName\": \"Arkansas\",\r\n"
				+ "    \"Abbreviation\": \"AR\",\r\n"
				+ "    \"Capital\": \"Little Rock\",\r\n"
				+ "    \"Statehood\": 1836,\r\n"
				+ "    \"ID\": 5\r\n"
				+ "  }\r\n"
				+ "]";
		JsonParser parser = Json.createParser(new StringReader(file));
		String key = " ";
		while(parser.hasNext()) {
			Event event = parser.next();
			switch (event) {
			
			case START_OBJECT:
				
			case KEY_NAME:
				key = parser.getString();
				break;
		
			case END_ARRAY:
				break;
			case VALUE_STRING:
				String vs = parser.getString();
				if(key.equals("stateName"))
					ps.setStateName(vs);
				else if(key.equals("abbreviation"))
					ps.setAbbreviation(vs);
				else if(key.equals("capital"))
					ps.setCapital(vs);
				break;
			
			case VALUE_NUMBER:
				if(parser.isIntegralNumber()) {
					int va = parser.getInt();
					if(key.equals("stateHood")) 
						ps.setStateHood(va);
					else if(key.equals("id"))
						ps.setId(va);
				}
				
				break;
				
			case START_ARRAY:
				JsonArray jsonArray = parser.getArray();
				for (JsonValue jsonValue : jsonArray) {
					JsonObject o = jsonValue.asJsonObject();
					PS per = new PS(o.getString("StateName"),
							          o.getString("Abbreviation"),
							          o.getString("Capital"), 
							          o.getInt("Statehood"),
							          o.getInt("ID"));
					list.add(per);
					
				}
				break;
			
			}
			}
	
		return list;
	
	}
}
