package com.hbjy.lxy.model.bean;

/**
 * Created by 李小勇 on 2017/3/17.
 */

public class CityInfo {
    //"lon":120.58531,"level":2,"address":"","cityName":"","alevel":4,"lat":31.29888}
    private String lon;
    private String level;
    private String address;
    private String cityname;
    private String alevel;
    private String lat;

    public CityInfo(String lon, String level, String address, String cityname, String alevel, String lat) {
        this.lon = lon;
        this.level = level;
        this.address = address;
        this.cityname = cityname;
        this.alevel = alevel;
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAlevel() {
        return alevel;
    }

    public void setAlevel(String alevel) {
        this.alevel = alevel;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "lon='" + lon + '\'' +
                ", level='" + level + '\'' +
                ", address='" + address + '\'' +
                ", cityname='" + cityname + '\'' +
                ", alevel='" + alevel + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
