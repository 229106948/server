package com.bus.dao;

import java.util.List;

import com.bus.model.Site;


public interface SiteDao {
	public List<Site> seekLineByLineId(int lineId);
}
