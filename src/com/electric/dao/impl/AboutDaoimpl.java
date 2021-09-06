package com.electric.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.AboutDao;
import com.electric.entity.About;



public class AboutDaoimpl implements AboutDao{

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<About> findAll(){
		String sql="select * from about";
		return findList(sql, null);
	}
	
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public About findById(int id) {
		String sql="select * from about where proId="+id;
		List<About> list=findList(sql, null);
		return list!=null&&list.size()>0?list.get(0):null;
		
	}
	
	/**
	 * 根据sql语句和参数列表查询产品列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<About> findList(String sql,List<Object> paramList){
		
		List<About> list=new ArrayList<About>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql, paramList);
		try {
			 int proId;
			 String title;
			 String content;

			
			while(resultSet.next()) {
				proId=resultSet.getInt("proId");
				title=resultSet.getString("title");
				content=resultSet.getString("content");
				About about=new About(proId, title, content);
				list.add(about);
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
		return list;
	}
	
	
	
	/**
	 * 添加产品对象
	 * @param about
	 * @return
	 */
	public boolean saveabout(About about) {
		String sql="insert into about(title,content) values(?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(about.getTitle());
		paramList.add(about.getContent());
		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 修改产品对象
	 * @param about
	 * @return
	 */
	public boolean updateabout(About about) {
		String sql="update about set title=?,content=?where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(about.getTitle());
		paramList.add(about.getContent());
		paramList.add(about.getProId());
		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteabout(int id) {
		String sql="delete from  about  where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql, paramList);
	}
}
