package com.exam1.util;

public class PageUtil {

	private int page;// 当前页
	private int count;// 总记录数
	private int sum;// 一次多少条

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAllpage() {
		int result = count / sum;
		if (count % sum == 0) {
			return result;
		} else {
			return result + 1;
		}
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getUpPage() {
		return page + 1;
	}

	public int getDownPage() {
		return page - 1;
	}

}
