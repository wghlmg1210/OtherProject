package com.thread.gun;

public class Producer extends Thread {

	private GunClip clip;

	Producer(GunClip clip) {
		this.clip = clip;
	}

	public void run() {
		synchronized (clip) {
			for (int i = 1; i < 4; i++) {
				try {
					clip.load(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}