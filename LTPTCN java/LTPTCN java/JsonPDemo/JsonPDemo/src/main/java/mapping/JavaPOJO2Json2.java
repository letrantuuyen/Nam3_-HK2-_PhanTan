package mapping;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import entity.Person;

//Data binding
//Mapping
//Encoding / Decoding
//Marshalling / Unmarshalling
//Serialization / Deserialization

// Java POJO --> Json Data
// Json Data --> Java POJO (Plain Old Java Object)

public class JavaPOJO2Json2{
	public static void main(String[] args) throws IOException {
		Person person = new Person("John", "Smith", 24);  //Java POJO
		Person person2 = new Person("John", "Smith", 24, null);  //Java POJO
		Person person3 = new Person("John", "Smith", 24, "john.smith@gmail.com");  //Java POJO
		
		JsonObject json = toJson(person3);
		
		JsonWriter writer = Json.createWriter(new FileWriter("json/person2.json"));
		writer.writeObject(json);
		writer.close();
		
		System.out.println(json);
		
//	person2 -->	{"firstName": "John","lastName":"Smith","age":24, "email":null}  //Json Object
//	person3 -->	{"firstName": "John","lastName":"Smith","age":24, "email":"john.smith@gmail.com"}  //Json Object
	}

	//The Java Object Model API
	private static JsonObject toJson(Person person) {
		
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("first_name", person.getFirstName())
		.add("last_name", person.getLastName())
		.add("age", person.getAge());
		if(person.getEmail() == null)
			builder.addNull("email");
		else
			builder.add("email", person.getEmail());
		JsonObject jo = builder.build();
		
		return jo;
	}

}
