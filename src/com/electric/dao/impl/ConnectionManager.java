package com.electric.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ConnectionManager{

	/**
	 * 创建连接
	 * @return
	 */
	private static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载并注册驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/photodb?characterEncoding=utf8";
		
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url, "root", "1234");//创建连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * 根据给定的sql语句执行增删改操作
	 * @param sql
	 * @return
	 */
	public static boolean executeUpdate(String sql) {
		int n=0;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=createConnection();//通过调用自定义的方法创建连接
			preparedStatement=connection.prepareStatement(sql);//创建描述 
			n=preparedStatement.executeUpdate();//执行增删改语句返回受影响的行数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(null,preparedStatement,connection);
		}
		return n>0?true:false;
		
	}

	/**
	 * 根据给定的sql语句和参数值集合执行增删改操作
	 * @param sql
	 * @param paramsList
	 * @return
	 */
	public static boolean executeUpdate(String sql,List<Object> paramList) {
		int n=0;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=createConnection();//通过调用自定义的方法创建连接
			preparedStatement=connection.prepareStatement(sql);//创建描述 
			if(paramList!=null) {
				for(int i=0;i<paramList.size();i++) {
					preparedStatement.setObject(i+1, paramList.get(i));
				}
			}
			n=preparedStatement.executeUpdate();//执行增删改语句返回受影响的行数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(null,preparedStatement,connection);
		}
		return n>0?true:false;
		
	}


	/**
	 * 根据sql语句执行查询
	 * @param sql
	 * @return
	 */
	public static ResultSet executeQuery(String sql) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=createConnection();//通过调用自定义的方法创建连接
			preparedStatement=connection.prepareStatement(sql);//创建描述 
			resultSet=preparedStatement.executeQuery();//执行增删改语句返回受影响的行数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
		
	}
	
	/**
	 * 根据给定的sql语句和参数值集合执行查询操作
	 * @param sql
	 * @param paramsList
	 * @return 返回结果集
	 */
	public static ResultSet executeQuery(String sql,List<Object> paramList) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=createConnection();//通过调用自定义的方法创建连接
			preparedStatement=connection.prepareStatement(sql);//创建描述 
			if(paramList!=null) {
				for(int i=0;i<paramList.size();i++) {
					preparedStatement.setObject(i+1, paramList.get(i));
				}
			}
			resultSet=preparedStatement.executeQuery();//执行增删改语句返回受影响的行数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	
	/**
	 * 根据sql语句返回满足条件的记录数
	 * @param sql
	 * @return
	 */
	public static int executeCount(String sql) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int n=0;
		try {
			connection=createConnection();//通过调用自定义的方法创建连接
			preparedStatement=connection.prepareStatement(sql);//创建描述 
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				n=resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(resultSet,preparedStatement,connection);
		}
		return n;
	}
	
	/**
	 * 根据给定的sql语句和参数集合求满足条件的记录数
	 * @param sql
	 * @param paramList
	 * @return
	 */
	public static int executeCount(String sql,List<Object> paramList) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int n=0;
		try {
			connection=createConnection();//通过调用自定义的方法创建连接
			preparedStatement=connection.prepareStatement(sql);//创建描述 
			if(paramList!=null) {
				for(int i=0;i<paramList.size();i++) {
					preparedStatement.setObject(i+1, paramList.get(i));
				}
			}
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				n=resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(resultSet,preparedStatement,connection);
		}
		return n;
	}
	
	
	/**
	 * 关闭所有
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void closeAll(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	


}
