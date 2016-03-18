package com.thread.booking;

public class BookingClerk extends Thread {

	private int bookNum;

	BookingClerk(int bookNum) {
		this.bookNum = bookNum;
	}

	@Override
	public void run() {
		synchronized (BookTest.class) {
			System.out.println("余票" + BookTest.getBookSum());
			System.out.println("订票数：" + this.bookNum);
			BookTest.sell(bookNum);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new BookingClerk(i).start();
		}
	}

}
