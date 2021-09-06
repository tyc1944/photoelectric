package com.electric.entity;

import java.sql.Timestamp;


/**
 * 新闻实体类
 * @author hgf
 * 2021年6月7日
 */
public class News {
	private int newsId;
	private String title;
	private String description;
	private int clicks;
	private String author;
	private Timestamp postTime;
	private int typeId;
	
	
	public Timestamp getPostTime() {
		return postTime;
	}
	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public News(int newsId, String title, String description, int clicks, String author, Timestamp postTime, int typeId) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.description = description;
		this.clicks = clicks;
		this.author = author;
		this.postTime = postTime;
		this.typeId = typeId;
	}
	
	public News(String title, String description, int clicks, String author, Timestamp postTime, int typeId) {
		super();
		this.title = title;
		this.description = description;
		this.clicks = clicks;
		this.author = author;
		this.postTime = postTime;
		this.typeId = typeId;
	}
	public News() {
		super();
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", description=" + description + ", clicks=" + clicks
				+ ", author=" + author + ", postTime=" + postTime + ", typeId=" + typeId + "]";
	}

	
	
	
}
