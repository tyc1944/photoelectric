package com.electric.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.ProductDao;
import com.electric.dao.impl.ProductDaoimpl;
import com.electric.entity.Page;
import com.electric.entity.ProEntity;
import com.electric.entity.Product;
import com.electric.service.ProductService;



public class ProductServiceimpl implements ProductService{
	
	ProductDao productDao=new ProductDaoimpl();
	
	public ProEntity findNewsEntityById(int id) {
		ProEntity proEntity=new ProEntity();
		List<Product> allList=productDao.findAll();
		int index=-1;
		for(int i=0;i<allList.size();i++) {
			if(allList.get(i).getProId()==id) {
				index=i;
				break;
			}
		}
		if(index!=-1) {
			proEntity.setCurNews(allList.get(index));//设置当前新闻对象
			if(index!=0) {
				proEntity.setPreNews(allList.get(index-1));//设置上一条新闻对象
			}
			if(index!=allList.size()-1) {
				proEntity.setNextNews(allList.get(index+1));
			}
		}
		return proEntity;
	}
	public List<Product> findPageList(Page page,int typeId){
		List<Product> allList;
		if(typeId==0)
			allList=productDao.findAll();
		else
			allList=findListByTypeId(typeId);
		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	
	
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Product> findAll(){
		return productDao.findAll();
	}
	
	
	
	public List<Product> findListByTypeId(int typeId){
		List<Product> allList=productDao.findAll();
		List<Product> targetList=new ArrayList<>();
		for(Product product:allList) {
			if(product.getTypeId()==typeId) {
				targetList.add(product);
			}
		}
		return targetList;
	}
	

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Product findById(int id) {
		return productDao.findById(id);
	}
	

	/**
	 * 添加产品对象
	 * @param product
	 * @return
	 */
	public boolean saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	
	
	/**
	 * 修改产品对象
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deleteMany(String proIds) {
		boolean flag=true;
		String[] ids=proIds.split(",");
		for(int i=0;i<ids.length;i++) {
			flag=flag&productDao.deleteProduct(Integer.parseInt(ids[i]));
		}
		return flag;
	}


	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
