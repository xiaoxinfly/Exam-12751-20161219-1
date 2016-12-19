package com.exam1.util;

/**
 * 此类用于Serlvet请求对应的操作码
 * 
 * @author yufeng.liu
 *
 */
public interface ServletUtil {
	// customer请求操作码
	final int CUSTOMER_LOGIN = 1;
	final int CUSTOMER_LOGIN_OUT = 0;

	// film请求操作码
	final int FILM_ADD = 1;
	final int FILM_DELETE = 2;
	final int FILM_UPDATE = 3;
	final int FILM_SELECT = 4;
	final int FILM_SUM = 5;
}
