package com.electric.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.CompanyMapDao;
import com.electric.entity.Companymap;


public class CompanyMapDaoimpl implements CompanyMapDao{
	
	/**
	 * 把给定的新闻类型信息对象添加到数据库中
	 * @param companymap
	 * @return
	 */
	public boolean savecompanymap(Companymap companymap) {
		String sql="insert into companymap(typeName) values(?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(companymap.getTypeName());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 按照给定的新闻类型信息对象修改数据库中该新闻类型的信息
	 * @param companymap
	 * @return
	 */
	public boolean updatecompanymap(Companymap companymap) {
		String sql="update companymap set typeName=? where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(companymap.getTypeName());
		paramList.add(companymap.getTypeId());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键主键删除数据库中该新闻类型的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deletecompanymap(int id) {
		String sql="delete from companymap where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键获取该主键对应的新闻类型信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public Companymap findById(int id) {
		List<Companymap> list=new ArrayList<>();
		String sql="select * from companymap where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		list=findList(sql,paramList);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	
	/**
	 * 获取所有新闻类型信息集合
	 * @return
	 */
	public List<Companymap> findAll(){
		String sql="select * from companymap";
		return findList(sql,null);
	}
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<Companymap>  findList(String sql,List<Object> paramList){
		List<Companymap>  companymapList=new ArrayList<>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql,paramList);
		 int typeId;
		 String typeName;
		try {
			while(resultSet.next()) {
				typeId=resultSet.getInt("typeId");
				typeName=resultSet.getString("typeName");
				//把每一条数据库表中的记录封装成一个companymap对象
				Companymap companymap=new Companymap(typeId,typeName);
				companymapList.add(companymap);//把封装的对象放入到集合中
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
		return companymapList;
	}
	
}
