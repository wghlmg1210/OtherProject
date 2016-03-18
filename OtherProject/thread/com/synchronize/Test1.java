package com.synchronize;

import java.io.File;

import org.junit.Test;

import com.common.util.StreamUtil;

public class Test1 {

	/**
	 * 流的读取的存储时，大比例较大的时间段，cpu处于停滞状态，io处在堵塞状态，
	 * 因为io的读取速度要比cpu要慢的多，所以在读写流的时候最好要使用多线程同时去处理别的问题， 以提高cpu的利用率
	 * 
	 * @param args
	 */
	@Test
	public void testCpu() {
		File sourceFile = new File(
				"E:\\Professional\\ProfessionalTool\\instantclient_11_2.rar");
		File destFile = new File("E:\\dest.rar");
		File destFile1 = new File("E:\\dest1.rar");
		long startTime = System.currentTimeMillis();
		// StreamUtil.copyFile(sourceFile, destFile);
		// StreamUtil.copyFile(sourceFile, destFile1);
		new FileMove(sourceFile, destFile).start();
		new FileMove(sourceFile, destFile1).start();
		System.out.println(System.currentTimeMillis() - startTime);
	}

	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				
				@Override
				public synchronized void run() {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	class FileMove extends Thread {

		private File sourceFile;

		private File destFile;

		FileMove(File sourceFile, File destFile) {
			this.sourceFile = sourceFile;
			this.destFile = destFile;
		}

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			StreamUtil.copyFile(sourceFile, destFile);
			System.out.println(System.currentTimeMillis() - startTime);
		}
	}

}
