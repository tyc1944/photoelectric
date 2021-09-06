package com.electric.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.electric.entity.News;


public interface NewsDao {
	
	/**
	 * 把给定的新闻信息对象添加到数据库中
	 * @param news
	 * @return
	 */
	public boolean saveNews(News news);
	
	/**
	 * 按照给定的新闻信息对象修改数据库中该新闻的信息
	 * @param news
	 * @return
	 */
	public boolean updateNews(News news);
	
	/**
	 * 根据给定的主键主键删除数据库中该新闻的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteNews(int id) ;
	
	/**
	 * 根据给定的主键获取该主键对应的新闻信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public News findById(int id) ;
	
	
	/**
	 * 获取所有新闻信息集合
	 * @return
	 */
	public List<News> findAll();
	
	
	
}
