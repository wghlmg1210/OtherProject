package com.thread.gun;

public class Concumer extends Thread {
	private GunClip clip;

	Concumer(GunClip clip) {
		this.clip = clip;
	}

	public void run() {
		while(true) {
			clip.get();
		}
	}
}