package com.thread.gun;

public class Producer extends Thread {
	private GunClip clip;

	Producer(GunClip clip) {
		this.clip = clip;
	}

	public void run() {
		for (int i = 0; i < 30; i++) {
			try {
				clip.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}