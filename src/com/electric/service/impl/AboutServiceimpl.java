package com.electric.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.AboutDao;
import com.electric.dao.impl.AboutDaoimpl;
import com.electric.entity.About;
import com.electric.entity.Page;
import com.electric.service.AboutService;






public class AboutServiceimpl implements AboutService{
	
	private AboutDao aboutDao=new AboutDaoimpl();
	
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<About> findAll(){
		return aboutDao.findAll();
	}
	
	public List<About> findPageList(Page page){
		List<About> allList;
			allList=aboutDao.findAll();
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
	public About findById(int id) {
		return aboutDao.findById(id);
	}
	

	/**
	 * 添加产品对象
	 * @param about
	 * @return
	 */
	public boolean saveabout(About about) {
		return aboutDao.saveabout(about);
	}
	
	
	
	/**
	 * 修改产品对象
	 * @param about
	 * @return
	 */
	public boolean updateabout(About about) {
		return aboutDao.updateabout(about);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteabout(int id) {
		return aboutDao.deleteabout(id);
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
			flag=flag&aboutDao.deleteabout(Integer.parseInt(ids[i]));
		}
		return flag;
	}

	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
