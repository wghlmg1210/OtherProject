package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.anno.entity.User;
import com.anno.parse.AnnoParse;

public class SQLServerUtil implements JDBCUtil {

	private static SQLServerUtil sqlServerUtil = null;

	private static Properties proes = null;

	private static final String URL = "url";
	private static final String USER = "user";
	private static final String PASSWORD = "password";

	/** 注解解析类 */
	private AnnoParse annoParse = new AnnoParse();

	private SQLServerUtil() {
	}

	public static SQLServerUtil getInstance(Properties proes) {
		SQLServerUtil.proes = proes;
		if (sqlServerUtil == null) {
			sqlServerUtil = new SQLServerUtil();
		}
		return sqlServerUtil;
	}

	public String query(User user) {
		return annoParse.parse(user);
	}

	/**
	 * 查询单条记录的结果
	 * 
	 * @param sql
	 * @return
	 */
	@Override
	public Map<String, Object> queryForMap(String sql) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement preState = null;
		ResultSet result = null;
		try {
			conn = openConnection();
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			ResultSetMetaData resultMetaData = result.getMetaData();
			int columnNum = resultMetaData.getColumnCount();
			result.next();
			while (--columnNum >= 0)
				resultMap.put(resultMetaData.getColumnName(columnNum),
						result.getString(columnNum));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, preState, result);
		}
		return resultMap;
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Map<String, Object> resultMap = null;
		Connection conn = null;
		PreparedStatement preState = null;
		ResultSet result = null;
		try {
			conn = openConnection();
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			ResultSetMetaData resultMetaData = result.getMetaData();
			int columnNum = resultMetaData.getColumnCount();
			while (result.next()) {
				resultMap = new HashMap<String, Object>();
				String columnName = null;
				int currentColumn = columnNum;
				while (currentColumn > 0) {
					columnName = resultMetaData.getColumnName(currentColumn--);
					resultMap.put(columnName, result.getString(columnName));
				}
				resultList.add(resultMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(conn, preState, result);
		}
		return resultList;
	}

	/**
	 * 关闭资源
	 * 
	 * @param conn
	 * @param preState
	 * @param result
	 */
	private void closeResource(Connection conn, PreparedStatement preState,
			ResultSet result) {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preState != null) {
			try {
				preState.close();
				preState = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (result != null) {
			try {
				result.close();
				result = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(proes.getProperty(URL),
				proes.getProperty(USER), proes.getProperty(PASSWORD));
	}
}
