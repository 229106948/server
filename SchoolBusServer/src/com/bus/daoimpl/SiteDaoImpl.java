package com.bus.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bus.dao.DBFactory;
import com.bus.dao.SiteDao;
import com.bus.model.Site;

public class SiteDaoImpl implements SiteDao {

	public List<Site> seekLineByLineId(int lineId) {
		String sql = "select * from site where lineId = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(lineId);
		List<Map<String, Object>> siteList = DBFactory.getRs(sql, params);
		List<Site> sites = new ArrayList<Site>();
		if (siteList != null && siteList.size() > 0) {
			for (int i = 0; i < siteList.size(); i++) {
				Map<String, Object> map = siteList.get(i);
				if (map != null) {
					int id = (Integer) map.get("id");
					int mLineId = (Integer) map.get("lineId");
					String name = (String) map.get("name");
					String aboardTime = (String) map.get("aboardTime");
					String debusTime = (String) map.get("debusTime");
					String stayTime = (String) map.get("stayTime");
					Site site = new Site(id, mLineId, name, aboardTime,
							debusTime, stayTime);
					sites.add(site);
				}
			}
		}
		return sites;

	}

}
