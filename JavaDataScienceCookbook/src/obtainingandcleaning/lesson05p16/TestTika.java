package obtainingandcleaning.lesson05p16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class TestTika {

	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson05/testPDF.pdf";

	public static void main(String[] args) {
		TestTika tika = new TestTika();
		tika.convertPDF(PATH);
	}

	private void convertPDF(String path) {
		InputStream stream = null;
		try {
			stream = new FileInputStream(path);
			AutoDetectParser parser = new AutoDetectParser();
			BodyContentHandler handler = new BodyContentHandler(-1);
			Metadata metadata = new Metadata();
			parser.parse(stream, handler, metadata, new ParseContext());
			System.out.println(handler.toString());
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException");
			e.printStackTrace();
		} catch (SAXException e) {
			System.err.println("SAXException");
			e.printStackTrace();
		} catch (TikaException e) {
			System.err.println("TikaException");
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
