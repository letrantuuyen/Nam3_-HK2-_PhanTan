import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class Demo5 {

	public static void main(String[] args) {
		String json = "{\"id\":\"20043331\",\"fullName\":\"Le Tran Tu Uyen\",\"age\":20,\"active\":true}";
		Student student = null;
		
		JsonParser parser = Json.createParser(new StringReader(json));
		
		String keyName = "";
		
		while(parser.hasNext()) {
			Event event = parser.next();
			switch(event) {
			case START_OBJECT:
				student = new Student();
				break;
			case KEY_NAME:
				keyName = parser.getString();
				break;
			case VALUE_STRING:
				String value = parser.getString();
				if(keyName.equals("id"))
					student.setId(value);
				else
					student.setFullName(value);
				break;
			case VALUE_NUMBER:
				int valueNumber = parser.getInt();
				student.setAge(valueNumber);
				break;
			case VALUE_TRUE:
				student.setActive(true);
				break;
			case VALUE_FALSE:
				student.setActive(false);
				break;
			case END_OBJECT:
				
				System.out.println(student);
				break;
			default:
				break;
			}
		}
	}
}
