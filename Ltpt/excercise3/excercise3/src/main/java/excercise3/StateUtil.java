package excercise3;

import java.io.FileReader;
import java.util.ArrayList;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class StateUtil {
//	a.	Tìm kiếm đối tượng State theo abbreviation, trả về null nếu không tồn tại
//			public State findByAb(String abb)
	private static final String PATH = "data/states.json";
	
	public static State findByAb(String abb) {
		
		State state = null;
		JsonParser parser  = null;
		try {
			parser = Json.createParser(new FileReader(PATH));
			while(parser.hasNext()) {
				Event event = parser.next();
				if(event.equals(Event.START_OBJECT)) {
					JsonObject jo = parser.getObject();
					if(jo.getString("Abbreviation").equalsIgnoreCase(abb)) {
						state = new State(jo.getString("StateName"),
								jo.getString("Abbreviation"),
								jo.getString("Capital"),
								jo.getInt("Statehood"),
								jo.getInt("ID"));
						return state;
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			parser.close();
		}
		
		return state;
	}
	
//	b.	Tìm kiếm các đối tượng State có state-hood-year(ie. năm thành lập) trước một năm được cung cấp
//	public ArrayList<State>findByYear(int year)
	public static ArrayList<State> findByYear(int year) {
        ArrayList<State> states = new ArrayList<>();
        JsonParser parser = null;
        try {
            parser = Json.createParser(new FileReader(PATH));
            while (parser.hasNext()) {
                Event event = parser.next();
                if (event.equals(Event.START_OBJECT)) {
                	JsonObject jo = parser.getObject();
                    int statehood = jo.getInt("Statehood");
                    if (statehood < year) {
                        State state = new State(jo.getString("StateName"), 
                        		jo.getString("Abbreviation"),
                                jo.getString("Capital"), 
                                jo.getInt("Statehood"), 
                                jo.getInt("ID"));
                        states.add(state);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (parser != null) {
                parser.close();
            }
        }
        return states;
    }

}
