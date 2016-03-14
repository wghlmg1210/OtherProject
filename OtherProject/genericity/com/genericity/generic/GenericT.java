package com.genericity.generic;

import java.util.List;

public class GenericT<T extends List<?>> {

	private T t;

	public Class<?> addT(T t) {
		return null;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
