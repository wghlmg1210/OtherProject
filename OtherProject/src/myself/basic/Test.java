package myself.basic;

public class Test {
	public static void changeStr(String str) {
		str = "welcome";
	}

	public static void main(String[] args) {
		String str = "1234";
		changeStr(str);
		System.out.println(str);
	}
}
