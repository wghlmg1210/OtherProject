package com.thread.test1;

public class ThreadTest {

	public static void main(String[] args) {
		LowerThread lower = new LowerThread();
		UpperThread upper = new UpperThread();
		lower.start();
		new Thread(upper).start();
	}
	
}
