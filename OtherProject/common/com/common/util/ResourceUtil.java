package com.common.util;

import java.io.InputStream;

/**
 * 资源加载
 * 
 * @author Mr.Huang
 *
 */
public class ResourceUtil {

	public static InputStream loadResource(String path) {
		return ResourceUtil.class.getClassLoader().getResourceAsStream(path);
	}

}
