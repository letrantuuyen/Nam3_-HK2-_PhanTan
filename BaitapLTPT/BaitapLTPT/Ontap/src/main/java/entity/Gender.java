package entity;

public enum Gender {
	M("Male"), F("Female");
	
	private String gender;

	private Gender(String gender) {
		this.gender = gender;
	}
	private Gender() {
	}
	
	public String getGender() {
		return gender;
	}
}
