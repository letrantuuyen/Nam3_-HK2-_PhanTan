package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="staffs")
public class Staff {
	@Id
	@Column(name ="staff_id")
	private Long id;
	private int age;
	@Column(name ="staff_name",columnDefinition = "nvarchar(100)")
	private String name;
	
	@ElementCollection
	@JoinTable(name ="phones", joinColumns = @JoinColumn(name ="staff_id"))
	@Column(name ="number")
	private Set<String> phoneNumbers;
	
	@Column(name ="refers")
	private String references;
	
	@ManyToOne
	@JoinColumn(name ="dept_id")
	private Department department;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Profile profile;
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	
	

}
