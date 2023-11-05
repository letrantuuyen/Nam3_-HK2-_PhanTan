import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Demo2 {
	public static void main(String[] args) {
		//tạo đối tượng
		Student student = new Student("20043331", "Le Tran Tu Uyen", 21, true);
		
		System.out.println(student);
		// chuyển từ đối tượng sang json
		JsonObjectBuilder json = Json.createObjectBuilder();
		JsonObject jsonObject = json
					.add("id", student.getId())
					.add("fullName", student.getFullName())
					.add("age", student.getAge())
					.add("active", student.isActive())
					.build();
		
		System.out.println(jsonObject);
					
	}

}
