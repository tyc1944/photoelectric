package com.electric.entity;


public class Liuyan {
	private int id;
	private String username;
	private String company;
	private int phone;
	private String email;
	private String homepage;
	private String title;
	private String content;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
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
	
	
	public Liuyan(int id, String username, String company, int phone, String email, String homepage, String title,
			String content) {
		super();
		this.id = id;
		this.username = username;
		this.company = company;
		this.phone = phone;
		this.email = email;
		this.homepage = homepage;
		this.title = title;
		this.content = content;
	}
	public Liuyan(String username, String company, int phone, String email, String homepage, String title,
			String content) {
		super();
		this.username = username;
		this.company = company;
		this.phone = phone;
		this.email = email;
		this.homepage = homepage;
		this.title = title;
		this.content = content;
	}
	public Liuyan() {
		super();
	}
	@Override
	public String toString() {
		return "Liuyan [id=" + id + ", username=" + username + ", company=" + company + ", phone=" + phone + ", email="
				+ email + ", homepage=" + homepage + ", title=" + title + ", content=" + content + "]";
	}
	
}
