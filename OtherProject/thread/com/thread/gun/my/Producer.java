package com.thread.gun.my;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {
	private GunClip clip;
	private List<Integer> list;

	Producer(GunClip clip) {
		this.clip = clip;
	}

	public void run() {
		for (int i = 0; i < 3; i++) { // 让它生产3个弹夹
			list = new ArrayList();
			System.out.println("\n" + "机枪开始压入子弹：" + "\n");
			for (int j = 0; j < 12; j++) {
				list.add(j + 1);
				System.out.println("已压入第" + (j + 1) + "颗子弹");
			}
			clip.put(list);
		}
	}
}