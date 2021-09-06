package com.electric.entity;

import java.sql.Timestamp;

public class Product {
	private int proId;
	private String title;
	private String content;
	private String pic;
	private Timestamp postTime;
	private int typeId;
	
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public Timestamp getPostTime() {
		return postTime;
	}
	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public Product(int proId, String title, String content, String pic, Timestamp postTime, int typeId) {
		super();
		this.proId = proId;
		this.title = title;
		this.content = content;
		this.pic = pic;
		this.postTime = postTime;
		this.typeId = typeId;
	}
	
	
	public Product(String title, String content, String pic, int typeId) {
		super();
		this.title = title;
		this.content = content;
		this.pic = pic;
		this.typeId = typeId;
	}
	public Product() {
		super();
	}
	
	
}
