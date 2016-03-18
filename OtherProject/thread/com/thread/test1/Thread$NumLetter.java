package com.thread.test1;

public class Thread$NumLetter {

	static Integer i = 0;

	public static void main(String[] args) {
		Thread t1 = new Num();
		Thread t2 = new Letter();
		t1.start();
		t2.start();
	}
	
}

class Num extends Thread {

	private int num = 1;

	@Override
	public void run() {
		synchronized (Thread$NumLetter.i) {
			while (num < 52) {
				int count = 0;
				while (count++ < 2) {
					System.out.print(num++);
				}
				try {
					Thread$NumLetter.i.notify();
					Thread$NumLetter.i.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count = 0;
			}
			Thread$NumLetter.i.notify();
		}
	}

}

class Letter extends Thread {

	private char letter = 'A';

	@Override
	public void run() {
		synchronized (Thread$NumLetter.i) {
			while (letter <= 'Z') {
				System.out.println(letter++);
				try {
					Thread$NumLetter.i.notify();
					Thread$NumLetter.i.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
