package com.thread.gun;

public class GunClip {

	private int num;

	public synchronized void get() throws InterruptedException {
		while (num > 0) {
			System.out.println("子弹出膛1,子弹剩余" + --num);
		}
		if (num == 0) {
			System.out.println("没子弹了，请上膛");
			notify();
			wait();
		}
	}

	public synchronized void load(int i) throws InterruptedException {
		if (num == 0) {
			num += i;
			System.out.println(i + "发子弹已装弹");
		}
		while (num > 0) {
			System.out.println("子弹充足，请发射");
			notify();
			wait();
		}
	}

}