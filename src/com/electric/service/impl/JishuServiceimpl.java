package com.electric.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.JishuDao;
import com.electric.dao.impl.JishuDaoimpl;
import com.electric.entity.Jishu;
import com.electric.entity.Page;
import com.electric.service.JishuService;






public class JishuServiceimpl implements JishuService{
	
	JishuDao jishuDao=new JishuDaoimpl();
	
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Jishu> findAll(){
		return jishuDao.findAll();
	}
	
	public List<Jishu> findPageList(Page page){
		List<Jishu> allList;
			allList=jishuDao.findAll();
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
	public Jishu findById(int id) {
		return jishuDao.findById(id);
	}
	

	/**
	 * 添加产品对象
	 * @param jishu
	 * @return
	 */
	public boolean savejishu(Jishu jishu) {
		return jishuDao.savejishu(jishu);
	}
	
	
	
	/**
	 * 修改产品对象
	 * @param jishu
	 * @return
	 */
	public boolean updatejishu(Jishu jishu) {
		return jishuDao.updatejishu(jishu);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletejishu(int id) {
		return jishuDao.deletejishu(id);
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
			flag=flag&jishuDao.deletejishu(Integer.parseInt(ids[i]));
		}
		return flag;
	}

	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
