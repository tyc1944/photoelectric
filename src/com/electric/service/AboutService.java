package com.electric.service;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.AboutDao;
import com.electric.entity.About;
import com.electric.entity.Jishu;
import com.electric.entity.Page;






public interface AboutService {

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<About> findAll();
	
	public List<About> findPageList(Page page);
	
	

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public About findById(int id) ;
	

	/**
	 * 添加产品对象
	 * @param about
	 * @return
	 */
	public boolean saveabout(About about) ;
	
	
	
	/**
	 * 修改产品对象
	 * @param about
	 * @return
	 */
	public boolean updateabout(About about);
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteabout(int id) ;
	
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
