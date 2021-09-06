package com.electric.entity;

import com.electric.entity.News;

public class NewsEntity {
	private News preNews;
	private News curNews;
	private News nextNews;
	
	public News getPreNews() {
		return preNews;
	}
	public void setPreNews(News preNews) {
		this.preNews = preNews;
	}
	public News getCurNews() {
		return curNews;
	}
	public void setCurNews(News curNews) {
		this.curNews = curNews;
	}
	public News getNextNews() {
		return nextNews;
	}
	public void setNextNews(News nextNews) {
		this.nextNews = nextNews;
	}
	public NewsEntity(News preNews, News curNews, News nextNews) {
		super();
		this.preNews = preNews;
		this.curNews = curNews;
		this.nextNews = nextNews;
	}
	public NewsEntity() {
		super();
	}
	@Override
	public String toString() {
		return "NewsEntity [preNews=" + preNews + ", curNews=" + curNews + ", nextNews=" + nextNews + "]";
	}
	
	
}
