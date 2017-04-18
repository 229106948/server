package com.bus.model;

import java.util.List;

public class LineShow {
    private int id;
    private int driverId;
    private List<Site> allSite;

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

    public List<Site> getAllSite() {
        return allSite;
    }

    public void setAllSite(List<Site> allSite) {
        this.allSite = allSite;
    }

    public LineShow(int id, int driverId, List<Site> allSite) {

        this.id = id;
        this.driverId = driverId;
        this.allSite = allSite;
    }
    
}
