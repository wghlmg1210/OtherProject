package com.xpath;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XPathExample {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {

		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse("xml/com/xpath/book.xml");

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath
				.compile("//book[author='Neal Stephenson']/title/text()");

		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}

	}

}