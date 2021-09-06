package com.electric.service;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.ProductDao;
import com.electric.entity.News;
import com.electric.entity.Page;
import com.electric.entity.ProEntity;
import com.electric.entity.Product;



public interface ProductService {
	

	public ProEntity findNewsEntityById(int id);
	
	public List<Product> findPageList(Page page,int typeId);
	
	
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Product> findAll();
	
	
	
	public List<Product> findListByTypeId(int typeId);
	

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Product findById(int id);
	

	/**
	 * 添加产品对象
	 * @param product
	 * @return
	 */
	public boolean saveProduct(Product product);
	
	
	
	/**
	 * 修改产品对象
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product) ;
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteProduct(int id);
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deleteMany(String proIds) ;


	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
