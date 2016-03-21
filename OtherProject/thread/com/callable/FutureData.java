package com.callable;

public class FutureData<T> implements Data<T> {

	private boolean isReady = false;

	private T t;

	@Override
	public synchronized T getResult() {
		try {
			if (!isReady) {
				this.wait();
			}
			return t;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public synchronized void setResult(T t) {
		if (isReady) {
			return;
		}
		this.t = t;
		this.isReady = true;
		this.notifyAll();
	}

}
