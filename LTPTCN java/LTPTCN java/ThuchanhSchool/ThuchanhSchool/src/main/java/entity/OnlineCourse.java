package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class OnlineCourse extends Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5053995523886623611L;
	@Column(name = "URL", columnDefinition = "nvarchar(100)")
	private String url;
	
	public OnlineCourse() {
	}

	public OnlineCourse(String title, int credits, String url) {
		super(title, credits);
		this.url = url;
	}
	
	

	
}
