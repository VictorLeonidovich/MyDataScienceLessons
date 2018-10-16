package obtainingandcleaning.lesson08p23;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class TestTSV {
	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson08/testTSV.csv";

	public static void main(String[] args) {
		TsvParserSettings settings = new TsvParserSettings();
		settings.getFormat().setLineSeparator("\n");
		TsvParser parser = new TsvParser(settings);
		List<String[]> allRows = parser.parseAll(new File(PATH));
		for (int i = 0; i < allRows.size(); i++) {
			System.out.println(Arrays.asList(allRows.get(i)));
		}
	}

}
