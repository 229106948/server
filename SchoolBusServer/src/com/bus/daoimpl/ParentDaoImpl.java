package com.bus.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bus.dao.DBFactory;
import com.bus.dao.ParentDao;
import com.bus.model.Parent;

public class ParentDaoImpl implements ParentDao {

	public Parent seekParentById(String id) {
		String sql = "select * from parent where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		List<Map<String, Object>> resultList = DBFactory.getRs(sql, params);
		Parent parent = null;
		if (resultList != null && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, Object> map = resultList.get(i);
				if (map != null) {
					int parentId = (Integer) map.get("id");
					String telephone = (String) map.get("telephone");
					String name = (String) map.get("name");
					String password = (String) map.get("password");
					parent = new Parent(parentId, telephone, name, password);

				}
			}
		}
		return parent;
	}
	public Parent seekParentByTelephone(String telephone) {
		String sql = "select * from parent where telephone=?";
		List<Object> params = new ArrayList<Object>();
		params.add(telephone);
		List<Map<String, Object>> resultList = DBFactory.getRs(sql, params);
		Parent parent = null;
		if (resultList != null && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, Object> map = resultList.get(i);
				if (map != null) {
					int parentId = (Integer) map.get("id");
					String mTelephone = (String) map.get("telephone");
					String name = (String) map.get("name");
					String mPassword = (String) map.get("password");
					parent = new Parent(parentId, mTelephone, name, mPassword);

				}
			}
		}
		return parent;
	}
	public boolean updatePassword(String telephone,String password) {
		String sql = "update parent set password = ? where telephone=?";
		List<Object> params = new ArrayList<Object>();
		params.add(telephone);
		params.add(password);
		
		return DBFactory.getExec(sql, params);
	}
	public Parent seekParentByPassword(String telephone, String password) {
		String sql = "select * from parent where telephone=? and password=?";
		List<Object> params = new ArrayList<Object>();
		params.add(telephone);
		params.add(password);
		List<Map<String, Object>> resultList = DBFactory.getRs(sql, params);
		Parent parent = null;
		if (resultList != null && resultList.size() > 0) {
			for (int i = 0; i < resultList.size(); i++) {
				Map<String, Object> map = resultList.get(i);
				if (map != null) {
					int parentId = (Integer) map.get("id");
					String mTelephone = (String) map.get("telephone");
					String name = (String) map.get("name");
					String mPassword = (String) map.get("password");
					parent = new Parent(parentId, mTelephone, name, mPassword);

				}
			}
		}
		return parent;
	}

	public boolean addParent(Parent parent) {

		String sql = "insert into parent(name,telephone,password) values(?,?,?)";

		List<Object> params = new ArrayList<Object>();
		params.add(parent.getName());
		params.add(parent.getTelephone());
		params.add(parent.getPassword());

		return DBFactory.getExec(sql, params);
	}

}
