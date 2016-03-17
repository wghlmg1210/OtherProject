package com.thread.booking;

public class BookTest {

	public static int bookSum = 20;

	public static int getBookSum() {
		return bookSum;
	}

	public static void sell(int bookNum) {
		if (bookNum < 0) {
			throw new IllegalArgumentException("售票数不能为负数");
		}
		if (BookTest.bookSum - bookNum < 0) {
			System.out.println("余票不足");
		} else {
			System.out.println("订票成功");
			BookTest.bookSum -= bookNum;
		}
	}

}
