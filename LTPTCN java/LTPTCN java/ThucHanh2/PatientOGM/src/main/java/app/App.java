package app;

import dao.PatientDao;
import entity.Patient;

public class App {
	public static void main(String[] args) {
		PatientDao patientDao = new PatientDao();
//		Patient patient = patientDao.getPatient("PT_49759");
//		System.out.println(patient);
		
//		patientDao.getPatients().forEach(p -> System.out.println(p));
		
		boolean result = patientDao.deleteTest("PT_49759", "6723");
		System.out.println(result);
	}
}
