package com.electric.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.entity.ProductType;


public interface ProductTypeDao {
	
	/**
	 * 把给定的产品类型信息对象添加到数据库中
	 * @param productType
	 * @return
	 */
	public boolean saveProductType(ProductType productType) ;
	
	/**
	 * 按照给定的产品类型信息对象修改数据库中该产品类型的信息
	 * @param productType
	 * @return
	 */
	public boolean updateProductType(ProductType productType);
	
	/**
	 * 根据给定的主键主键删除数据库中该产品类型的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteProductType(int id) ;
	
	/**
	 * 根据给定的主键获取该主键对应的产品类型信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public ProductType findById(int id);
	
	
	/**
	 * 获取所有产品类型信息集合
	 * @return
	 */
	public List<ProductType> findAll();
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	
}
