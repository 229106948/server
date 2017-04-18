package com.bus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.bus.daoimpl.StudentDaoImpl;
import com.bus.model.Student;
import com.bus.tool.GsonUtil;

public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String function = request.getParameter("function");
		if ("parentId".equals(function)) {
			int parentId = Integer.valueOf(request.getParameter("parentId"));
			List<Student> students = studentDaoImpl.seekStudentByParentId(
					function, parentId);
			if (students != null) {
				JSONArray json = JSONArray.fromObject(students);
				response.getWriter().print(json.toString());
			} else {
				response.getWriter().print("");
			}

		} else if ("lineId".equals(function)) {
			int lineId = Integer.valueOf(request.getParameter("lineId"));
			List<Student> students = studentDaoImpl.seekStudentByParentId(
					function, lineId);
			if (students != null) {
				JSONArray json = JSONArray.fromObject(students);
				response.getWriter().print(json.toString());
			}
		} else if ("addChild".equals(function)) {
			String json = request.getParameter("student");
			Student student = GsonUtil.changeJsonToStudent(json);
			boolean result = studentDaoImpl.addChild(student);
			response.getWriter().print(String.valueOf(result));

		} else {

			String data = request.getParameter("data");
			String aboardSite = request.getParameter("aboardSite");
			String debusSite = request.getParameter("debusSite");
			int id = Integer.valueOf(request.getParameter("id"));
			if (aboardSite != null) {
				studentDaoImpl.updateChild("aboardSite", aboardSite, id);
			}
			if (debusSite != null) {
				studentDaoImpl.updateChild("debusSite", debusSite, id);
			}
			if ("lineId".equals(function) || "advanceSite".equals(function)) {
				int value = Integer.valueOf(data);
				studentDaoImpl.updateChild(function, value, id);
			} else {
				studentDaoImpl.updateChild(function, data, id);
			}
		}

	}

}
