package entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Comment")
public class Comment implements Serializable{
	private String commentContent;
	private Date localDateTime;
	@Id
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	@Id
	@ManyToOne
	@JoinColumn(name = "newsID")
	private News news;
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(Date localDateTime) {
		this.localDateTime = localDateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + ", localDateTime=" + localDateTime + ", userID=" + user.getUserID()
				+ ", newsID=" + news.getNewsID() + "]";
	}
	public Comment(String commentContent, Date localDateTime, User user, News news) {
		super();
		this.commentContent = commentContent;
		this.localDateTime = localDateTime;
		this.user = user;
		this.news = news;
	}
	
}
