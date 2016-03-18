package com.synchronize;

class Computation implements Runnable {
	private int result;

	public Computation() {
	}

	public void run() {
		countprint(this.result);
	}

	public synchronized void countprint(int result) {
		result = result + 2;
		System.out.println(result + " ");
	}
}

public class TestComputation {
	public static void main(String args[]) {
		Runnable target = new Computation();
		new Thread(target).start();
		new Thread(target).start();
		new Thread(target).start();
		new Thread(target).start();
	}
}