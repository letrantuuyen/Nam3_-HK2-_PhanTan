package entity;

public class State {

	private String stateName;
	private String abbreviation;
	private String capital;
	private int stateHood;
	private int ID;
	public State(String stateName, String abbreviation, String capital, int stateHood, int iD) {
		super();
		this.stateName = stateName;
		this.abbreviation = abbreviation;
		this.capital = capital;
		this.stateHood = stateHood;
		ID = iD;
	}
	public State() {
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
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "State [stateName=" + stateName + ", abbreviation=" + abbreviation + ", capital=" + capital
				+ ", stateHood=" + stateHood + ", ID=" + ID + "]";
	}
	
	
}
