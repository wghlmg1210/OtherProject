package com.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * 
 * @author Mr.Huang
 * 
 */
public class ReflectUtil {

	/**
	 * 通过字段信息获取字段值
	 * 
	 * @param field
	 *            字段信息
	 * @param t
	 *            字段所属类实例
	 * @return
	 */
	public static <T> Object getValue(Field field, T t) {
		String fieldName = field.getName();
		String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
		try {
			Method method = t.getClass().getDeclaredMethod(methodName);
			return method.invoke(t);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
