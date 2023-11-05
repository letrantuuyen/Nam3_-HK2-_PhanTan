package Connection;

import java.util.Arrays;

import org.bson.Document;

import Entity.Course;

public class Mapper {
	public static Document toDoc(Course course) {
		return new Document("_id",course.getId())
				.append("title", course.getTitle())
				.append("credit", course.getCredit())
				.append("description", course.getDescription())
				.append("instructors", Arrays.asList(course.getIntructors()));
	}
}
