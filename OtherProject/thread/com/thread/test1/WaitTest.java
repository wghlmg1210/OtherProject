package com.thread.test1;

public class WaitTest {

	public static void main(String[] args) {
		try {
			new WaitTest().wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
