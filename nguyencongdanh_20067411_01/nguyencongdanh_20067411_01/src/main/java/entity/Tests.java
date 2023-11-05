package entity;

public class Tests {
	private Date date;
	private String resuilt;
	private long test_id;
	private String test_type;
	private float cost;
	public Tests() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tests(Date date, String resuilt, long test_id, String test_type, float cost) {
		super();
		this.date = date;
		this.resuilt = resuilt;
		this.test_id = test_id;
		this.test_type = test_type;
		this.cost = cost;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getResuilt() {
		return resuilt;
	}
	public void setResuilt(String resuilt) {
		this.resuilt = resuilt;
	}
	public long getTest_id() {
		return test_id;
	}
	public void setTest_id(long test_id) {
		this.test_id = test_id;
	}
	public String getTest_type() {
		return test_type;
	}
	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Tests [date=" + date + ", resuilt=" + resuilt + ", test_id=" + test_id + ", test_type=" + test_type
				+ ", cost=" + cost + "]";
	}
	

}
