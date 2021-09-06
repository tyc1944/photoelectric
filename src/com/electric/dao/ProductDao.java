package com.electric.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.electric.entity.Product;

/**
 * 产品链接数据库类
 * @author hgf
 * 2021年6月8日
 */
public interface ProductDao {
	
	/**
	 * 把给定的产品信息对象添加到数据库中
	 * @param product
	 * @return
	 */
	public boolean saveProduct(Product product);
	
	/**
	 * 按照给定的产品信息对象修改数据库中该产品的信息
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product);
	
	/**
	 * 根据给定的主键主键删除数据库中该产品的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteProduct(int id);
	
	/**
	 * 根据给定的主键获取该主键对应的产品信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public Product findById(int id);
	
	
	/**
	 * 获取所有产品信息集合
	 * @return
	 */
	public List<Product> findAll();
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	
	
}
