package com.electric.service.impl;

import java.util.List;

import com.electric.dao.NewsTypeDao;
import com.electric.dao.ProductDao;
import com.electric.dao.ProductTypeDao;
import com.electric.dao.impl.NewsTypeDaoimpl;
import com.electric.dao.impl.ProductTypeDaoimpl;
import com.electric.entity.NewsType;
import com.electric.entity.Page;
import com.electric.service.NewsTypeService;



public class NewsTypeServiceimpl implements NewsTypeService{

	NewsTypeDao newsTypeDao=new NewsTypeDaoimpl();

	/**
	 * 查询所有新闻类型
	 * @return
	 */
	public List<NewsType> findPageList(Page page){
		List<NewsType> allList;
			allList=newsTypeDao.findAll();

		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	public List<NewsType> findAll(){
		return newsTypeDao.findAll();
	}
	
	/**
	 * 根据主键获取新闻类型对象
	 * @param id
	 * @return
	 */
	public NewsType findById(int id) {
		return newsTypeDao.findById(id);
		
	}
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deleteMany(String newsTypeIds) {
		boolean flag=true;
		String[] ids=newsTypeIds.split(",");
		for(int i=0;i<ids.length;i++) {
			flag=flag&newsTypeDao.deleteNewsType(Integer.parseInt(ids[i]));
		}
		return flag;
	}

	
	
	/**
	 * 添加新闻类型对象
	 * @param newsType
	 * @return
	 */
	public boolean saveNewsType(NewsType newsType) {
		
		return newsTypeDao.saveNewsType(newsType);
	}
	
	/**
	 * 修改新闻类型对象
	 * @param newsType
	 * @return
	 */
	public boolean updateNewsType(NewsType newsType) {
		return newsTypeDao.updateNewsType(newsType);
	}
	
	/**
	 * 根据主键删除新闻类型对象
	 * @param id
	 * @return
	 */
	public boolean deleteNewsType(int id) {
		return newsTypeDao.deleteNewsType(id);
	}
	
}
