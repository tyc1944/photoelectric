package com.electric.service.impl;

import java.util.List;

import com.electric.dao.ContactDao;
import com.electric.dao.impl.ContactDaoimpl;
import com.electric.entity.Contact;
import com.electric.entity.Page;
import com.electric.service.ContactService;






public class ContactServiceimpl implements ContactService{
	
	ContactDao ContactDao=new ContactDaoimpl();
	
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Contact> findAll(){
		return ContactDao.findAll();
	}
	
	
	public List<Contact> findPageList(Page page){
		List<Contact> allList;
		allList=ContactDao.findAll();
		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	
	public boolean deleteMany(String proIds) {
		boolean flag=true;
		String[] ids=proIds.split(",");
		for(int i=0;i<ids.length;i++) {
			flag=flag&ContactDao.deletecontact(Integer.parseInt(ids[i]));
		}
		return flag;
	}

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Contact findById(int id) {
		return ContactDao.findById(id);
	}
	

	/**
	 * 添加产品对象
	 * @param contact
	 * @return
	 */
//	public boolean savecontact(contact contact) {
//		return ContactDao.savecontact(contact);
//	}
//	
	
	
	/**
	 * 修改产品对象
	 * @param contact
	 * @return
	 */
	public boolean updatecontact(Contact contact) {
		return ContactDao.updatecontact(contact);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletecontact(int id) {
		return ContactDao.deletecontact(id);
	}
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deletecontact(String ids) {
		boolean flag=true;
		String []proIds=ids.split(",");
		for(String proId:proIds) {
			flag=flag&ContactDao.deletecontact(Integer.parseInt(proId));
		}
		return flag;
	}

	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
