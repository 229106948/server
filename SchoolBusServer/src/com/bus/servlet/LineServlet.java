package com.bus.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.bus.dao.LineDao;
import com.bus.dao.SiteDao;
import com.bus.daoimpl.LineDaoImpl;
import com.bus.daoimpl.SiteDaoImpl;
import com.bus.model.Line;
import com.bus.model.LineShow;
import com.bus.model.Site;
import com.bus.tool.Util;

public class LineServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LineDao lineDao = new LineDaoImpl();
	SiteDao siteDao = new SiteDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String function = request.getParameter("function");
		System.out.println(function);
		if ("getLine".equals(function)) {
			List<Line> lines = lineDao.seekAllLine();
			JSONArray json = JSONArray.fromObject(lines);
			response.getWriter().print(json.toString());
		} else if ("getSite".equals(function)) {
			int id = Integer.valueOf(request.getParameter("id"));
			String site = lineDao.seekAllSiteById(id);
			List<String> sites = Util.parseSite(site);
			JSONArray json = JSONArray.fromObject(sites);
			response.getWriter().print(json.toString());
		} else if ("parentId".equals(function)) {
			int parentId = Integer.valueOf(request.getParameter("parentId"));
			List<Line> lines = lineDao.seekLineByParentId(parentId);
			System.out.println("Linesize:"+lines.size());
			List<LineShow> lineShows = new ArrayList<LineShow>();
			for (int i = 0; i < lines.size(); i++) {
				List<Site> sites = siteDao.seekLineByLineId(lines.get(i)
						.getId());
				LineShow lineShow = new LineShow(lines.get(i).getId(), lines
						.get(i).getDriverId(), sites);
				lineShows.add(lineShow);
			}

			JSONArray json = JSONArray.fromObject(lineShows);
			response.getWriter().print(json.toString());
		}
	}

}
