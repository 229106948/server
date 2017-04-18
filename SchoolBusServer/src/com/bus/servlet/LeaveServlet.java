package com.bus.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.bus.daoimpl.LeaveDaoImpl;
import com.bus.model.Leave;
import com.bus.tool.GsonUtil;

public class LeaveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LeaveDaoImpl leaveDaoImpl = new LeaveDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String function=request.getParameter("function");
		if("showLeave".equals(function)){
		int parentId = Integer.valueOf(request.getParameter("parentId"));
		List<Leave> leaveList = leaveDaoImpl.seekLeaveByStudentId(parentId);
		JSONArray jsonArray=JSONArray.fromObject(leaveList);
		response.getWriter().print(jsonArray.toString());
		}else if("addLeave".equals(function)){
			String json = request.getParameter("leave");
			Leave leave = GsonUtil.changeJsonToLeave(json);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			leave.setApplyTime(df.format(new Date()));// new Date()为获取当前系统时间
			boolean result = leaveDaoImpl.addLeave(leave);
			response.getWriter().print(String.valueOf(result));
		}
	}

}
