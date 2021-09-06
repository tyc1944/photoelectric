package com.electric.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.electric.entity.Contact;



public interface ContactDao {

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Contact> findAll();
	
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Contact findById(int id) ;
	
	/**
	 * 根据sql语句和参数列表查询产品列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	
	
	
	/**
	 * 添加产品对象
	 * @param contact
	 * @return
	 */
//	public boolean savecontact(contact contact) {
//		String sql="insert into contact(title,pic,content,typeId) values(?,?,?,?)";
//		List<Object> paramList=new ArrayList<>();
//		paramList.add(contact.getTitle());
//		paramList.add(contact.getPic());
//		paramList.add(contact.getContent());
//		paramList.add(contact.getTypeId());
//		return ConnectionManager.executeUpdate(sql, paramList);
//	}
	
	/**
	 * 修改产品对象
	 * @param contact
	 * @return
	 */
	public boolean updatecontact(Contact contact) ;
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletecontact(int id);
}
