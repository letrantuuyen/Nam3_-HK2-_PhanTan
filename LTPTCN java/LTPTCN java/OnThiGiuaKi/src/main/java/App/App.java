package App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Dao.CourseDao;
import Entity.Course;

public class App {
	public static void main(String[] args) {
		CourseDao courseDao = new CourseDao();
		Set<String>set = new HashSet<String>();
		set.add("Streaming");
		set.add("Object");
		Course course = new Course("N23", "PT", 10, "Lap trinh",set );
		Course course2 = new Course("G24", "PT", 10, "Lap trinh",set );
		List<Course>courses = new ArrayList<Course>();
		courses.add(course2);
		courses.add(course);
		
		System.out.println("Nhập số");
		Scanner scanner = new Scanner(System.in);
		int so  = scanner.nextInt();
		switch (so) {
		case 1:
			long add = courseDao.addCourse(courses);
			System.out.println(add);
			break;
		case 2:
			System.out.println("Nhap id");
			String id = scanner.next();
			boolean delete = courseDao.deleteCourse(id);
			System.out.println(delete);
			break;
		case 3:
			System.out.println("Nhập id: ");
			id = scanner.next();
			scanner.nextLine();
			System.out.println("Nhập title: ");
			String title = scanner.next();
			boolean update = courseDao.updateCourse(id, title);
			System.out.println(update);
		default:
			break;
		}
		
	}
}
