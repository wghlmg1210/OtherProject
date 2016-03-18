package com.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流读写工具类
 * 
 * @author Mr.Huang
 * 
 */
public class StreamUtil {

	public static String readContent(String fileName) throws IOException {
		return readContent(new FileInputStream(new File(fileName)), "UTF-8");
	}
	
	public static String readContent(String fileName, String encoding) throws IOException {
		return readContent(new FileInputStream(new File(fileName)), encoding);
	}
	
	public static String readContent(File file) throws IOException {
		return readContent(new FileInputStream(file), "UTF-8");
	}
	
	public static String readContent(File file, String encoding) throws IOException {
		return readContent(new FileInputStream(file), encoding);
	}
	
	public static String readContent(InputStream input) throws IOException {
		return readContent(input, "UTF-8");
	}

	/**
	 * 将input流中的内容全部读取，该函数会一次性将所有的内容读取到内存中，所以要是内容比较多，请不要使用这个函数
	 * 
	 * @param input
	 *            InputStream
	 * @param encoding
	 *            内容编码
	 * @return
	 * @throws IOException
	 */
	public static String readContent(InputStream input, String encoding)
			throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(input,
				encoding));
		StringBuffer strb = new StringBuffer();
		String str = null;
		while ((str = in.readLine()) != null) {
			strb.append(str).append("\r\n");
		}
		return strb.toString();
	}

	public static boolean copyFile(String sourceFileName, String destFileName) {
		return copyFile(new File(sourceFileName), new File(destFileName));
	}
	
	/**
	 * 文件复制
	 * 
	 * @param sourceFile
	 * @param destFile
	 * @return
	 */
	public static boolean copyFile(File sourceFile, File destFile) {
		BufferedReader buReader = null;
		BufferedWriter bufWriter = null;
		try {
			buReader = new BufferedReader(new FileReader(sourceFile));
			bufWriter = new BufferedWriter(new FileWriter(destFile));

			String s = null;
			while ((s = buReader.readLine()) != null) {
				bufWriter.write(s + "\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (buReader != null) {
				try {
					buReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufWriter != null) {
				try {
					bufWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
}
