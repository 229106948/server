package com.bus.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bus.dao.DBFactory;
import com.bus.dao.LocationDao;
import com.bus.model.Driver;

public class LocationImpl implements LocationDao {

	public Driver seekLocationByDriverId(int driverId) {
		Driver location = null;
		String sql = "select * from driver where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(driverId);
		List<Map<String, Object>> res = DBFactory.getRs(sql, params);
		Map<String, Object> map;
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++) {
				map = res.get(i);
				int id = (Integer) map.get("id");
				String telephone = (String) map.get("telephone");
				String name = (String) map.get("name");
				float radius = (Float) map.get("radius");
				double latitude = (Double) map.get("latitude");
				double longitude = (Double) map.get("longitude");
				location = new Driver(id, telephone, name, radius, latitude,
						longitude);
			}
		}

		return location;
	}

	public List<Driver> seekLocationByParentId(int parentId) {
		List<Driver> locations = new ArrayList<Driver>();
		String sql = "select driver.id,driver.telephone,driver.name,driver.radius,driver.latitude,driver.longitude from student,line,driver where student.parentId=? and student.lineId=line.id and line.driverId=driver.id";
		List<Object> params = new ArrayList<Object>();
		params.add(parentId);
		List<Map<String, Object>> res = DBFactory.getRs(sql, params);
		Map<String, Object> map;
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++) {
				map = res.get(i);
				int id = (Integer) map.get("id");
				String telephone = (String) map.get("telephone");
				String name = (String) map.get("name");
				float radius = (Float) map.get("radius");
				double latitude = (Double) map.get("latitude");
				double longitude = (Double) map.get("longitude");
				Driver location = new Driver(id, telephone, name, radius,
						latitude, longitude);
				if (!locations.contains(location)) {
					System.out.println(locations.size());
					locations.add(location);
				}
			}
		}

		return locations;
	}

	public boolean addLocation(Driver location) {
		String sql = "update driver set radius=?,latitude=?,longitude=? where id=?";

		List<Object> params = new ArrayList<Object>();
		params.add(location.getRadius());
		params.add(location.getLatitude());
		params.add(location.getLongitude());
		params.add(location.getId());
		return DBFactory.getExec(sql, params);

	}

}
