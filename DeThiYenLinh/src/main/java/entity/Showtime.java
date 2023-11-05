package entity;

import java.util.Date;
import java.util.List;

public class Showtime {
	private String id;
	private String hallName;
	private String time;
	private Date date;
	List<Showseat> showseat;
	public Showtime(String id, String hallName, String time, Date date, List<Showseat> showseat) {
		super();
		this.id = id;
		this.hallName = hallName;
		this.time = time;
		this.date = date;
		this.showseat = showseat;
	}
	public Showtime() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Showseat> getShowseat() {
		return showseat;
	}
	public void setShowseat(List<Showseat> showseat) {
		this.showseat = showseat;
	}
	@Override
	public String toString() {
		return "Showtime [id=" + id + ", hallName=" + hallName + ", time=" + time + ", date=" + date + ", showseat="
				+ showseat + "]";
	}
	

}
