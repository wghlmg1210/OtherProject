package com.execption;

public class NoAnnotationExecption extends IllegalArgumentException {

	private String message = null;

	private static final long serialVersionUID = -4875908751975980842L;
	
	public NoAnnotationExecption(Class<?> clazz) {
		this.message = "类" + clazz.getName() + "没有映射到数据库表中";
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
