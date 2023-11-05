package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name ="CourseID")
public class OnlineCourse extends Course implements Serializable {
	
	@Column(name ="URL", columnDefinition = "nvarchar(100)")
	private String url;
	
	public OnlineCourse() {
		// TODO Auto-generated constructor stub
	}

	public OnlineCourse(int id, String title, String url) {
		super(id, title);
		this.url = url;
	}
	
	
	

}
