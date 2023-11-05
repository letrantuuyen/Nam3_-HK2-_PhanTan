package baitap3;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class StateManagerStreaming {
	private String fileName;

	public StateManagerStreaming(String fileName) {
		super();
		this.fileName = fileName;
	}


	//	+ findByAb(abb:String): State
	public State findByAb(String abb) throws FileNotFoundException {

		State state = null;

		JsonParser parser = Json.createParser(new FileReader(fileName));
		while(parser.hasNext()) {
			Event event = parser.next();

			switch (event) {
			case START_OBJECT:
				if(state != null)
					break;
				JsonObject jo = parser.getObject();
//				System.out.println(jo);
				if(jo.getString("Abbreviation").equalsIgnoreCase(abb)) {
					state = new State(jo.getString("StateName"), 
							jo.getString("Abbreviation"),
							jo.getString("Capital"), 
							jo.getInt("Statehood"), 
							jo.getInt("ID"));
				}
				break;

			default:
				break;
			}

		}


		return state;
	}
}
