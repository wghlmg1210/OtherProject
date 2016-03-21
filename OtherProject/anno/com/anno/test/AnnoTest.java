package com.anno.test;

import com.anno.entity.User;
import com.jdbc.util.JDBCUtil;
import com.jdbc.util.SQLServerFactory;

public class AnnoTest {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("huangxb");
		user.setAge(12);
		JDBCUtil jdbcUtil = SQLServerFactory.getInstance();
		String sql = jdbcUtil.query(user);
		System.out.println(sql);
	}

}
