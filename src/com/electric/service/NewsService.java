package com.electric.service;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.NewsDao;
import com.electric.entity.News;
import com.electric.entity.NewsEntity;
import com.electric.entity.Page;


public interface NewsService {

	
	/**
	 * 获取新闻分页集合
	 * @param page
	 * @param typeId 新闻类型id，如果typeId是0表示查询所有新闻的分页集合，否则是查询该类型id下属的新闻分页集合
	 * @return
	 */
	
	public NewsEntity findNewsEntityById(int id);
	
	public List<News> findPageList(Page page,int typeId);
	
	
	
	/**
	 * 根据新闻类型编号获取该类型下的所有新闻集合
	 * @param typeId
	 * @return
	 */
	public List<News> findListByTypeId(int typeId);
	
	
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
	
	public boolean deleteMany(String newsIds);
	/**
	 * 根据给定的主键获取该主键对应的新闻信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public News findById(int id);
	
	
	/**
	 * 获取所有新闻信息集合
	 * @return
	 */
	public List<News> findAll();
	
	
	
}
