package com.bus.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bus.dao.DBFactory;
import com.bus.dao.LineDao;
import com.bus.model.Line;

public class LineDaoImpl implements LineDao {

	public List<Line> seekAllLine() {
		String sql = "select * from line";
		List<Line> lines = new ArrayList<Line>();
		List<Map<String, Object>> lineList = DBFactory.getRs(sql, null);
		Line line;
		if (lineList != null && lineList.size() > 0) {
			for (int i = 0; i < lineList.size(); i++) {
				Map<String, Object> map = lineList.get(i);
				if (map != null) {
					int id = (Integer) map.get("id");
					int driverId = (Integer) map.get("driverId");
					String allSite = (String) map.get("allSite");
					line = new Line(id, driverId, allSite);
					lines.add(line);
				}
			}
		}
		return lines;
	}

	public String seekAllSiteById(int id) {
		String sql = "select allsite from line where id= ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		List<Map<String, Object>> lineList = DBFactory.getRs(sql, params);
		String allSite = null;
		if (lineList != null && lineList.size() > 0) {
			for (int i = 0; i < lineList.size(); i++) {
				Map<String, Object> map = lineList.get(i);
				if (map != null) {
					allSite = (String) map.get("allSite");
				}
			}
		}
		return allSite;
	}

	public List<Line> seekLineByParentId(int parentId) {
		String sql = "select line.id,line.driverId,line.allSite from student,line where student.parentId=? and student.lineId=line.id";
		List<Object> params = new ArrayList<Object>();
		params.add(parentId);
		List<Map<String, Object>> lineList = DBFactory.getRs(sql, params);
		List<Line> lines = new ArrayList<Line>();
		if (lineList != null && lineList.size() > 0) {
			for (int i = 0; i < lineList.size(); i++) {
				Map<String, Object> map = lineList.get(i);
				if (map != null) {
					int id = (Integer) map.get("id");
					int driverId = (Integer) map.get("driverId");
					String allSite = (String) map.get("allSite");
					Line line = new Line(id, driverId, allSite);
					if (!lines.contains(line)) {
						lines.add(line);
					}
				}
			}
		}
		return lines;
	}

}
