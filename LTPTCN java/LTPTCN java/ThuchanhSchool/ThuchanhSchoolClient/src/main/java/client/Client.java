package client;

import java.rmi.Naming;
import java.time.LocalDateTime;

import dao.IStudentDao;
import entity.Student;

public class Client {
	public static void main(String[] args) throws Exception {
		IStudentDao studentDao = (IStudentDao) Naming.lookup("rmi://h82m18:9090/studentDao");
		
		studentDao.addStudent(new Student("asdsa", "sad", LocalDateTime.now()));
	}
}
