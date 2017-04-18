package com.bus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class DBFactory {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/schoolbus";
	private static String sqlName = "root";
	private static String sqlPass = "123456";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Connection getCon() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, sqlName, sqlPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * 查询结果，返回结果集
	 */

	public static List<Map<String, Object>> getRs(String sql,
			List<Object> params) {
		ResultSet res = null;
		PreparedStatement pst = null;
		Connection conn = null;
		List<Map<String, Object>> rsall = new ArrayList<Map<String, Object>>();
		Map<String, Object> rsTree;
		try {
			conn = getCon();
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					pst.setObject(i + 1, params.get(i));
				}
			}
			res = pst.executeQuery();
			ResultSetMetaData rsmd = res.getMetaData();// 取数据库的列名
			int numberOfColumns = rsmd.getColumnCount();
			while (res.next()) {
				rsTree = new HashMap<String, Object>(numberOfColumns);// 注意要new
				for (int r = 1; r < numberOfColumns + 1; r++) {
					rsTree.put(rsmd.getColumnName(r), res.getObject(r));
				}
				rsall.add(rsTree);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeAll(conn, pst, res);
		}
		return rsall;
	}

	/*
	 * 增删改，只返回操作成功与否
	 */
	public static boolean getExec(String sql, List<Object> params) {
		PreparedStatement pst = null;
		Connection conn = null;
		int res = 0;
		try {
			conn = getCon();
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pst.setObject(i + 1, params.get(i));
			}
			res = pst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeAll(conn, pst, null);
		}
		return res > 0 ? true : false;
	}

	private static void closeAll(Connection conn, PreparedStatement prsts,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (prsts != null) {
			try {
				prsts.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
