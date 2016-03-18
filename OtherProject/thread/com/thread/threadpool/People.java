package com.thread.threadpool;

public class People implements Runnable {

	private String name;

	public People(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.name + "正在用餐");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
