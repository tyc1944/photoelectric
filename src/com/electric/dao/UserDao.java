package com.electric.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.electric.entity.User;



public interface UserDao {

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<User> findAll();
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public User findById(int id) ;
	
	/**
	 * 根据sql语句和参数列表查询产品列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	
	
	
	
	/**
	 * 添加产品对象
	 * @param User
	 * @return
	 */
	public boolean saveUser(User User);
	
	/**
	 * 修改产品对象
	 * @param User
	 * @return
	 */
	public boolean updateUser(User User) ;
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteUser(int id);
}
