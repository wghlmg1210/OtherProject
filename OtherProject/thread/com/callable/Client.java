package com.callable;

public class Client {

	public Data<RealData> request(final String string) {
		final FutureData<RealData> futureData = new FutureData<RealData>();

		new Thread(new Runnable() {
			@Override
			public void run() {
				// RealData的构建很慢，所以放在单独的线程中运行
				RealData realData = new RealData(string);
				futureData.setResult(realData);
			}
		}).start();

		return futureData; // 先直接返回FutureData
	}
}