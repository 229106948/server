package com.bus.model;

public class Line {
	private int id;
	private int driverId;
	private String allSite;
	public Line(int id, int driverId, String allSite) {
		super();
		this.id = id;
		this.driverId = driverId;
		this.allSite = allSite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getAllSite() {
		return allSite;
	}
	public void setAllSite(String allSite) {
		this.allSite = allSite;
	}
	/**
     * 重写 equals方法
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Line) {
        	Line otherUser = (Line) object;
            if (this.id == otherUser.getId()
                    && this.driverId==otherUser.getDriverId()
                    && this.allSite.equals(otherUser.getAllSite())) {
                return true;
            }
        }
        return false;
    }
	
}
