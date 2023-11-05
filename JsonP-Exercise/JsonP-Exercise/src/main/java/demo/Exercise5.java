package demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import entity.Phone;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;



public class Exercise5 {
	public static void main(String[] args) {
//		Viết phương thức tạo một đối tượng JSONObject từ một Map<String,Object>
		
		Map<String, List<Phone>> dic = new TreeMap<>();
		
		dic.put("An DHKTPM16ETT", List.of(new Phone("Mobie", "0903.888999")));
		dic.put("Lan DHKTPM16ETT", List.of(new Phone("Vina", "0914.888999")));
		dic.put("Binh DHKTPM16ETT", List.of(new Phone("Mobie", "0903666999"),new Phone("Vietel", "0928.888999")));
		
		dic
		.entrySet()
		.forEach(entry -> {
			System.out.println("Name: " + entry.getKey());
			System.out.println("Phones: " + entry.getValue());
			System.out.println("===");
		});
		
		// The Object Model API
		
		JsonObjectBuilder oBuilder = Json.createObjectBuilder();
		
		Iterator<Entry<String, List<Phone>>> its = dic.entrySet().iterator();
		while(its.hasNext()) {
			Entry<String, List<Phone>> it = its.next();
			
			List<Phone> phones = it.getValue();
			JsonArray ja = toJson(phones);
			
			oBuilder.add(it.getKey(), ja);
		}
		
		 JsonObject jo = oBuilder.build();
		 System.out.println(jo);
	}

	private static JsonArray toJson(List<Phone> phones) {
		
		JsonArrayBuilder aBuilder = Json.createArrayBuilder();
		for(Phone ph: phones) {
			JsonObject jo = toJson(ph);
			aBuilder.add(jo);
		}
		return aBuilder.build();
	}

	private static JsonObject toJson(Phone ph) {
		JsonObjectBuilder oBuilder = Json.createObjectBuilder();
		
		return oBuilder.add("type", ph.getType())
				.add("number", ph.getNumber())
				.build();
	}
}


