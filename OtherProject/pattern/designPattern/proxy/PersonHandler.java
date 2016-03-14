package designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonHandler implements InvocationHandler {

	private Object target;
	
	public PersonHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before....");
		Object obj = method.invoke(this.target, args);
		System.out.println("after....");
		return obj;
	}

}
