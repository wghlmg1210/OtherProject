package designPattern.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import designPattern.proxy.jar.Person;
import designPattern.proxy.jar.Sleepable;

public class ProxyTest {

	@Test
	public void test1() {
		Person person = new Person();
		person.sleep();
	}

	@Test
	public void test2() {
		Person person = new Person();
		PersonHandler handler = new PersonHandler(person);
		Sleepable proxyPerson = (Sleepable) Proxy.newProxyInstance(person
				.getClass().getClassLoader(),
				person.getClass().getInterfaces(), handler);
		proxyPerson.sleep();
	}

}
