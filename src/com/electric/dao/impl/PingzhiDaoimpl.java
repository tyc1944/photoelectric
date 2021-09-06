package com.electric.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.PingzhiDao;
import com.electric.entity.Pingzhi;



public class PingzhiDaoimpl implements PingzhiDao{

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Pingzhi> findAll(){
		String sql="select * from pingzhi";
		return findList(sql, null);
	}
	
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Pingzhi findById(int id) {
		String sql="select * from pingzhi where proId="+id;
		List<Pingzhi> list=findList(sql, null);
		return list!=null&&list.size()>0?list.get(0):null;
		
	}
	
	/**
	 * 根据sql语句和参数列表查询产品列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<Pingzhi> findList(String sql,List<Object> paramList){
		
		List<Pingzhi> list=new ArrayList<Pingzhi>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql, paramList);
		try {
			 int proId;
			 String title;
			 String content;

			
			while(resultSet.next()) {
				proId=resultSet.getInt("proId");
				title=resultSet.getString("title");
				content=resultSet.getString("content");
				Pingzhi pingzhi=new Pingzhi(proId, title, content);
				list.add(pingzhi);
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
	 * @param pingzhi
	 * @return
	 */
	public boolean savepingzhi(Pingzhi pingzhi) {
		String sql="insert into pingzhi(title,content) values(?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(pingzhi.getTitle());
		paramList.add(pingzhi.getContent());
		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 修改产品对象
	 * @param pingzhi
	 * @return
	 */
	public boolean updatepingzhi(Pingzhi pingzhi) {
		String sql="update pingzhi set title=?,content=?where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(pingzhi.getTitle());
		paramList.add(pingzhi.getContent());
		paramList.add(pingzhi.getProId());
		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletepingzhi(int id) {
		String sql="delete from  pingzhi  where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql, paramList);
	}
}
