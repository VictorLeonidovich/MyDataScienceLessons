package obtainingandcleaning.lesson03p14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ContentReading {
	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson01/test/allFilesContent.txt";

	public static void main(String[] args) {
		try (Stream<String> stream = Files.lines(Paths.get(PATH))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("Error reading " + Paths.get(PATH));
		}
		
	}

}
