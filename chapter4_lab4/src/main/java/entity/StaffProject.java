package entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="staff_projects")
public class StaffProject {
	
	@Id
	@ManyToOne
	@JoinColumn(name ="project_id")
	private Project projectId;
	@Id
	@ManyToOne
	@JoinColumn(name ="staff_id")
	private Staff staffId;
	
	public StaffProject() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(projectId, staffId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffProject other = (StaffProject) obj;
		return Objects.equals(projectId, other.projectId) && Objects.equals(staffId, other.staffId);
	}
	
	

}
