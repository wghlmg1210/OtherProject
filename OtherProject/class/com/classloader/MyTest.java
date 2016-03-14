package com.classloader;

class Singleton {
	public static Singleton singleton = new Singleton();
	public static int a;
	public static int b = 0;

	private Singleton() {
		a++;
		b++;
	}

	public static Singleton GetInstence() {
		return singleton;
	}
}

@SuppressWarnings("static-access")
public class MyTest {
	public static void main(String[] args) {
		Singleton mysingleton = Singleton.GetInstence();
		System.out.println(mysingleton.a);
		System.out.println(mysingleton.b);
		// 结果1，0
	}
}