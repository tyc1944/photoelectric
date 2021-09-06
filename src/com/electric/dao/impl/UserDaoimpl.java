package com.electric.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.UserDao;
import com.electric.entity.User;



public class UserDaoimpl implements UserDao{

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<User> findAll(){
		String sql="select * from User";
		return findList(sql, null);
	}
	
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public User findById(int id) {
		String sql="select * from User where uid="+id;
		List<User> list=findList(sql, null);
		return list!=null&&list.size()>0?list.get(0):null;
		
	}
	
	/**
	 * 根据sql语句和参数列表查询产品列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<User> findList(String sql,List<Object> paramList){
		
		List<User> list=new ArrayList<User>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql, paramList);
		try {
			 int uid;
			 String uname;
			 String upass;
			
			while(resultSet.next()) {
				uid=resultSet.getInt("uid");
				uname=resultSet.getString("uname");
				upass=resultSet.getString("upass");
				User User=new User(uid, uname, upass);
				list.add(User);
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
	 * @param User
	 * @return
	 */
	public boolean saveUser(User User) {
		String sql="insert into User(uname,upass) values(?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(User.getUname());
		paramList.add(User.getUpass());
		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 修改产品对象
	 * @param User
	 * @return
	 */
	public boolean updateUser(User User) {
		String sql="update User set uname=?,upass=? where uid=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(User.getUname());
		paramList.add(User.getUpass());
		paramList.add(User.getUid());
		return ConnectionManager.executeUpdate(sql, paramList);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteUser(int id) {
		String sql="delete from  User  where uid=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql, paramList);
	}
}
