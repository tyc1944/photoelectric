package com.electric.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.dao.ContactDao;
import com.electric.entity.Contact;

public class ContactDaoimpl implements ContactDao {

	/**
	 * 查询所有产品
	 * 
	 * @return
	 */
	public List<Contact> findAll() {
		String sql = "select * from contact";
		return findList(sql, null);
	}

	/**
	 * 根据主键获取产品对象
	 * 
	 * @param id
	 * @return
	 */
	public Contact findById(int id) {
		String sql = "select * from contact where proId=" + id;
		List<Contact> list = findList(sql, null);
		return list != null && list.size() > 0 ? list.get(0) : null;

	}

	/**
	 * 根据sql语句和参数列表查询产品列表
	 * 
	 * @param sql
	 * @param paramList
	 * @return
	 */
	private List<Contact> findList(String sql, List<Object> paramList) {
		List<Contact> list = new ArrayList<Contact>();
		ResultSet resultSet = ConnectionManager.executeQuery(sql, paramList);
		try {
			int proId;
			String gsmc;
			String gsdz;
			String youbian;
			String kfdh;
			String chuanzhen;
			String shouji;
			String lianxiren;
			String msn;
			String qq;
			String swyx;
			String kfyx;
			String gswz;
			while (resultSet.next()) {
				proId = resultSet.getInt("proId");
				gsmc = resultSet.getString("gsmc");
				gsdz = resultSet.getString("gsdz");
				youbian = resultSet.getString("youbian");
				kfdh = resultSet.getString("kfdh");
				chuanzhen = resultSet.getString("chuanzhen");
				shouji = resultSet.getString("shouji");
				lianxiren = resultSet.getString("lianxiren");
				msn = resultSet.getString("msn");
				qq = resultSet.getString("qq");
				swyx = resultSet.getString("swyx");
				kfyx = resultSet.getString("kfyx");
				gswz = resultSet.getString("gswz");
				Contact contact = new Contact(proId, gsmc, gsdz, youbian, kfdh, chuanzhen, shouji, lianxiren, msn, qq,
						swyx, kfyx, gswz);
				list.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectionManager.closeAll(resultSet, resultSet.getStatement(),
						resultSet.getStatement().getConnection());
			} catch (SQLException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 添加产品对象
	 * 
	 * @param contact
	 * @return
	 */
//	public boolean savecontact(contact contact) {
//		String sql="insert into contact(title,pic,content,typeId) values(?,?,?,?)";
//		List<Object> paramList=new ArrayList<>();
//		paramList.add(contact.getTitle());
//		paramList.add(contact.getPic());
//		paramList.add(contact.getContent());
//		paramList.add(contact.getTypeId());
//		return ConnectionManager.executeUpdate(sql, paramList);
//	}

	/**
	 * 修改产品对象
	 * 
	 * @param contact
	 * @return
	 */
	public boolean updatecontact(Contact contact) {
		String sql = "update contact set  gsmc=?, gsdz=?, youbian=?, kfdh=?,chuanzhen=?,shouji=?,lianxiren=?,msn=?,qq=?,swyx=?,kfyx=?, gswz=?where proId=?";
		List<Object> paramList = new ArrayList<>();
		paramList.add(contact.getGsmc());
		paramList.add(contact.getGsdz());
		paramList.add(contact.getYoubian());
		paramList.add(contact.getKfdh());
		paramList.add(contact.getChuanzhen());
		paramList.add(contact.getShouji());
		paramList.add(contact.getLianxiren());
		paramList.add(contact.getMsn());
		paramList.add(contact.getQq());
		paramList.add(contact.getSwyx());
		paramList.add(contact.getKfyx());
		paramList.add(contact.getGswz());
		paramList.add(contact.getProId());
		return ConnectionManager.executeUpdate(sql, paramList);
	}

	/**
	 * 根据主键删除产品对象
	 * 
	 * @param id
	 * @return
	 */
	public boolean deletecontact(int id) {
		String sql = "delete from  contact  where proId=?";
		List<Object> paramList = new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql, paramList);
	}
}
