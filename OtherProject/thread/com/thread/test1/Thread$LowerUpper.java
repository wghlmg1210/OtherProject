package com.thread.test1;

/**
 * 线程通信协作 -- 交叉输出
 * 
 * notify函数调用之后不会直接进入等待状态，而是将当前的事情执行完之后才进入等待状态
 * 
 * @author Mr.Huang
 *
 */
public class Thread$LowerUpper {

	public static Integer i = 0;

	public static void main(String[] args) {
		LowerThread lower = new LowerThread();
		UpperThread upper = new UpperThread();
		lower.start();
		new Thread(upper).start();
	}

}

class LowerThread extends Thread {

	@Override
	public void run() {
		synchronized (Thread$LowerUpper.i) {
			char i = 'a';
			while (i <= 'z') {
				System.out.println(this.getName() + " : " + i++);
				try {
					Thread$LowerUpper.i.notify();
					Thread$LowerUpper.i.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Thread$LowerUpper.i.notify();
		}
	}

}

class UpperThread implements Runnable {

	@Override
	public void run() {
		synchronized (Thread$LowerUpper.i) {
			char i = 'A';
			while (i <= 'Z') {
				System.out.println(Thread.currentThread().getName() + " : "
						+ i++);
				try {
					Thread$LowerUpper.i.notify();
					Thread$LowerUpper.i.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
