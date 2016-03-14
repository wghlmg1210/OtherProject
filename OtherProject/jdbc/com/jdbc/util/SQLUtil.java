package com.jdbc.util;

import java.util.List;

public class SQLUtil {

	/**
	 * 
	 * @param tableName
	 *            表名
	 * @param columns
	 *            列名
	 * @param columnType
	 *            列类型
	 * @param columnValue
	 *            列值
	 * @return
	 */
	public static String assemble(String tableName, List<String> columns,
			List<Class<?>> columnType, List<Object> columnValue) {
		StringBuilder strb = new StringBuilder();
		strb.append("select * from ").append(tableName).append(" where 1=1");
		for (int i = 0; i < columns.size(); i++) {
			// System.out.println(columnType.get(i).getName());
			if (columnValue.get(i) instanceof String) {
				strb.append(" and ").append(columns.get(i) + " = '")
						.append(columnValue.get(i)).append("'");
			} else if (columnValue.get(i) instanceof Number) {
				strb.append(" and ").append(columns.get(i) + " = ")
						.append(columnValue.get(i));
			}

		}
		return strb.toString().replaceAll("1=1\\s+and\\s+", "") + ";";
	}

}
