package com.thread.test1;

public class ThreadPrint {
	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t1 = new NumberPrinter(p);
		Thread t2 = new LetterPrinter(p);
		t1.start();
		t2.start();
	}
}

class Printer {
	private int index = 1;// 设为1，方便计算3的倍数

	// 打印数字的构造方法，每打印两个数字，等待打印一个字母
	public synchronized void print(int i) {
		while (index % 3 == 0) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print(" " + i);
		index++;
		notifyAll();
	}

	// 打印字母，每打印一个字母，等待打印两个数字
	public synchronized void print(char c) {
		while (index % 3 != 0) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(" " + c);
		index++;
		notifyAll();
	}
}

class NumberPrinter extends Thread {
	private Printer p;

	public NumberPrinter(Printer p) {
		this.p = p;
	}

	public void run() {
		for (int i = 1; i <= 52; i++) {
			p.print(i);
		}
	}

}

class LetterPrinter extends Thread {
	private Printer p;

	public LetterPrinter(Printer p) {
		this.p = p;
	}

	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			p.print(c);
		}
	}
}
