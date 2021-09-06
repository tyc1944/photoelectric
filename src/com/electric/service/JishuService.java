package com.electric.service;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.JishuDao;
import com.electric.entity.Jishu;
import com.electric.entity.News;
import com.electric.entity.Page;






public interface JishuService {
	

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Jishu> findAll();
	
	public List<Jishu> findPageList(Page page);
	
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Jishu findById(int id);

	/**
	 * 添加产品对象
	 * @param jishu
	 * @return
	 */
	public boolean savejishu(Jishu jishu) ;
	
	
	
	/**
	 * 修改产品对象
	 * @param jishu
	 * @return
	 */
	public boolean updatejishu(Jishu jishu);
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletejishu(int id);
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deleteMany(String proIds);

	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
