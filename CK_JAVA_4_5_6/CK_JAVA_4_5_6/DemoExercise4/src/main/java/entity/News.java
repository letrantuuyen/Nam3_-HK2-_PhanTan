package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "News")
public class News implements Serializable{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long newsID;
	private Set<String> newsCategories;
	private Date creationDate;
	private String newsContent;
	private String newsTitle;
	@ElementCollection
	@CollectionTable(name="News_Tags", joinColumns = @JoinColumn(name = "newsID"))
	private Set<String> tags;
	@ElementCollection
	@CollectionTable(name="News_Votes",joinColumns = @JoinColumn(name = "newsID"))
	private Set<Integer> votes;
	public long getNewsID() {
		return newsID;
	}
	public void setNewsID(long newsID) {
		this.newsID = newsID;
	}
	public Set<String> getNewsCategories() {
		return newsCategories;
	}
	public void setNewsCategories(Set<String> newsCategories) {
		this.newsCategories = newsCategories;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public Set<Integer> getVotes() {
		return votes;
	}
	public void setVotes(Set<Integer> votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "News [newsID=" + newsID + ", newsCategories=" + newsCategories + ", creationDate=" + creationDate
				+ ", newsContent=" + newsContent + ", newsTitle=" + newsTitle + "]";
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(Set<String> newsCategories, Date creationDate, String newsContent, String newsTitle) {
		super();
		this.newsCategories = newsCategories;
		this.creationDate = creationDate;
		this.newsContent = newsContent;
		this.newsTitle = newsTitle;
	}
	public News(long newsID, Set<String> newsCategories, Date creationDate, String newsContent, String newsTitle) {
		super();
		this.newsID = newsID;
		this.newsCategories = newsCategories;
		this.creationDate = creationDate;
		this.newsContent = newsContent;
		this.newsTitle = newsTitle;
	}
	
	
}
