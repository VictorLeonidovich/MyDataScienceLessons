package obtainingandcleaning.lesson04p15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class ContentReading {
	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson01/test/allFilesContent.txt";

	public static void main(String[] args) {
		File file = new File(PATH);
		try {
			String text = FileUtils.readFileToString(file, "UTF-8");
			System.out.println(text);
		} catch (IOException e) {
			System.out.println("Error reading " + file.getAbsolutePath());
		}
	}

}
