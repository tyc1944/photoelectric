package com.electric.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.LiuyanDao;
import com.electric.entity.Liuyan;

public class LiuyanDaoimpl implements LiuyanDao{
	
	/**
	 * 把给定的学员信息对象添加到数据库中
	 * @param Liuyan
	 * @return
	 */
	public boolean saveLiuyan(Liuyan Liuyan) {
		String sql="insert into liuyan(username,company,phone,email,homepage,title,content) values(?,?,?,?,?,?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(Liuyan.getUsername());
		paramList.add(Liuyan.getCompany());
		paramList.add(Liuyan.getPhone());
		paramList.add(Liuyan.getEmail());
		paramList.add(Liuyan.getHomepage());
		paramList.add(Liuyan.getTitle());
		paramList.add(Liuyan.getContent());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 按照给定的学员信息对象修改数据库中该学员的信息
	 * @param Liuyan
	 * @return
	 */
	public boolean updateLiuyan(Liuyan Liuyan) {
		String sql="update Liuyan set username=?,company=?,phone=?,email=?,homepage=?,title=?,content=?where id=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(Liuyan.getUsername());
		paramList.add(Liuyan.getCompany());
		paramList.add(Liuyan.getPhone());
		paramList.add(Liuyan.getEmail());
		paramList.add(Liuyan.getHomepage());
		paramList.add(Liuyan.getTitle());
		paramList.add(Liuyan.getContent());
		paramList.add(Liuyan.getId());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的学号主键删除数据库中该学员的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteLiuyan(int Id) {
		String sql="delete from Liuyan where id=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(Id);
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的学号获取该学号对应的学员信息对象，如果学号不存在返回null
	 * @param stuNo
	 * @return
	 */
	public Liuyan findById(int Id) {
		List<Liuyan> list=new ArrayList<>();
		String sql="select * from Liuyan where id=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(Id);
		list=findList(sql,paramList);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	
	/**
	 * 获取所有学员信息集合
	 * @return
	 */
	public List<Liuyan> findAll(){
		String sql="select * from Liuyan";
		return findList(sql,null);
	}
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	 List<Liuyan>  findList(String sql,List<Object> paramList){
		List<Liuyan>  LiuyanList=new ArrayList<>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql,paramList);
		 int id;
		 String username;
		 String company;
		 int phone;
		 String email;
		 String homepage;
		 String title;
		 String content;
		try {
			while(resultSet.next()) {
				id=resultSet.getInt("id");
				username=resultSet.getString("username");
				company=resultSet.getString("company");
				phone=resultSet.getInt("phone");
				email=resultSet.getString("email");
				homepage=resultSet.getString("homepage");
				title=resultSet.getString("title");
				content=resultSet.getString("content");
				//把每一条数据库表中的记录封装成一个Liuyan对象
				Liuyan Liuyan=new Liuyan(id, username, company, phone, email, homepage, title, content);
				LiuyanList.add(Liuyan);//把封装的对象放入到集合中
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
		return LiuyanList;
	}
	
}
