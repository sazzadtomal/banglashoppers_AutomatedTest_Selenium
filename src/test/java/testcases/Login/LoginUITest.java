package testcases.Login;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loginpage;
import utilities.DriverSetup;

import java.util.Map;

public class LoginUITest extends DriverSetup {


    private static final Logger log = LoggerFactory.getLogger(LoginUITest.class);
    Loginpage loginpage=new Loginpage();


    @BeforeMethod
    public void navigateToLogin(){
        loginpage.openLoginModal();
    }


    @Test
    public void modalIsVisible(){
        Boolean shown=loginpage.getDisplayStatus(loginpage.visibleModal);
        Assert.assertTrue(shown);
    }

    @Test
    public void modalBackgroundColor(){
        String bg=loginpage.getElement(loginpage.visibleModal).getCssValue("background-color");
        Assert.assertTrue(loginpage.validateColor(bg,"#ffffff"));
    }


    @Test
    public void backDropIsVisible(){
        Boolean shown=loginpage.getDisplayStatus(loginpage.backDrop);
        Assert.assertTrue(shown);
    }

    @Test
    @Description("Checking font is roboto")
    public void fontFamily(){
       String fontFamily=loginpage.getElement(loginpage.visibleModal).getCssValue("font-family");
       Assert.assertEquals("roboto, sans-serif",fontFamily);
    }


    @Test(dataProvider = "generalExpectedFontProperties",dataProviderClass = LoginTestData.class )
    public void loginHeading(Map<String,String> generalExpectedFontProperties) {
        loginpage.validateCssProperties(loginpage.loginHeading,generalExpectedFontProperties);
        Assert.assertTrue(loginpage.validateColor(loginpage.getCSSProperty(loginpage.loginHeading,"color"),"#333"));
        Assert.assertEquals(loginpage.getElementText(loginpage.loginHeading),"Welcome! Please Login to continue.");
    }


    @Test(dataProvider = "generalExpectedFontProperties",dataProviderClass = LoginTestData.class )
    public void loginSubHeading(Map<String,String> generalExpectedFontProperties) {
        loginpage.validateCssProperties(loginpage.subHeading, generalExpectedFontProperties);
        Assert.assertTrue(loginpage.validateColor(loginpage.getCSSProperty(loginpage.subHeading,"color"),"#888"));
        Assert.assertEquals(loginpage.getElementText(loginpage.subHeading),"New member? Register here.");
        Assert.assertEquals(loginpage.getElementText(loginpage.registerLink),"Register");
    }

    @Test
    public void emailField(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.emailInput));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.emailInput,"type"),"email");
    }

    @Test
    public void emailLabel(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.emailLabel));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.emailLabel,"for"),"email");
    }


    @Test
    public void passwordField(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.passwordInput));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.passwordInput,"type"),"password");
    }


    @Test
    public void passwordLabel(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.passwordLabel));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.passwordLabel,"for"),"pass");
    }



    @Test(dataProvider = "generalExpectedFontPropertiesCenter",dataProviderClass = LoginTestData.class )
    public void loginButton(Map<String,String> generalExpectedFontProperties) throws InterruptedException {
        loginpage.validateButtonSkeleton(loginpage.loginButton,generalExpectedFontProperties,"Login");
        loginpage.validateElementBackgroundColor(loginpage.loginButton,"#444");
        loginpage.validateButtonHoveringColor(loginpage.loginButton,"background-color","#333");
    }


    @Test(dataProvider = "generalExpectedFontProperties",dataProviderClass = LoginTestData.class )
    public void oauthButton(Map<String,String> generalExpectedFontProperties) throws InterruptedException {
        loginpage.validateButtonSkeleton(loginpage.googleButton,generalExpectedFontProperties,"Google");
        loginpage.validateElementBackgroundColor(loginpage.googleButton,"#dd4b39");
        loginpage.validateButtonHoveringColor(loginpage.googleButton,"background-color","#c23321");


        loginpage.validateButtonSkeleton(loginpage.facebookButton,generalExpectedFontProperties,"Facebook");
        loginpage.validateElementBackgroundColor(loginpage.facebookButton,"#3b5998");
        loginpage.validateButtonHoveringColor(loginpage.facebookButton,"background-color","#2d4373");
    }

    @Test
    public void forgotPassword() throws InterruptedException {
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.forgotPassword));
        Assert.assertEquals(loginpage.getElementText(loginpage.forgotPassword),"Forgot Your Password?");
        loginpage.validateButtonHoveringColor(loginpage.forgotPassword,"color","#ff384b");
    }


    @Test
    public void registerButton() throws InterruptedException {
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.registerLink));
        Assert.assertEquals(loginpage.getElementText(loginpage.registerLink),"Register");
        loginpage.validateButtonHoveringColor(loginpage.registerLink,"color","#ff384b");
    }



    @Test
    public void closeModalButton() throws InterruptedException {
          Assert.assertTrue(loginpage.getDisplayStatus(loginpage.closeModal));
          loginpage.validateElementColor(loginpage.closeModal,"#666");
          loginpage.validateElementOpacity(loginpage.closeModal,"0.65");
          loginpage.validateButtonHoveringOpacity(loginpage.closeModal,"1");
    }


}
