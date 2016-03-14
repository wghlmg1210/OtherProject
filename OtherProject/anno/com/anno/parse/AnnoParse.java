package com.anno.parse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.anno.anno.Column;
import com.anno.anno.Table;
import com.common.util.ReflectUtil;
import com.execption.NoAnnotationExecption;
import com.jdbc.util.SQLUtil;

/**
 * 注解解析类
 * 
 * @author Mr.Huang
 * 
 */
public class AnnoParse {

	public <T> String parse(T t) {
		Class<?> clazz = t.getClass();
		String tableName = null;
		List<String> columns = new ArrayList<String>();
		List<Class<?>> columnType = new ArrayList<Class<?>>();
		List<Object> columnValue = new ArrayList<Object>();

		boolean exist = clazz.isAnnotationPresent(Table.class);
		if (!exist) {
			throw new NoAnnotationExecption(clazz);
		}
		tableName = clazz.getAnnotation(Table.class).value();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			boolean bool = field.isAnnotationPresent(Column.class);
			if (bool) {
				Object obj = ReflectUtil.getValue(field, t);
				if (obj != null
						|| (obj instanceof Integer && (Integer) obj != 0)) {
					columns.add(field.getAnnotation(Column.class).value());
					columnType.add(field.getType());
					columnValue.add(obj);
				}
			}
		}
		return SQLUtil.assemble(tableName, columns, columnType, columnValue);
	}

}
