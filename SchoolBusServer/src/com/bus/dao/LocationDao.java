package com.bus.dao;


import com.bus.model.Driver;


public interface LocationDao {
	public Driver seekLocationByDriverId(int driverId);
	public boolean addLocation(Driver location);
}
