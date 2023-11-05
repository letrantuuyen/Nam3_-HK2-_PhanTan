/**
 * 
 */
package util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import entity.Address;
import entity.Benhnhan;
import entity.Date;
import entity.Tests;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;


/**
 * @author pc
 *
 */
public class StreamAPI {
	public static Benhnhan toObject(String json) throws FileNotFoundException {
		JsonReader jr = Json.createReader(new FileReader(json));
		JsonArray ja = jr.readArray();
		JsonObject jo = ja.getJsonObject(0);
		List<String> texls = null;
		JsonObject joAddress = (JsonObject) jo.get("address");
		Address address = new Address(joAddress.getString("city"), joAddress.getString("district"),
				joAddress.getString("street"), joAddress.getString("ward"));
		JsonArray jsTesls = jo.getJsonArray("telephones");
		if (jsTesls != null) {
			texls = new ArrayList<String>();
		}
		for (JsonValue jv1 : jsTesls)
			texls.add(jv1.toString());
		JsonObject joTests = (JsonObject) jo.get("tests");
		JsonObject joDate = (JsonObject) joTests.get("date");

		Date date = new Date(joDate.getJsonNumber("day").intValue(), joDate.getJsonNumber("month").intValue(),
				joDate.getJsonNumber("year").intValue());
		Tests tests = new Tests(date, joTests.getString("result"), joTests.getJsonNumber("test_id").longValue(),
				joTests.getString("test_type"), (float) joTests.getJsonNumber("cost").doubleValue());

		Benhnhan p = new Benhnhan(jo.getString("_id"), jo.getString("first_name"), jo.getString("last_name"),
				jo.getString("blood_type"), jo.getString("gender"), address, texls, tests,
				jo.getJsonNumber("year_of_birth").intValue());
		return p;

	}

}
