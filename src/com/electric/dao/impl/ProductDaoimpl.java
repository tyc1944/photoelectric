package com.electric.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.ProductDao;
import com.electric.entity.Product;

/**
 * 产品链接数据库类
 * @author hgf
 * 2021年6月8日
 */
public class ProductDaoimpl implements ProductDao{
	
	/**
	 * 把给定的产品信息对象添加到数据库中
	 * @param product
	 * @return
	 */
	public boolean saveProduct(Product product) {
		String sql="insert into tbl_product(title,content,pic,typeId) values(?,?,?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(product.getTitle());
		paramList.add(product.getContent());
		paramList.add(product.getPic());
		paramList.add(product.getTypeId());
		
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 按照给定的产品信息对象修改数据库中该产品的信息
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product) {
		String sql="update tbl_product set title=?,content=?,pic=?,postTime=?,typeId=? where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(product.getTitle());
		paramList.add(product.getContent());
		paramList.add(product.getPic());
		paramList.add(product.getPostTime());
		paramList.add(product.getTypeId());
		paramList.add(product.getProId());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键主键删除数据库中该产品的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteProduct(int id) {
		String sql="delete from tbl_product where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据给定的主键获取该主键对应的产品信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public Product findById(int id) {
		List<Product> list=new ArrayList<>();
		String sql="select * from tbl_product where proId=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		list=findList(sql,paramList);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	
	/**
	 * 获取所有产品信息集合
	 * @return
	 */
	public List<Product> findAll(){
		String sql="select * from tbl_product order by postTime desc";
		return findList(sql,null);
	}
	
	/**
	 * 根据给定的sql语句和参数获取列表
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<Product>  findList(String sql,List<Object> paramList){
		List<Product>  productList=new ArrayList<>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql,paramList);
		 int proId;
		 String title;
		 String content;
		 String pic;
		 Timestamp postTime;
		 int typeId;
		try {
			while(resultSet.next()) {
				proId=resultSet.getInt("proId");
				title=resultSet.getString("title");
				content=resultSet.getString("content");
				pic=resultSet.getString("pic");
				postTime=resultSet.getTimestamp("postTime");
				typeId=resultSet.getInt("typeId");
				//把每一条数据库表中的记录封装成一个Product对象
				Product product=new Product(proId, title, content, pic, postTime, typeId);
				productList.add(product);//把封装的对象放入到集合中
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
		return productList;
	}
	
}
