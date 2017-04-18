package com.bus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.bus.daoimpl.NoticeDaoImpl;
import com.bus.model.Notice;

public class NoticeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		String function = req.getParameter("function");
		System.out.println(function);
		if ("showNotice".equals(function)) {
			int parentId = Integer.valueOf(req.getParameter("parentId"));
			NoticeDaoImpl noticeDaoImpl = new NoticeDaoImpl();
			List<Notice> noticeList = noticeDaoImpl.seekNoticeByDriverId(parentId);
			JSONArray jsonArray=JSONArray.fromObject(noticeList);
			resp.getWriter().print(jsonArray.toString());
		}
		

	}

}
