package com.exam1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBUtil {

	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet resultSet;

	/**
	 * 得到JDBC连接
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/sakila?verifyServerCertificate=false&useSSL=true", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 不传值查询
	public static ResultSet query(String sql) {
		resultSet = null;
		connection = getConnection();
		try {
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	// 传值查询
	public static ResultSet query(String sql, List<Object> list) {
		resultSet = null;
		connection = getConnection();
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 1; i <= list.size(); i++) {
				ps.setObject(i, list.get(i - 1));
			}
			resultSet = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	// 更新或者添加
	public static int update(String sql, List<Object> list) {
		int result = 0;
		Connection conn= getConnection();
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 1; i <= list.size(); i++) {
				ps.setObject(i, list.get(i - 1));
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 删除（根据表的ID）
	public static boolean delete(String sql, int id) {
		boolean result = false;
		connection = getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setObject(1, id);
			result = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void close() throws SQLException {
		resultSet.close();
		ps.close();
		connection.close();
	}

}
