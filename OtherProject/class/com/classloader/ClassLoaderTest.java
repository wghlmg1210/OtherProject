package com.classloader;

import java.io.InputStream;

import org.junit.Test;

public class ClassLoaderTest {

	@Test
	public void test1() {
		InputStream input = ClassLoaderTest.class.getClassLoader().getResourceAsStream("com/classloader/MyTest.class");
		System.out.println(input);
	}
	
}
