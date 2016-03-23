package com.thread.gun;

public class Concumer extends Thread {
	private GunClip clip;

	Concumer(GunClip clip) {
		this.clip = clip;
	}

	public void run() {
		while(true) {
			try {
				clip.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}