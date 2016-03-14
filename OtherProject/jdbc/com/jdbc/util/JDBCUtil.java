package com.jdbc.util;

import com.anno.entity.User;
import com.anno.parse.AnnoParse;

public class JDBCUtil {

	/** 注解解析类 */
	private AnnoParse annoParse = new AnnoParse();
	
	public String query(User user) {
		return annoParse.parse(user);
	}

}
