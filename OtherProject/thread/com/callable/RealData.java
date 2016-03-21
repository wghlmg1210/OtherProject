package com.callable;

public class RealData {

	private String data;
	
	public RealData(String data) {
		this.data = data;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return data;
	}

}
