package automationExcercise.Utilities;


import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;


public class JsonFileManager {
    String jsonReader;
    String jsonFilePath;

    public JsonFileManager(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(jsonFilePath));
            jsonReader = data.toJSONString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    public String getTestData(String jsonPath) {
        String testData = "";
        try {
            testData = JsonPath.read(jsonReader, jsonPath);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            Assert.fail("No results for json path: '" + jsonPath + "' in the json file: '" + this.jsonFilePath + "'");
        }
        return testData;
    }
    public int getTestDataAsInt(String jsonPath) {
        int testData = 0;
        try {
            testData = JsonPath.read(jsonReader, jsonPath);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            Assert.fail("No results for json path: '" + jsonPath + "' in the json file: '" + this.jsonFilePath + "'");
        } catch (ClassCastException e) {
            e.printStackTrace();
            Assert.fail("Value for json path: '" + jsonPath + "' is not an integer in the json file: '" + this.jsonFilePath + "'");
        }
        return testData;
    }
}