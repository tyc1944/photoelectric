package com.electric.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.ProductTypeDao;
import com.electric.entity.ProductType;


public class ProductTypeDaoimpl implements ProductTypeDao{
	
	/**
	 * 把给定的产品类型信息对象添加到数据库中
	 * @param productType
	 * @return
	 */
	public boolean saveProductType(ProductType productType) {
		String sql="insert into tbl_productType(typeName) values(?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(productType.getTypeName());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 按照给定的产品类型信息对象修改数据库中该产品类型的信息
	 * @param productType
	 * @return
	 */
	public boolean updateProductType(ProductType productType) {
		String sql="update tbl_productType set typeName=? where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(productType.getTypeName());
		paramList.add(productType.getTypeId());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键主键删除数据库中该产品类型的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteProductType(int id) {
		String sql="delete from tbl_productType where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键获取该主键对应的产品类型信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public ProductType findById(int id) {
		List<ProductType> list=new ArrayList<>();
		String sql="select * from tbl_productType where typeId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		list=findList(sql,paramList);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	
	/**
	 * 获取所有产品类型信息集合
	 * @return
	 */
	public List<ProductType> findAll(){
		String sql="select * from tbl_productType";
		return findList(sql,null);
	}
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<ProductType>  findList(String sql,List<Object> paramList){
		List<ProductType>  productTypeList=new ArrayList<>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql,paramList);
		 int typeId;
		 String typeName;
		try {
			while(resultSet.next()) {
				typeId=resultSet.getInt("typeId");
				typeName=resultSet.getString("typeName");
				//把每一条数据库表中的记录封装成一个ProductType对象
				ProductType productType=new ProductType(typeId,typeName);
				productTypeList.add(productType);//把封装的对象放入到集合中
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
		return productTypeList;
	}
	
}
