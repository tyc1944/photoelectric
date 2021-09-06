package com.electric.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.entity.Liuyan;

public interface LiuyanDao {
	
	/**
	 * 把给定的学员信息对象添加到数据库中
	 * @param Liuyan
	 * @return
	 */
	public boolean saveLiuyan(Liuyan Liuyan) ;
	
	/**
	 * 按照给定的学员信息对象修改数据库中该学员的信息
	 * @param Liuyan
	 * @return
	 */
	public boolean updateLiuyan(Liuyan Liuyan) ;
	
	/**
	 * 根据给定的学号主键删除数据库中该学员的信息
	 * @param stuNo
	 * @return 成功删除返回true;否则返回false
	 */
	public boolean deleteLiuyan(int Id);
	
	/**
	 * 根据给定的学号获取该学号对应的学员信息对象，如果学号不存在返回null
	 * @param stuNo
	 * @return
	 */
	public Liuyan findById(int Id) ;
	
	
	/**
	 * 获取所有学员信息集合
	 * @return
	 */
	public List<Liuyan> findAll();
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	 
	
}
