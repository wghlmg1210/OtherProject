package designPattern.proxy.jar;

public class Person implements Sleepable {

	@Override
	public void sleep() {
		System.out.println("sleep....");
	}

}
