package com.electric.service;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.NewsTypeDao;
import com.electric.entity.News;
import com.electric.entity.NewsType;
import com.electric.entity.Page;



public interface NewsTypeService {

	/**
	 * 查询所有新闻类型
	 * @return
	 */
	public List<NewsType> findPageList(Page page);
	public List<NewsType> findAll();
	
	/**
	 * 根据主键获取新闻类型对象
	 * @param id
	 * @return
	 */
	public NewsType findById(int id) ;
	
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deleteMany(String newsTypeIds);

	
	
	/**
	 * 添加新闻类型对象
	 * @param newsType
	 * @return
	 */
	public boolean saveNewsType(NewsType newsType) ;
	
	/**
	 * 修改新闻类型对象
	 * @param newsType
	 * @return
	 */
	public boolean updateNewsType(NewsType newsType);
	
	/**
	 * 根据主键删除新闻类型对象
	 * @param id
	 * @return
	 */
	public boolean deleteNewsType(int id) ;
	
}
