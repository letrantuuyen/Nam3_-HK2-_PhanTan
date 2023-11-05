package app;

import java.rmi.RemoteException;

import dao.CourseDao;
import dao.CourseInstructorDao;
import dao.InstructorDao;
import dao.StudentDao;
import entity.Course;
import entity.Instructor;

public class App {
	public static void main(String[] args) throws RemoteException {
		
		
		StudentDao studentDao = new StudentDao();
		InstructorDao instructorDao = new InstructorDao();
		CourseDao courseDao = new CourseDao();
		CourseInstructorDao courseInstructorDao = new CourseInstructorDao();
		
		
		Course course = courseDao.getCourse(1045);
		Instructor instructor = instructorDao.getInstructor(1);
		System.out.println(instructor);
		
		courseInstructorDao.addCourseInstructor(course, instructor);
		
	}
}
