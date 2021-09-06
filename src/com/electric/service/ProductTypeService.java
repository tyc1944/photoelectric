package com.electric.service;

import java.util.List;

import com.electric.dao.ProductTypeDao;
import com.electric.entity.NewsType;
import com.electric.entity.Page;
import com.electric.entity.ProductType;


public interface ProductTypeService {
	

	/**
	 * 查询所有产品类型
	 * @return
	 */
	public List<ProductType> findPageList(Page page);
	
	public List<ProductType> findAll();
	
	
	/**
	 * 根据主键获取产品类型对象
	 * @param id
	 * @return
	 */
	public ProductType findById(int id);
	
	
	
	
	/**
	 * 添加产品类型对象
	 * @param productType
	 * @return
	 */
	public boolean saveProductType(ProductType productType);
	
	/**
	 * 修改产品类型对象
	 * @param productType
	 * @return
	 */
	public boolean updateProductType(ProductType productType);
	
	/**
	 * 根据主键删除产品类型对象
	 * @param id
	 * @return
	 */
	public boolean deleteProductType(int id);
	
	public boolean deleteMany(String productTypeIds) ;
}
