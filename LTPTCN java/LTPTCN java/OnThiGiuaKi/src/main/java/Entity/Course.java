package Entity;

import java.util.Set;

public class Course {
	private String id;
	private String title;
	private int credit;
	private String description;
	private Set<String> intructors;
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<String> getIntructors() {
		return intructors;
	}
	public void setIntructors(Set<String> intructors) {
		this.intructors = intructors;
	}
	public Course(String id, String title, int credit, String description, Set<String> intructors) {
		super();
		this.id = id;
		this.title = title;
		this.credit = credit;
		this.description = description;
		this.intructors = intructors;
	}
	public Course() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", credit=" + credit + ", description=" + description
				+ ", intructors=" + intructors + "]";
	}
	
}
