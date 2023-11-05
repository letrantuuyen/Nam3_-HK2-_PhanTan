package Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import entity.Address;
import entity.Date;
import entity.Person;
import entity.Phone;
import entity.Test;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import netscape.javascript.JSObject;

public class readObjectAPI {
	

	public static List<Person> ObjectAPI(String file) throws FileNotFoundException {
		
		List<Person> list = new ArrayList<Person>();
		Person per = new Person();
		List<Test> tests = new ArrayList<Test>();
		JsonReader reader = Json.createReader(new FileReader("data/benhnhan.json"));
		JsonArray jsonA = reader.readArray();
	
		//System.out.println(jsonA);
		for (JsonValue jsonValue : jsonA) {
				JsonObject ob=  jsonValue.asJsonObject();
				per.setId(ob.getString("_id"));
				per.setFirst_name(ob.getString("first_name"));
				per.setLast_name(ob.getString("last name"));
				per.setBlood_type(ob.getString("blood_type"));
				per.setGender(ob.getString("gender"));
				per.setYear_of_birth(ob.getInt("year of birth"));
				
				
				/*
			//	JsonObject jsonT = reader.readObject();
		    	JsonArray jsonArT = jsonA.asJsonArray();
		    	for (JsonValue jsonValue2 : jsonArT) {
					if(jsonValue2 instanceof JSObject) {
						JsonObject joB = jsonValue2.asJsonObject();		
				Date date = new Date(joB.getInt("day"), joB.getJsonNumber("month").intValue(), joB.getJsonNumber("year").intValue());
				Test te = new Test(date, joB.getString("result"),joB.getInt("test_id") , joB.getString("test type"), joB.getInt("cost"));
				tests.add(te);
					}
		    	}
				per.setTest(tests);
				*/
				// address
				JsonObject obj =ob.asJsonObject().getJsonObject("address");
				Address ad = new Address();
				ad.setCity(obj.getString("city"));
				ad.setDistrict(obj.getString("district"));
				ad.setStreet(obj.getString("street"));
				ad.setWard(obj.getString("ward"));
				per.setAddress(ad);
				
				//phone
				List<String> str = new ArrayList<String>();
				str.add("(432)753-1274");
				str.add("(432)753-1275");
				List<Phone> phones = new ArrayList<Phone>();
				Phone p = new Phone(str);
				phones.add(p);
		
			per.setPhone(phones);
			list.add(per);
		}
		
		return list;
		
		
		
	}

}
