package com.electric.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.PingzhiDao;
import com.electric.dao.impl.PingzhiDaoimpl;
import com.electric.entity.Pingzhi;
import com.electric.entity.Page;
import com.electric.entity.Pingzhi;
import com.electric.service.PingzhiService;






public class PingzhiServiceimpl implements PingzhiService{
	
	PingzhiDao pingzhiDao=new PingzhiDaoimpl();
	
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Pingzhi> findAll(){
		return pingzhiDao.findAll();
	}
	
	public List<Pingzhi> findPageList(Page page){
		List<Pingzhi> allList;
			allList=pingzhiDao.findAll();

		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	
	

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Pingzhi findById(int id) {
		return pingzhiDao.findById(id);
	}
	

	/**
	 * 添加产品对象
	 * @param pingzhi
	 * @return
	 */
	public boolean savepingzhi(Pingzhi pingzhi) {
		return pingzhiDao.savepingzhi(pingzhi);
	}
	
	
	
	/**
	 * 修改产品对象
	 * @param pingzhi
	 * @return
	 */
	public boolean updatepingzhi(Pingzhi pingzhi) {
		return pingzhiDao.updatepingzhi(pingzhi);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletepingzhi(int id) {
		return pingzhiDao.deletepingzhi(id);
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
			flag=flag&pingzhiDao.deletepingzhi(Integer.parseInt(ids[i]));
		}
		return flag;
	}

	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
