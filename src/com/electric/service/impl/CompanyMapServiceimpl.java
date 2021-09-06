package com.electric.service.impl;

import java.util.List;

import com.electric.dao.CompanyMapDao;
import com.electric.dao.impl.CompanyMapDaoimpl;
import com.electric.entity.Companymap;
import com.electric.service.CompanyMapService;


public class CompanyMapServiceimpl implements CompanyMapService{
	private CompanyMapDao companyMapDao=new CompanyMapDaoimpl();
	/**
	 * 把给定的新闻类型信息对象添加到数据库中
	 * @param companymap
	 * @return
	 */
	public boolean savecompanymap(Companymap companymap) {
		return companyMapDao.savecompanymap(companymap);
	}
	
	/**
	 * 按照给定的新闻类型信息对象修改数据库中该新闻类型的信息
	 * @param companymap
	 * @return
	 */
	public boolean updatecompanymap(Companymap companymap) {
		return companyMapDao.updatecompanymap(companymap);
	}
	
	/**
	 * 根据给定的主键主键删除数据库中该新闻类型的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deletecompanymap(int id) {
		return companyMapDao.deletecompanymap(id);
	}
	
	/**
	 * 根据给定的主键获取该主键对应的新闻类型信息对象，如果主键不存在返回null
	 * @param stuNo
	 * @return
	 */
	public Companymap findById(int id) {
		return companyMapDao.findById(id);
	}
	
	
	/**
	 * 获取所有新闻类型信息集合
	 * @return
	 */
	public List<Companymap> findAll(){
		return companyMapDao.findAll();
	}
	
	
	
}
