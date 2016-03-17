package com.thread.gun.my;


public class Test {
	public static void main(String[] args) {
		GunClip clip = new GunClip();
		Producer p = new Producer(clip);
		Concumer c = new Concumer(clip);
		p.start();
		c.start();
	}
}