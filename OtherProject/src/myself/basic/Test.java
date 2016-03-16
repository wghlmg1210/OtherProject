package myself.basic;

public class Test {
	public static void changeStr(String str) {
		str = "welcome";
	}

	public static void main(String[] args) {
		String[] str = new String[] { "100", "100.00", "100.0", "100.0000"};
		for (int j = 0; j < str.length; j++) {
			if (str[j].indexOf(".") == -1) {
				System.out.println(str[j] + ".00");
			} else {
				System.out.println(str[j]);
			}
		}
	}

}
