package com.bus.dao;

import com.bus.model.Parent;

public interface ParentDao {
	public Parent seekParentById(String id);
	public boolean addParent(Parent parent);
	public Parent seekParentByPassword(String telephone,String password);
}
