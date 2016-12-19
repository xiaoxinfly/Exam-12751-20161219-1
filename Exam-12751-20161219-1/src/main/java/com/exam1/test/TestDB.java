package com.exam1.test;

import java.sql.Connection;

import com.exam1.util.DBUtil;
import com.exam1.util.SQLUitl;

public class TestDB {

	public static void main(String[] args) {
		DBUtil.delete(SQLUitl.FILM_DELETE, 1002);
	}

}
