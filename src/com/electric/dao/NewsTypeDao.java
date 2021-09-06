package com.electric.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.entity.NewsType;


public interface NewsTypeDao {
	
	/**
	 * 把给定的新闻类型信息对象添加到数据库中
	 * @param newsType
	 * @return
	 */
	public boolean saveNewsType(NewsType newsType);
	
	/**
	 * 按照给定的新闻类型信息对象修改数据库中该新闻类型的信息
	 * @param newsType
	 * @return
	 */
	public boolean updateNewsType(NewsType newsType);
	
	/**
	 * 根据给定的主键主键删除数据库中该新闻类型的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteNewsType(int id);
	
	/**
	 * 根据给定的主键获取该主键对应的新闻类型信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public NewsType findById(int id);
	
	
	/**
	 * 获取所有新闻类型信息集合
	 * @return
	 */
	public List<NewsType> findAll();
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	
}
