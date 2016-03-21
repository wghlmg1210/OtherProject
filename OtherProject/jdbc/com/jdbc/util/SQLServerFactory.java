package com.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.common.util.ResourceUtil;

public class SQLServerFactory implements JDBCFactory {

	private static Properties proes = null;

	private static final String DRIVERCLASSNAME = "driverName";
	
	protected static final String RESOURCE = "sqlserver.properties";

	static {
		initProes();
		try {
			Class.forName(proes.getProperty(DRIVERCLASSNAME));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void initProes() {
		proes = new Properties();
		InputStream input = ResourceUtil.loadResource(RESOURCE);
		try {
			proes.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SQLServerUtil getInstance() {
		return SQLServerUtil.getInstance(proes);
	}

}
