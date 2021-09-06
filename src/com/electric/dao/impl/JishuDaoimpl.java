package com.electric.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.JishuDao;
import com.electric.entity.Jishu;



public class JishuDaoimpl implements JishuDao{

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Jishu> findAll(){
		String sql="select * from jishu";
		return findList(sql, null);
	}
	
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Jishu findById(int id) {
		String sql="select * from jishu where proId="+id;
		List<Jishu> list=findList(sql, null);
		return list!=null&&list.size()>0?list.get(0):null;
		
	}
	
	/**
	 * 根据sql语句和参数列表查询产品列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<Jishu> findList(String sql,List<Object> paramList){
		
		List<Jishu> list=new ArrayList<Jishu>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql, paramList);
		try {
			 int proId;
			 String title;
			 String content;

			
			while(resultSet.next()) {
				proId=resultSet.getInt("proId");
				title=resultSet.getString("title");
				content=resultSet.getString("content");
				Jishu jishu=new Jishu(proId, title, content);
				list.add(jishu);
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
	 * @param jishu
	 * @return
	 */
	public boolean savejishu(Jishu jishu) {
		String sql="insert into jishu(title,content) values(?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(jishu.getTitle());
		paramList.add(jishu.getContent());

		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 修改产品对象
	 * @param jishu
	 * @return
	 */
	public boolean updatejishu(Jishu jishu) {
		String sql="update jishu set title=?,content=?where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(jishu.getTitle());
		paramList.add(jishu.getContent());
		paramList.add(jishu.getProId());
		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletejishu(int id) {
		String sql="delete from  jishu  where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql, paramList);
	}
}
