package obtainingandcleaning.lesson07p20;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class TestUnivosity {
	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson07/testCSV.csv";

	public static void main(String[] args) {
		TestUnivosity test = new TestUnivosity();
		test.parseCSV(PATH);

	}

	@SuppressWarnings("deprecation")
	private void parseCSV(String path) {
		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setLineSeparatorDetectionEnabled(true);
		RowListProcessor rowProcessor = new RowListProcessor();
		parserSettings.setRowProcessor(rowProcessor);
		parserSettings.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(new File(path));

		String[] headers = rowProcessor.getHeaders();// If you have parsed the headers
		List<String[]> rows = rowProcessor.getRows();
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(Arrays.asList(rows.get(i)));
		}
	}

}
