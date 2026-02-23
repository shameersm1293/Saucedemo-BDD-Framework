package support;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestDataReader {

	public static JSONObject getData(String fileName) {
		try {
			JSONParser parser = new JSONParser();
			FileReader reader = new FileReader("src/test/java/testdata/" + fileName);
			return (JSONObject) parser.parse(reader);
		} catch (Exception e) {
			throw new RuntimeException("Failed to read test data: " + e.getMessage());
		}
	}

}
