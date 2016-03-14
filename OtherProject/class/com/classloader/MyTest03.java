package com.classloader;

import java.util.Random;

class FinalStatic {

	/** A的值在编译期间就已经被确定了，
	 * 所以直接的调用并不需要对这个类进行初始化操作，
	 * 所以不会输出静态代码块中的内容 */
//	public static final int A = 4 + 4;

	/** A的值在编译器不能被确定，
	 * 只有到初始化操作接受才能确定这个值，
	 * 所以会输出静态代码块中的内容 */
	public static final int A = 4 + new Random().nextInt(10);

	static {
		System.out.println("如果执行了，证明类初始化了……");
	}
}

public class MyTest03 {
	public static void main(String[] args) {
		System.out.println(FinalStatic.A);
	}
}