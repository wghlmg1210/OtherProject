package myself.regex;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;

import org.junit.Test;

import com.common.util.StreamUtil;

public class Regex_Test {

	Pattern pattern = Pattern.compile("'Name':'([^']*)','Val':'([^']*)'",
			Pattern.CASE_INSENSITIVE);
	@Test
	public void parseByRegx() {
		InputStream input = Regex_Test.class.getResourceAsStream("string.txt");
		try {
			String content = StreamUtil.readContent(input);
			Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {
				System.out.println(matcher.group(1) + ":" + matcher.group(2));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMnte() throws IOException {
		Pattern pattern = Pattern.compile("Children\\\\?\":(\\[([^\\]]*)\\])", Pattern.CASE_INSENSITIVE);
		InputStream input = Regex_Test.class.getResourceAsStream("string.txt");
		String content = StreamUtil.readContent(input);
		System.out.println(content);
		Matcher matcher = pattern.matcher(content);
		System.out.println(pattern.pattern());
		while(matcher.find()) {
			content = matcher.group(1).replaceAll("\\\\", "");
			System.out.println(content);
			JSONArray jsona = JSONArray.fromString(content);
			content = jsona.toString();
		}
		StationMnte mnte = new StationMnte();
		mnte.setInfoByContent(content);
		System.out.println(mnte);
	}

}
