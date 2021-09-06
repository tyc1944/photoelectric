package com.electric.service;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.PingzhiDao;
import com.electric.entity.Jishu;
import com.electric.entity.Page;
import com.electric.entity.Pingzhi;






public interface PingzhiService {
	

	
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Pingzhi> findAll();
	
	public List<Pingzhi> findPageList(Page page);
	
	

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Pingzhi findById(int id);
	

	/**
	 * 添加产品对象
	 * @param pingzhi
	 * @return
	 */
	public boolean savepingzhi(Pingzhi pingzhi) ;
	
	
	
	/**
	 * 修改产品对象
	 * @param pingzhi
	 * @return
	 */
	public boolean updatepingzhi(Pingzhi pingzhi);
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletepingzhi(int id) ;
	
	public boolean deleteMany(String proIds);

	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
