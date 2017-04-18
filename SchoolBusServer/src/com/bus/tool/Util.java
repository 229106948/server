package com.bus.tool;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static List<String> parseSite(String site) {
		char[] array = site.toCharArray();
		List<String> sites = new ArrayList<String>();
		String s = "";
		for (int i = 0; i < array.length; i++) {
			if (',' != array[i]) {
				s += array[i];
			} else {
				sites.add(s);
				s = "";
			}
		}
		return sites;
	}
	public List<Integer> getNewList(List<Integer> li){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<li.size(); i++){
            int str = li.get(i);  //获取传入集合对象的每一个元素
            if(!list.contains(str)){   //查看新集合中是否有指定的元素，如果没有则加入
                list.add(str);
            }
        }
        return list;  //返回集合
    }
	
    private static double EARTH_RADIUS = 6378.137;    
    
    private static double rad(double d) {    
        return d * Math.PI / 180.0;    
    }    
    
    /**   
     * 通过经纬度获取距离(单位：米)   
     * @param lat1   
     * @param lng1   
     * @param lat2   
     * @param lng2   
     * @return   
     */    
    public static double getDistance(double lat1, double lng1, double lat2,    
                                     double lng2) {    
        double radLat1 = rad(lat1);    
        double radLat2 = rad(lat2);    
        double a = radLat1 - radLat2;    
        double b = rad(lng1) - rad(lng2);    
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
                + Math.cos(radLat1) * Math.cos(radLat2)    
                * Math.pow(Math.sin(b / 2), 2)));    
        s = s * EARTH_RADIUS;    
        s = Math.round(s * 10000d) / 10000d;    
        s = s*1000;    
        return s;    
    }    
}
