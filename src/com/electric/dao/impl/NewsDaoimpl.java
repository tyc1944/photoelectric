package com.electric.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.NewsDao;
import com.electric.entity.News;


public class NewsDaoimpl implements NewsDao{
	
	/**
	 * 把给定的新闻信息对象添加到数据库中
	 * @param news
	 * @return
	 */
	public boolean saveNews(News news) {
		String sql="insert into tbl_news(title,description,clicks,author,postTime,typeId) values(?,?,?,?,?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(news.getTitle());
		paramList.add(news.getDescription());
		paramList.add(news.getClicks());
		paramList.add(news.getAuthor());
		paramList.add(news.getPostTime());
		paramList.add(news.getTypeId());
		
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 按照给定的新闻信息对象修改数据库中该新闻的信息
	 * @param news
	 * @return
	 */
	public boolean updateNews(News news) {
		String sql="update tbl_news set title=?,description=?,clicks=?,author=?,postTime=?,typeId=? where newsId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(news.getTitle());
		paramList.add(news.getDescription());
		paramList.add(news.getClicks());
		paramList.add(news.getAuthor());
		paramList.add(news.getPostTime());
		paramList.add(news.getTypeId());
		paramList.add(news.getNewsId());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键主键删除数据库中该新闻的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteNews(int id) {
		String sql="delete from tbl_news where newsId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键获取该主键对应的新闻信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public News findById(int id) {
		List<News> list=new ArrayList<>();
		String sql="select * from tbl_news where newsId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		list=findList(sql,paramList);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	
	/**
	 * 获取所有新闻信息集合
	 * @return
	 */
	public List<News> findAll(){
		String sql="select * from tbl_news order by postTime desc";
		return findList(sql,null);
	}
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<News>  findList(String sql,List<Object> paramList){
		List<News>  newsList=new ArrayList<>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql,paramList);
		 int newsId;
		 String title;
		 String description;
		 int clicks;
		 String author;
		 Timestamp postTime;
		 int typeId;
		try {
			while(resultSet.next()) {
				newsId=resultSet.getInt("newsId");
				title=resultSet.getString("title");
				description=resultSet.getString("description");
				clicks=resultSet.getInt("clicks");
				author=resultSet.getString("author");
				postTime=resultSet.getTimestamp("postTime");
				typeId=resultSet.getInt("typeId");
				//把每一条数据库表中的记录封装成一个News对象
				News news=new News(newsId, title, description, clicks, author,postTime, typeId);
				newsList.add(news);//把封装的对象放入到集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ConnectionManager.closeAll(resultSet, resultSet.getStatement(), resultSet.getStatement().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newsList;
	}
	
}
