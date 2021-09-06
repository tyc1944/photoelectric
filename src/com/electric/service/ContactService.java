package com.electric.service;

import java.util.ArrayList;
import java.util.List;

import com.electric.dao.ContactDao;
import com.electric.entity.Contact;
import com.electric.entity.Jishu;
import com.electric.entity.Page;






public interface ContactService {

	/**
	 * 查询所有产品
	 * @return
	 */
	public List<Contact> findAll();
	
	
	public List<Contact> findPageList(Page page);
	
	public boolean deleteMany(String proIds) ;

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public Contact findById(int id);
	

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
	public boolean updatecontact(Contact contact);
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deletecontact(int id);
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deletecontact(String ids);

	/**
	 * 根据产品类型编号获取该类型下的所有产品列表
	 * @param typeId
	 * @return
	 */

	
}
