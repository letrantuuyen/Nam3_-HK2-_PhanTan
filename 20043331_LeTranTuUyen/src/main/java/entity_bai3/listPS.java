package entity_bai3;

import java.util.ArrayList;
import java.util.List;

public class listPS {
	List<PS> persons = new ArrayList<>();

	public listPS(List<PS> persons) {
		super();
		this.persons = persons;
	}

	public listPS() {
		super();
	}

	public List<PS> getPersons() {
		return persons;
	}

	public void setPersons(List<PS> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "listPS [persons=" + persons + "]";
	}


}
