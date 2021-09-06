package com.electric.service.impl;


import java.util.List;

import com.electric.dao.UserDao;
import com.electric.dao.impl.UserDaoimpl;
import com.electric.entity.Page;
import com.electric.entity.User;
import com.electric.service.UserService;

public class UserServiceimpl implements UserService{

	UserDao userDao=new UserDaoimpl();
	
	public User checkUser(String uname,String upass) {
		List<User> allUser=userDao.findAll();
		User user=null;
		for(User u:allUser) {
			if(uname.equals(u.getUname()) &&upass.equals(u.getUpass())) {
				user=u;
				break;
			}
		}
		return user;
	}
	public List<User> findPageList(Page page){
		List<User> allList;
			allList=userDao.findAll();
		int fromIndex=(page.getPageNo()-1)*page.getPageSize();
		int toIndex=page.getPageNo()*page.getPageSize();
		if(toIndex>allList.size())
			toIndex=allList.size();
		return allList.subList(fromIndex, toIndex);
	}
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	
	

	/**
	 * 根据主键获取产品对象
	 * @param id
	 * @return
	 */
	public User findById(int id) {
		return userDao.findById(id);
	}
	

	/**
	 * 添加产品对象
	 * @param product
	 * @return
	 */
	public boolean saveUser(User product) {
		return userDao.saveUser(product);
	}
	
	
	
	/**
	 * 修改产品对象
	 * @param product
	 * @return
	 */
	public boolean updateUser(User product) {
		return userDao.updateUser(product);
	}
	
	/**
	 * 根据主键删除产品对象
	 * @param id
	 * @return
	 */
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	
	/**
	 * 根据主键删除新闻对象
	 * @param id
	 * @return
	 */
	public boolean deleteMany(String uIds) {
		boolean flag=true;
		String[] ids=uIds.split(",");
		for(int i=0;i<ids.length;i++) {
			flag=flag&userDao.deleteUser(Integer.parseInt(ids[i]));
		}
		return flag;
	}
}
