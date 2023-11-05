package app;



import java.util.Date;

import Entity.Course;
import Entity.Faculty;
import dao.CourseDao;
import dao.FacultyCourseDao;
import dao.FacultyDao;

public class App {

	public static void main(String[] args) throws Exception {
		FacultyCourseDao facultyCourseDao = new FacultyCourseDao();
		FacultyDao facultyDao = new FacultyDao();
		CourseDao courseDao = new CourseDao();
		Course course1 = new Course(2, "dept03", "met qua", "C31", "hichic");
		Faculty faculty1 = new Faculty(new Date(), "F31", "ncnc", 2000);
//		System.out.println(courseDao.addCourse(course1));
//		System.out.println(facultyDao.addFaculty(faculty1));
		
//		System.out.println(course1);
//		System.out.println(faculty1);
//		System.out.println(facultyCourseDao.addFacultyCourse(course1, faculty1));
//		FacultyDao facultyDao = new FacultyDao();
//		facultyDao.getFacultiesByCourseTitle("Chemistry").forEach(o -> System.out.println(o));
//		Faculty faculty2 = new Faculty(new Date(), "EBB2", null, 2000);
//		System.out.println(facultyDao.addFaculty(faculty2));
		System.out.println(facultyDao.getFaculty("F31"));
		
	}

}
