package Entity;

import java.util.List;

public class Registration {
	private String letterGrade;
	private List<Course>courses;
	public String getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Registration(String letterGrade, List<Course> courses) {
		super();
		this.letterGrade = letterGrade;
		this.courses = courses;
	}
	public Registration() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Registration [letterGrade=" + letterGrade + ", courses=" + courses + "]";
	}
	
}
