package testData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainTestData {

    public static final String mainTestDataJsonPath = "src/test/resources/testData/testData.json";

    @JsonProperty("text1")
    public String text;
    @JsonProperty("name1")
    public String name;
}
