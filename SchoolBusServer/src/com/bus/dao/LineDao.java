package com.bus.dao;

import java.util.List;

import com.bus.model.Line;

public interface LineDao {
	public List<Line> seekAllLine();
	public String seekAllSiteById(int id);
	public List<Line> seekLineByParentId(int parentId);
}
