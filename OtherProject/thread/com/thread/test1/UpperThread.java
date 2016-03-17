package com.thread.test1;

public class UpperThread implements Runnable {

	@Override
	public void run() {

		char i = 'A';
		while (i <= 'Z') {
			System.out.println(Thread.currentThread().getName() + " : " + i++);
		}

	}

}
