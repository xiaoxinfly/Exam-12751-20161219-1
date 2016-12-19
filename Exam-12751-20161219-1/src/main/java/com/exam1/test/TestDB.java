package com.exam1.test;

import java.sql.Connection;

import com.exam1.util.DBUtil;

public class TestDB {

	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection();
		if(connection!=null){
			System.out.println("连接成功");
		}
	}

}
