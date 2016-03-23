package com.jdbc.util.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jdbc.util.JDBCUtil;
import com.jdbc.util.SQLServerFactory;

public class JDBCTest {

	@Test
	public void sqlServerTest() {
		JDBCUtil jdbcUtil = SQLServerFactory.getInstance();
		String sql = "select sid from recv_type where r_decimal_digit is null and sid not in (select sid from station where sname is null or county is null) group by sid;";
		StringBuilder strb = new StringBuilder();
		List<Map<String, Object>> resultList = jdbcUtil.queryForList(sql);
		for (Map<String, Object> item : resultList) {
			strb.append(item.get("sid")).append(",");
		}
		System.out.println(strb);
	}

}
