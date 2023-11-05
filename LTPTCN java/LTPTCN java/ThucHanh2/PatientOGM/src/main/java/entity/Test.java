package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Test implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5467237263115152672L;
	@Column(name="test_id", unique = true)
	private String testId;
	@Column(name="test_type")
	private String testType;
	private String result;
	private Date date;
	
	public Test() {
	}

	public Test(String testId, String testType, String result, Date date) {
		super();
		this.testId = testId;
		this.testType = testType;
		this.result = result;
		this.date = date;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testType=" + testType + ", result=" + result + ", date=" + date + "]";
	}
	
	
}
