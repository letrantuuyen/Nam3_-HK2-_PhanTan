package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class OnsiteCourse extends Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2214978419038917854L;
	@Column(name="Location", columnDefinition = "nvarchar(50)")
	private String location;
	@Column(name = "Days", columnDefinition = "nvarchar(50)")
	private String days;
	@Column(name="Time", columnDefinition = "smalldatetime")
	private LocalDateTime time;
	
	public OnsiteCourse() {
	}

	public OnsiteCourse(String title, int credits, String location, String days, LocalDateTime time) {
		super(title, credits);
		this.location = location;
		this.days = days;
		this.time = time;
	}

	
}
