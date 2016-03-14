package designPattern.strategy;

import java.util.regex.Pattern;

public class ConcreteStrategy implements Strategy {

	private Pattern pattern;

	ConcreteStrategy(String regex) {
		pattern = Pattern.compile(regex);
	}

	@Override
	public boolean justify(File subFile) {
		return pattern.matcher(subFile.getName()).matches();
	}

}
