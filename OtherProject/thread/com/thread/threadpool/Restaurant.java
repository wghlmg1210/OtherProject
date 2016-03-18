package com.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant extends Thread {

	private boolean closeed;

	private int i = 0;

	private ExecutorService service = Executors.newFixedThreadPool(10);

	public void run() {
		if (this.closeed) {
			System.out.println("店面已经打样了");
			service.shutdown();
		}
		for (i = 0; i < 100; i++) {
			service.execute(new People(i + "客户"));
		}
	}

}
