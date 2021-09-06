package com.electric.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.NewsDao;
import com.electric.dao.impl.NewsDaoimpl;
import com.electric.entity.News;
import com.electric.entity.NewsEntity;
import com.electric.entity.Page;
import com.electric.service.NewsService;


public class NewsServiceimpl implements NewsService{
	private NewsDao newsDao=new NewsDaoimpl();
	
	
	/**
	 * 获取新闻分页集合
	 * @param page
	 * @param typeId 新闻类型id，如果typeId是0表示查询所有新闻的分页集合，否则是查询该类型id下属的新闻分页集合
	 * @return
	 */
	
	public NewsEntity findNewsEntityById(int id) {
		NewsEntity newsEntity=new NewsEntity();
		List<News> allList=newsDao.findAll();
		int index=-1;
		for(int i=0;i<allList.size();i++) {
			if(allList.get(i).getNewsId()==id) {
				index=i;
				break;
			}
		}
		if(index!=-1) {
			newsEntity.setCurNews(allList.get(index));//设置当前新闻对象
			if(index!=0) {
				newsEntity.setPreNews(allList.get(index-1));//设置上一条新闻对象
			}
			if(index!=allList.size()-1) {
				newsEntity.setNextNews(allList.get(index+1));
			}
		}
		return newsEntity;
	}
	
	public List<News> findPageList(Page page,int typeId){
		List<News> allList;
		if(typeId==0)
			allList=newsDao.findAll();
		else
			allList=findListByTypeId(typeId);
		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	
	
	
	/**
	 * 根据新闻类型编号获取该类型下的所有新闻集合
	 * @param typeId
	 * @return
	 */
	public List<News> findListByTypeId(int typeId){
		List<News> allList=newsDao.findAll();
		List<News> targetList=new ArrayList<>();
		for(News news:allList) {
			if(news.getTypeId()==typeId) {
				targetList.add(news);
			}
		}
		return targetList;
	}
	
	
	/**
	 * 把给定的新闻信息对象添加到数据库中
	 * @param news
	 * @return
	 */
	public boolean saveNews(News news) {
		return newsDao.saveNews(news);
	}
	
	/**
	 * 按照给定的新闻信息对象修改数据库中该新闻的信息
	 * @param news
	 * @return
	 */
	public boolean updateNews(News news) {
		return newsDao.updateNews(news);
	}
	
	/**
	 * 根据给定的主键主键删除数据库中该新闻的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteNews(int id) {
		return newsDao.deleteNews(id);
	}
	
	public boolean deleteMany(String newsIds) {
		boolean flag=true;
		String[] ids=newsIds.split(",");
		for(int i=0;i<ids.length;i++) {
			flag=flag&newsDao.deleteNews(Integer.parseInt(ids[i]));
		}
		return flag;
	}
	/**
	 * 根据给定的主键获取该主键对应的新闻信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public News findById(int id) {
		return newsDao.findById(id);
	}
	
	
	/**
	 * 获取所有新闻信息集合
	 * @return
	 */
	public List<News> findAll(){
		return newsDao.findAll();
	}
	
	
	
}
