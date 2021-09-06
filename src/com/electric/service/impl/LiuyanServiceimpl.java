package com.electric.service.impl;

import java.util.List;

import com.electric.dao.LiuyanDao;
import com.electric.dao.impl.LiuyanDaoimpl;
import com.electric.entity.Liuyan;
import com.electric.entity.Page;
import com.electric.service.LiuyanService;


public class LiuyanServiceimpl implements LiuyanService{
	LiuyanDao LiuyanDao=new LiuyanDaoimpl();
	
	public List<Liuyan> findPageList(Page page){
		List<Liuyan> allList;
		allList=LiuyanDao.findAll();
		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	

	/**
	 * 把给定的学员信息对象添加到数据库中
	 * @param Liuyan
	 * @return
	 */
	public boolean saveLiuyan(Liuyan Liuyan) {
		return LiuyanDao.saveLiuyan(Liuyan);
	}
	
	/**
	 * 按照给定的学员信息对象修改数据库中该学员的信息
	 * @param Liuyan
	 * @return
	 */
	public boolean updateLiuyan(Liuyan Liuyan) {
		return LiuyanDao.updateLiuyan(Liuyan);
	}
	
	/**
	 * 根据给定的学号主键删除数据库中该学员的信息
	 * @param stuNo
	 * @return 成功删除返回true,否则返回false
	 */
	public boolean deleteLiuyan(int Id) {
		return LiuyanDao.deleteLiuyan(Id);
	}
	
	public boolean deleteMany(String Ids) {
		boolean flag=true;
		String[] ids=Ids.split(",");
		for(int i=0;i<ids.length;i++) {
			flag=flag&LiuyanDao.deleteLiuyan(Integer.parseInt(ids[i]));
		}
		return flag;
	}
	/**
	 * 根据给定的学号获取该学号对应的学员信息对象，如果学号不存在返回null
	 * @param stuNo
	 * @return
	 */
	public Liuyan findById(int Id) {
		return LiuyanDao.findById(Id);
	}
	
	
	/**
	 * 获取所有学员信息集合
	 * @return
	 */
	public List<Liuyan> findAll(){
		return LiuyanDao.findAll();
	}
}
