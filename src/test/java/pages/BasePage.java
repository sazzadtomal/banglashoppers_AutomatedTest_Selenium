package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Map;

import static utilities.DriverSetup.getDriver;

public class BasePage {


    public String EMAIL_VALIDATION_REGEX="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public WebElement getElement(By locator){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickOnElement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void loadAWebPage(String url){
         getDriver().get(url);
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public Boolean getDisplayStatus(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public String getAttributeText(By locator, String attributeName){
        return getElement(locator).getAttribute(attributeName);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }


    public void addScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES))) ;
    }



    public String getCSSProperty(By locator, String cssProperty){
        return getElement(locator).getCssValue(cssProperty);
    }



    public void validateCssProperties(By locator, Map<String, String> expectedStyles) {

        WebElement element=getElement(locator);

        for (Map.Entry<String, String> style : expectedStyles.entrySet()) {
            String actualValue = element.getCssValue(style.getKey());
            Assert.assertEquals(style.getValue(), actualValue);
        }
    }

//    public void validateCssColors(WebElement element, Map<String, String> expectedStyles) {
//        for (Map.Entry<String, String> style : expectedStyles.entrySet()) {
//            String actual=Color.fromString(element.getCssValue(style.getKey())).asHex();
//            String expected=Color.fromString(style.getValue()).asHex();
//            Assert.assertEquals(actual,expected);
//        }
//    }


    public boolean validateColor(String actual, String expected) {
        return Color.fromString(actual).asHex().equalsIgnoreCase(Color.fromString(expected).asHex());
    }


    public void validateButtonSkeleton(By locator, Map<String,String> expectedStyles, String buttonText) {
        Assert.assertTrue(getDisplayStatus(locator));
        Assert.assertEquals(getElementText(locator),buttonText);
        validateCssProperties(locator,expectedStyles);
    }




    public void validateElementBackgroundColor(By locator,String color){
        String bgColor=getElement(locator).getCssValue("background-color");
        Assert.assertTrue(validateColor(bgColor,color));
    }

    public void validateElementColor(By locator,String color){
        String actialColor=getElement(locator).getCssValue("color");
        Assert.assertTrue(validateColor(actialColor,color));
    }



    public void validateElementOpacity(By locator,String opacity){
        String actualBefore=getElement(locator).getCssValue("opacity");
        Assert.assertEquals(actualBefore,opacity);

    }




    public void validateButtonHoveringColor(By locator,String typeofColor,String afterHover) throws InterruptedException {
        Actions actions=new Actions(getDriver());
        actions.moveToElement(getElement(locator)).build().perform();
        Thread.sleep(500);
        String afterHoverBg=getElement(locator).getCssValue(typeofColor);
        Assert.assertTrue(validateColor(afterHoverBg,afterHover));
    }


    public void validateButtonHoveringOpacity(By locator,String afterHover) throws InterruptedException {
        Actions actions=new Actions(getDriver());
        actions.moveToElement(getElement(locator)).build().perform();
        Thread.sleep(500);
        String actualAfter=getElement(locator).getCssValue("opacity");
        Assert.assertEquals(actualAfter,afterHover);
    }



}
