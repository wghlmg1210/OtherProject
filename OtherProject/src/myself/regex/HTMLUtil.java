package myself.regex;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.common.util.StreamUtil;

public class HTMLUtil {

	public static void main(String[] args) throws IOException {
		InputStream input = HTMLUtil.class.getResourceAsStream("string.txt");
		String content = StreamUtil.readContent(input);
		content = content.replaceAll("[\\r\\n\\t\\s]*", "");
		String[] trContents = getTRContent(content);
		for (String tr : trContents) {
			String[] tdContents = getTdContent(tr);
			for (String td : tdContents) {
				System.out.print(filterTd(td) + " ");
			}
			System.out.println();
		}
	}

	private static String filterTd(String td) {
		Pattern pattern = Pattern.compile("<span[^>]*>([^/]+?)</span>");
		Matcher matcher = pattern.matcher(td);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return td;
	}

	private static String[] getTdContent(String tr) {
		Pattern pattern = Pattern.compile("<td[^>]*>(\\S*?)</td>");
		Matcher matcher = pattern.matcher(tr);
		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list.toArray(new String[list.size()]);
	}

	private static String[] getTRContent(String content) {
		Pattern pattern = Pattern
				.compile("<tr[^>]*>(\\S*?)</tr>");
		Matcher matcher = pattern.matcher(content);
		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group(1));
		}
		return list.toArray(new String[list.size()]);
	}

}
