package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="profiles")
public class Profile {
	
	@OneToOne
	@MapsId
	@JoinColumn(name ="staff_id")
	@Id
	private Staff staffId;
	private String avatar;
	private String description;
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	

}
