package testcases.Login;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class LoginTestData {


    @DataProvider(name="generalExpectedFontProperties")
    public Object[][] getGeneralFontCSS(){
        Map<String, String> expectedStyles = new HashMap<>();
        expectedStyles.put("font-style", "normal");
        expectedStyles.put("font-weight", "400");
        expectedStyles.put("text-align", "left");
        Object[][] data={{expectedStyles}};
        return data;
    }

    @DataProvider(name="generalExpectedFontPropertiesCenter")
    public Object[][] getGeneralFontCSSCenter(){
        Map<String, String> expectedStyles = new HashMap<>();
        expectedStyles.put("font-style", "normal");
        expectedStyles.put("font-weight", "400");
        expectedStyles.put("text-align", "center");
        Object[][] data={{expectedStyles}};
        return data;
    }


    @DataProvider(name="invalidAndBlankLoginData")
    public Object[][] getInvalidAndBlankLoginCredentials(){

        Object[][] data={{"frotesting#gmail.com","123"},{"frotesting#gmail.com",""},{"",""},{"","123"},{"","FroTesting123$$$"},
                {"frotesting",""},{"frotesting","123"}, {"frotesting","FroTesting123$$$"}};

        return data;

    }
}
