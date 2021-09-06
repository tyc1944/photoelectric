package com.electric.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.NewsTypeDao;
import com.electric.entity.NewsType;


public class NewsTypeDaoimpl implements NewsTypeDao{
	
	/**
	 * 把给定的新闻类型信息对象添加到数据库中
	 * @param newsType
	 * @return
	 */
	public boolean saveNewsType(NewsType newsType) {
		String sql="insert into tbl_newstype(typeName) values(?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(newsType.getTypeName());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 按照给定的新闻类型信息对象修改数据库中该新闻类型的信息
	 * @param newsType
	 * @return
	 */
	public boolean updateNewsType(NewsType newsType) {
		String sql="update tbl_newstype set typeName=? where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(newsType.getTypeName());
		paramList.add(newsType.getTypeId());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键主键删除数据库中该新闻类型的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteNewsType(int id) {
		String sql="delete from tbl_newstype where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键获取该主键对应的新闻类型信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public NewsType findById(int id) {
		List<NewsType> list=new ArrayList<>();
		String sql="select * from tbl_newstype where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		list=findList(sql,paramList);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	
	/**
	 * 获取所有新闻类型信息集合
	 * @return
	 */
	public List<NewsType> findAll(){
		String sql="select * from tbl_newstype";
		return findList(sql,null);
	}
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<NewsType>  findList(String sql,List<Object> paramList){
		List<NewsType>  newsTypeList=new ArrayList<>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql,paramList);
		 int typeId;
		 String typeName;
		try {
			while(resultSet.next()) {
				typeId=resultSet.getInt("typeId");
				typeName=resultSet.getString("typeName");
				//把每一条数据库表中的记录封装成一个NewsType对象
				NewsType newsType=new NewsType(typeId,typeName);
				newsTypeList.add(newsType);//把封装的对象放入到集合中
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
		return newsTypeList;
	}
	
}
