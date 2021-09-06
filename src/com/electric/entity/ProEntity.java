package com.electric.entity;


public class ProEntity {
	private Product preNews;
	private Product curNews;
	private Product nextNews;
	public Product getPreNews() {
		return preNews;
	}
	public void setPreNews(Product preNews) {
		this.preNews = preNews;
	}
	public Product getCurNews() {
		return curNews;
	}
	public void setCurNews(Product curNews) {
		this.curNews = curNews;
	}
	public Product getNextNews() {
		return nextNews;
	}
	public void setNextNews(Product nextNews) {
		this.nextNews = nextNews;
	}
	public ProEntity(Product preNews, Product curNews, Product nextNews) {
		super();
		this.preNews = preNews;
		this.curNews = curNews;
		this.nextNews = nextNews;
	}
	public ProEntity() {
		super();
	}
	@Override
	public String toString() {
		return "ProEntity [preNews=" + preNews + ", curNews=" + curNews + ", nextNews=" + nextNews + "]";
	}
	

	
}
