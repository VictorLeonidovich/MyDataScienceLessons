package obtainingandcleaning.lesson06p19;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CleaningData {
	public static void main(String[] args) throws UnsupportedEncodingException {
		CleaningData cleaningData = new CleaningData();
		byte [] bytes = ((char)1 + "\tYour text here                 you have got from some\t file \u0020 \u0000").getBytes();
		String text = null;
		text = new String(bytes);
		String cleanedText = cleaningData.cleanText(text);
		System.out.println(cleanedText);
	}

	private String cleanText(String text) {
		int i = 0;
		System.out.println(i++ + text);
		text = text.replaceAll("[^\\p{ASCII}]", ""); //1 strips off non-ASCII characters
		System.out.println(i++ + text);
		text = text.replaceAll("[^\\p{Print}]", ""); //2 strips off the ASCII non-printable characters
		System.out.println(i++ + text);
		text = text.replaceAll("[\\p{Cntrl}]", ""); //3 erases all the ASCII control characters
		System.out.println(i++ + text);
		text = text.replaceAll("\\s+", " "); //4 replaces continuous white spaces with a single white space
		System.out.println(i++ + text);
		text = text.replaceAll("[\\p{C}]", ""); //5 removes non-printable characters from Unicode
		System.out.println(i++ + text);
		return text;
	}
}
