package entity;

import java.util.Date;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;

import com.google.gson.annotations.SerializedName;

public class Movie {
	@BsonId
	@SerializedName("_id")
	private String id;
	private String title;
	private Date released;
	private List<String> genres;
	private List<String> direction;
	private List<String> cast;
	private String plot;
	private String poster;
	List<Showtime> show;
	public Movie(String id, String title, Date released, List<String> genres, List<String> direction, List<String> cast,
			String plot, String poster, List<Showtime> show) {
		super();
		this.id = id;
		this.title = title;
		this.released = released;
		this.genres = genres;
		this.direction = direction;
		this.cast = cast;
		this.plot = plot;
		this.poster = poster;
		this.show = show;
	}
	public Movie() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public List<String> getDirection() {
		return direction;
	}
	public void setDirection(List<String> direction) {
		this.direction = direction;
	}
	public List<String> getCast() {
		return cast;
	}
	public void setCast(List<String> cast) {
		this.cast = cast;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public List<Showtime> getShow() {
		return show;
	}
	public void setShow(List<Showtime> show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", released=" + released + ", genres=" + genres + ", direction="
				+ direction + ", cast=" + cast + ", plot=" + plot + ", poster=" + poster + ", show=" + show + "]";
	} 
	
	
	

}
