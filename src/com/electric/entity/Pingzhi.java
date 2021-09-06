package com.electric.entity;

import java.sql.Timestamp;

public class Pingzhi {
	private int proId;
	private String title;
	private String content;

	
	
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


	public Pingzhi(int proId, String title, String content) {
		super();
		this.proId = proId;
		this.title = title;
		this.content = content;
	}
	
	public Pingzhi( String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public Pingzhi() {
		super();
	}
	
	
}
