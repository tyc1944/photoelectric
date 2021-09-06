package com.electric.service.impl;

import java.util.List;

import com.electric.dao.ProductTypeDao;
import com.electric.dao.impl.ProductTypeDaoimpl;
import com.electric.entity.Page;
import com.electric.entity.ProductType;
import com.electric.service.ProductTypeService;


public class ProductTypeServiceimpl implements ProductTypeService{
	
	ProductTypeDao productTypeDao=new ProductTypeDaoimpl();
	

	/**
	 * 查询所有产品类型
	 * @return
	 */
	public List<ProductType> findPageList(Page page){
		List<ProductType> allList;
		allList=productTypeDao.findAll();
		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	
	public List<ProductType> findAll(){
		return productTypeDao.findAll();
	}
	
	
	/**
	 * 根据主键获取产品类型对象
	 * @param id
	 * @return
	 */
	public ProductType findById(int id) {
		return productTypeDao.findById(id);
		
	}
	
	
	
	
	/**
	 * 添加产品类型对象
	 * @param productType
	 * @return
	 */
	public boolean saveProductType(ProductType productType) {
		return productTypeDao.saveProductType(productType);
	}
	
	/**
	 * 修改产品类型对象
	 * @param productType
	 * @return
	 */
	public boolean updateProductType(ProductType productType) {
		return productTypeDao.updateProductType(productType);
	}
	
	/**
	 * 根据主键删除产品类型对象
	 * @param id
	 * @return
	 */
	public boolean deleteProductType(int id) {
		return productTypeDao.deleteProductType(id);
	}
	
	public boolean deleteMany(String productTypeIds) {
		boolean flag=true;
		String[] ids=productTypeIds.split(",");
		for(int i=0;i<ids.length;i++) {
			flag=flag&productTypeDao.deleteProductType(Integer.parseInt(ids[i]));
		}
		return flag;
	}
}
