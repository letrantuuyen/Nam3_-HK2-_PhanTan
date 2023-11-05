package entity_bai3;

import java.util.ArrayList;
import java.util.List;

public class  PS {

	private String stateName;
	private String abbreviation;
	private String capital;
	private int stateHood;
	private int id;
	
	public PS(String stateName, String abbreviation, String capital, int stateHood, int id) {
		super();
		this.stateName = stateName;
		this.abbreviation = abbreviation;
		this.capital = capital;
		this.stateHood = stateHood;
		this.id = id;
		
	}
	public PS() {
		super();
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public int getStateHood() {
		return stateHood;
	}
	public void setStateHood(int stateHood) {
		this.stateHood = stateHood;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "PS [stateName=" + stateName + ", abbreviation=" + abbreviation + ", capital=" + capital + ", stateHood="
				+ stateHood + ", id=" + id + "]";
	}

}
