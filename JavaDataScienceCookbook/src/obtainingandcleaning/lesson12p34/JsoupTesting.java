package obtainingandcleaning.lesson12p34;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTesting {
	private final static String PATH = "https://news.tut.by/world/591038.html";

	public static void main(String[] args) {
		JsoupTesting testing = new JsoupTesting();
		testing.extractDataWithJsoup(PATH);
	}

	private void extractDataWithJsoup(String path) {
		Document document = null;
		try {
			document = Jsoup.connect(path).timeout(10 * 1000).userAgent("Mozilla").ignoreHttpErrors(true).get();
		} catch (IOException e) {
			System.err.println("IOException");
			e.printStackTrace();
		}
		if (document != null) {
			String title = document.title();
			String text = document.body().text();
			System.out.println(title + "\t\t" + text);
			System.out.println();
			Elements links = document.select("a[href]");
			for (Element link : links) {
				String linkHref = link.attr("href");
				String linkText = link.text();
				String linkOuterHtml = link.outerHtml();
				String linkInnerHtml = link.html();
				System.out.println(linkHref + "\t\t" + linkText + "\t\t" + linkOuterHtml + "\t\t" + linkInnerHtml);
			}
		}

	}

}
