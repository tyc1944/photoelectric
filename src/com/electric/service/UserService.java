package com.electric.service;

import java.util.List;
import com.electric.entity.Page;
import com.electric.entity.User;

public interface UserService {

	public User checkUser(String uname, String upass);

	public List<User> findAll();


	/**
	 * 根据主键获取产品对象
	 * 
	 * @param uid
	 * @return
	 */
	public User findById(int uid);
public List<User> findPageList(Page page);
	


	/**
	 * 添加产品对象
	 * 
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);

	/**
	 * 修改产品对象
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);

	/**
	 * 根据主键删除产品对象
	 * 
	 * @param uid
	 * @return
	 */
	public boolean deleteUser(int uid);

	/**
	 * 根据主键删除新闻对象
	 * 
	 * @param uid
	 * @return
	 */
	public boolean deleteMany(String uIds);

}
