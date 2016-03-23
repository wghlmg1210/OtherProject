package myself.regex;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public void testItems() throws IOException {
		Pattern pattern = Pattern.compile(
				"\"_ItemSet\".*?items\":\\[(\\{\"Chart\".*?\\}[,]?)*?\\]",
				Pattern.CASE_INSENSITIVE);
		System.out.println(pattern.pattern());
		InputStream input = Regex_Test.class.getResourceAsStream("string.txt");
		String content = StreamUtil.readContent(input);
		System.out.println(content);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			content = matcher.group(1).replaceAll("\\\\", "");
			System.out.println(content);
		}
	}

	@Test
	public void jiake() throws IOException {
		Pattern pattern = Pattern.compile("(.+?)\\s*--\\s([\\d|.,]+)");
		InputStream input = Regex_Test.class.getResourceAsStream("file.txt");
		String content = StreamUtil.readContent(input);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String s = "insert into tbl_demo_data(data_type, sub_id, v1, v23, parent_id) values('gis_map', '"
					+ matcher.group(1)
					+ "', '', '"
					+ matcher.group(2).substring(0, matcher.group(2).length() - 1)
					+ "', '白下区');";
			// content = matcher.group(1).replaceAll("\\\\", "");
			 System.out.println(s);
		}
	}

}
