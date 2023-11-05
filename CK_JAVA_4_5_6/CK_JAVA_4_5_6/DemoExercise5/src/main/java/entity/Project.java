package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name = "Project")
public class Project implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectID;
	private String projectName;
	private String type;
	
	@ElementCollection
	@CollectionTable(name="Project_Versions", joinColumns = @JoinColumn(name = "projectID"))
	private Set<String> versions;
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<String> getVersions() {
		return versions;
	}
	public void setVersions(Set<String> versions) {
		this.versions = versions;
	}
	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", type=" + type + "]";
	}
	public Project(long projectID, String projectName, String type) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.type = type;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(String projectName, String type) {
		super();
		this.projectName = projectName;
		this.type = type;
	}
	
	
}
