package com.bus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.bus.daoimpl.ParentDaoImpl;
import com.bus.model.Parent;
import com.bus.tool.GsonUtil;

public class ParentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ParentDaoImpl parentDaoImpl = new ParentDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String function = request.getParameter("function");
		System.out.println(function);
		if ("login".equals(function)) {
			String telephone = request.getParameter("telephone");
			String password = request.getParameter("password");

			Parent parent = parentDaoImpl.seekParentByPassword(telephone,
					password);
			JSONObject json = JSONObject.fromObject(parent);
			response.getWriter().print(json);
		} else if ("register".equals(function)) {
			String parent = request.getParameter("parent");
			Parent mParent = GsonUtil.changeJsonToParent(parent);
			boolean result;
			if (parentDaoImpl.seekParentByTelephone(mParent.getTelephone()) != null) {
				result = false;
			} else {
				result = parentDaoImpl.addParent(mParent);
			}
			System.out.println(result);
			response.getWriter().print(result);
		} else if ("password".equals(function)) {
			String telephone = request.getParameter("telephone");
			String password = request.getParameter("password");
			boolean result;
			if (parentDaoImpl.seekParentByTelephone(telephone) == null) {
				result = false;
			} else {
				result = parentDaoImpl.updatePassword(telephone, password);
			}
			System.out.println(result);
			response.getWriter().print(result);
		}

	}

}
