package entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
	private Date date;
	private String result;
	private int test_id;
	private String test_type;
	private int cost;
	public Test(Date date, String result, int test_id, String test_type, int cost) {
		super();
		this.date = date;
		this.result = result;
		this.test_id = test_id;
		this.test_type = test_type;
		this.cost = cost;
	}
	public Test() {
		super();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public String getTest_type() {
		return test_type;
	}
	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Test [date=" + date + ", result=" + result + ", test_id=" + test_id + ", test_type=" + test_type
				+ ", cost=" + cost + "]";
	}
	
	

}
