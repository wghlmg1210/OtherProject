package com.execption;

public class NoAnnotationExecption extends IllegalArgumentException {

	private String message = null;

	private static final long serialVersionUID = -4875908751975980842L;
	
	public NoAnnotationExecption(Class<?> clazz) {
		this.message = "��" + clazz.getName() + "û��ӳ�䵽���ݿ����";
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
