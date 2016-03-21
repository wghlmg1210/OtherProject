package com.jdbc.util;

import java.util.List;
import java.util.Map;

import com.anno.entity.User;

public interface JDBCUtil {

	String query(User user);

	List<Map<String, Object>> queryForList(String sql);

	Map<String, Object> queryForMap(String sql);

}
