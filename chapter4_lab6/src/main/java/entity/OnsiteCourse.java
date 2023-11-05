package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name ="CourseID")
public class OnsiteCourse extends Course implements Serializable{
	
	@Column(name ="Days",columnDefinition = "nvarchar(100)")
	private String days;
	@Column(name ="Location", columnDefinition = "nvarchar(255)")
	private String location;
	@Column(name ="Time")
	private LocalDate time;
	
	public OnsiteCourse() {
		// TODO Auto-generated constructor stub
	}

	public OnsiteCourse(int id, String title, String days, String location, LocalDate time) {
		super(id, title);
		this.days = days;
		this.location = location;
		this.time = time;
	}

	public OnsiteCourse(String days, String location, LocalDate time) {
		this.days = days;
		this.location = location;
		this.time = time;
	}
	
	
	
	

}
