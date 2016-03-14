package designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonHandler implements InvocationHandler {

	/** 被代理对象 */
	private Object target;
	
	/** 被代理对象注入 */
	public PersonHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before....");
		/** 反射调用被代理对象函数 */
		Object obj = method.invoke(this.target, args);
		System.out.println("after....");
		return obj;
	}

}
