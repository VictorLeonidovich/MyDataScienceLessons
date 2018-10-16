package obtainingandcleaning.lesson09p25;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class TestJdom {
	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson09/xmldummy.xml";

	public static void main(String[] args) {
		TestJdom test = new TestJdom();
		test.parseXML(PATH);
	}

	private void parseXML(String path) {
		SAXBuilder builder = new SAXBuilder();
		File file = new File(path);
		try {
			Document document = builder.build(file);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren("author");
			for (int i = 0; i < list.size(); i++) {
				Element node = list.get(i);
				System.out.println("First name: " + node.getChildText("firstname"));
				System.out.println("Last name: " + node.getChildText("lastname"));
			}
		} catch (JDOMException e) {
			System.err.println("JDOMException");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException");
			e.printStackTrace();
		}

	}

}
