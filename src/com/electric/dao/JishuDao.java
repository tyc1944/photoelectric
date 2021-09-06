package com.electric.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.electric.entity.Jishu;



public interface JishuDao {

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Jishu> findAll();
	
	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Jishu findById(int id) ;
	
	
	
	
	/**
	 * 添加产品对象
	 * @param jishu
	 * @return
	 */
	public boolean savejishu(Jishu jishu);
	
	/**
	 * 修改产品对象
	 * @param jishu
	 * @return
	 */
	public boolean updatejishu(Jishu jishu) ;
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletejishu(int id) ;
}
