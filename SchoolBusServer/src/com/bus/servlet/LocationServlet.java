package com.bus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bus.daoimpl.LocationImpl;
import com.bus.model.Driver;

public class LocationServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LocationImpl locationDaoImpl = new LocationImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String function= request.getParameter("function");
		if("getDriver".equals(function)){
			int parentId = Integer.valueOf(request.getParameter("parentId"));
			List<Driver> location = locationDaoImpl.seekLocationByParentId(parentId);
			JSONArray json=JSONArray.fromObject(location);
			response.getWriter().print(json.toString());
		}else if("getLocation".equals(function)){
			int driverId = Integer.valueOf(request.getParameter("driverId"));
			Driver location = locationDaoImpl.seekLocationByDriverId(driverId);
			JSONObject json=JSONObject.fromObject(location);
			response.getWriter().print(json.toString());
		}	
		
	}

	
}
