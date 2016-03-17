package com.thread.gun;

public class GunClip {

	private int num;

	public synchronized void put(int i) throws InterruptedException {
		if (num <= 0) {
			System.out.println(i+"子弹上膛" + ++num);
			notify();
		}else{
			System.out.println(i+"有子弹，等待上膛 ");
			wait();	
		}
	}

	public synchronized void get() {
		
		if (num <= 0) {
			try {	
				System.out.println("无子弹，等待出趟 ");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("子弹出膛" + --num);
			notify();
		}
		
	}
}