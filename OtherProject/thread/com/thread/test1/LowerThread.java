package com.thread.test1;

public class LowerThread extends Thread {

	@Override
	public void run() {

		char i = 'a';
		while (i <= 'z') {
			System.out.println(this.getName() + " : " + i++);
		}

	}

}
