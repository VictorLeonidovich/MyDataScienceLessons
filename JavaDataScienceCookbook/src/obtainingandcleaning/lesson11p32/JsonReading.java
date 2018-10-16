package obtainingandcleaning.lesson11p32;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReading {
	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson11/testJSON.json";

	public static void main(String[] args) {
		JsonReading jsonReading = new JsonReading();
		jsonReading.readJson(PATH);
	}

	private void readJson(String path) {
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject) obj;
			String name = (String) jsonObject.get("book");
			System.out.println("Name: " + name);
			String author = (String) jsonObject.get("author");
			System.out.println("Author: " + author);
			JSONArray rewiews = (JSONArray) jsonObject.get("messages");
			Iterator<String> iterator = rewiews.iterator();
			while (iterator.hasNext()) {
				System.out.println("Message: " + iterator.next());
			}
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException");
			e.printStackTrace();
		} catch (ParseException e) {
			System.err.println("ParseException");
			e.printStackTrace();
		}
	}

}
