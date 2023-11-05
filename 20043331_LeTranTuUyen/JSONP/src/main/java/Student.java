
public class Student {
	
	private String id;
	private String fullName;
	private int age;
	private boolean active;
	public Student(String id, String fullName, int age, boolean active) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.active = active;
	}
	

	public Student() {
		super();
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", age=" + age + ", active=" + active + "]";
	}
	

}
