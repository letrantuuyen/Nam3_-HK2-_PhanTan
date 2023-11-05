package Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Courses")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -755679958988270457L;
	@Column(columnDefinition = "int",nullable = false)
	private int credit;
	@Column(name="dept_id",columnDefinition = "varchar(255)",nullable = false)
	private String deptId;
	@Column(columnDefinition = "ntext")
	private String description;
	@Id
	@Column(name="course_id",columnDefinition = "varchar(255)",nullable = false)
	private String id;
	@Column(columnDefinition = "nvarchar(100)",nullable = false)
	private String title;
	@ManyToMany(mappedBy = "courses")
	private List<Faculty> faculties;
	public Course(int credit, String deptId, String description, String id, String title) {
		super();
		this.credit = credit;
		this.deptId = deptId;
		this.description = description;
		this.id = id;
		this.title = title;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Course [credit=" + credit + ", deptId=" + deptId + ", description=" + description + ", id=" + id
				+ ", title=" + title + "]";
	}
	
	
	
	
	
	
	
}
