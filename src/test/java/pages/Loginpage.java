package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class Loginpage extends BasePage {

    public By modal =By.xpath("//div[@id='sm-social-login']");
    public By backDrop=By.xpath("//div[@class='mfp-container mfp-s-ready mfp-inline-holder']");
    public By loginHeading=By.xpath("//div[normalize-space()='Welcome! Please Login to continue.']");
    public By subHeading=By.xpath("//div[@class='register-link']");
    public By registerLink=By.xpath("//a[@class='action create']");
    public By emailInput=By.xpath("//input[@id='email']");
    public By passwordInput=By.xpath("//div[@class='column-left'] //input[@id='pass']");
    public By loginButton=By.xpath("//button[@id='social-login-btn-login']");
    public By googleButton=By.xpath("//div[@class='column-right']//a[@class='btn btn-block btn-social btn-google'][normalize-space()='Google']");
    public By facebookButton=By.xpath("//div[@class='column-right']//a[@class='btn btn-block btn-social btn-facebook'][normalize-space()='Facebook']");
    public By emailLabel=By.xpath("//label[@for='email']");
    public By passwordLabel=By.xpath("//div[@class='column-left']//label[@for='pass']");
    public By forgotPassword=By.xpath("//a[@class='action remind']");
    public By closeModal=By.xpath("//button[normalize-space()='×']");
    public By myAccount=By.xpath("//div[@class='customer-links']//span[@class='dashboard'][normalize-space()='My Account']");
    public By errorHeader=By.xpath("//div[contains(text(),'Invalid login or password.')]");
    public By passwordError=By.xpath("//div[@id='pass-error']");
    public By emailError=By.xpath("//div[@id='email-error']");





    public Homepage homepage=new Homepage();


    public Map<String,String> getGeneralFontCSS (){
        Map<String, String> expectedStyles = new HashMap<>();
        expectedStyles.put("font-style", "normal");
        expectedStyles.put("font-weight", "400");
        expectedStyles.put("text-align", "left");
        return expectedStyles;
    }


    public Map<String,String> getGeneralFontCSSCenter (){
        Map<String, String> expectedStyles = new HashMap<>();
        expectedStyles.put("font-style", "normal");
        expectedStyles.put("font-weight", "400");
        expectedStyles.put("text-align", "center");
        return expectedStyles;
    }



    public void openLoginModal(){
        homepage.loadAWebPage(homepage.HOMEPAGE_URL);
        homepage.clickOnElement(homepage.login);
    }



}
