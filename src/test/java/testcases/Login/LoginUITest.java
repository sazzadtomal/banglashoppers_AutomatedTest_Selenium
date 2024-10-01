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
        Boolean shown=loginpage.getDisplayStatus(loginpage.modal);
        Assert.assertTrue(shown);
    }

    @Test
    public void modalBackgroundColorIsValid(){
        String bg=loginpage.getElement(loginpage.modal).getCssValue("background-color");
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
       String fontFamily=loginpage.getElement(loginpage.modal).getCssValue("font-family");
       Assert.assertEquals("roboto, sans-serif",fontFamily);
    }


    @Test
    public void loginHeadingShowingProperly() {
        loginpage.validateCssProperties(loginpage.loginHeading,loginpage.getGeneralFontCSS());
        Assert.assertTrue(loginpage.validateColor(loginpage.getCSSProperty(loginpage.loginHeading,"color"),"#333"));
        Assert.assertEquals(loginpage.getElementText(loginpage.loginHeading),"Welcome! Please Login to continue.");
    }


    @Test
    public void loginSubHeadingShowingProperly() {
        loginpage.validateCssProperties(loginpage.subHeading,loginpage.getGeneralFontCSS());
        Assert.assertTrue(loginpage.validateColor(loginpage.getCSSProperty(loginpage.subHeading,"color"),"#888"));
        Assert.assertEquals(loginpage.getElementText(loginpage.subHeading),"New member? Register here.");
        Assert.assertEquals(loginpage.getElementText(loginpage.registerLink),"Register");
    }



    @Test
    public void emailFieldValidation(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.emailInput));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.emailInput,"type"),"email");
    }

    @Test
    public void emailLabelValidation(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.emailLabel));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.emailLabel,"for"),"email");
    }


    @Test
    public void passwordFieldValidation(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.passwordInput));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.passwordInput,"type"),"password");
    }


    @Test
    public void passwordLabelValidation(){
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.passwordLabel));
        Assert.assertEquals(loginpage.getAttributeText(loginpage.passwordLabel,"for"),"pass");
    }



    @Test
    public void loginButtonValidation() throws InterruptedException {
        loginpage.validateButtonSkeleton(loginpage.loginButton,loginpage.getGeneralFontCSSCenter(),"Login");
        loginpage.validateElementBackgroundColor(loginpage.loginButton,"#444");
        loginpage.validateButtonHoveringColor(loginpage.loginButton,"background-color","#333");
    }


    @Test
    public void oauthButtonValidation() throws InterruptedException {
        loginpage.validateButtonSkeleton(loginpage.googleButton,loginpage.getGeneralFontCSS(),"Google");
        loginpage.validateElementBackgroundColor(loginpage.googleButton,"#dd4b39");
        loginpage.validateButtonHoveringColor(loginpage.googleButton,"background-color","#c23321");


        loginpage.validateButtonSkeleton(loginpage.facebookButton,loginpage.getGeneralFontCSS(),"Facebook");
        loginpage.validateElementBackgroundColor(loginpage.facebookButton,"#3b5998");
        loginpage.validateButtonHoveringColor(loginpage.facebookButton,"background-color","#2d4373");
    }

    @Test
    public void forgotPasswordValidation() throws InterruptedException {
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.forgotPassword));
        Assert.assertEquals(loginpage.getElementText(loginpage.forgotPassword),"Forgot Your Password?");
        loginpage.validateButtonHoveringColor(loginpage.forgotPassword,"color","#ff384b");
    }


    @Test
    public void registerButtonValidation() throws InterruptedException {
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.registerLink));
        Assert.assertEquals(loginpage.getElementText(loginpage.registerLink),"Register");
        loginpage.validateButtonHoveringColor(loginpage.registerLink,"color","#ff384b");
    }



    @Test
    public void closeModalButtonValidation() throws InterruptedException {
          Assert.assertTrue(loginpage.getDisplayStatus(loginpage.closeModal));
          loginpage.validateElementColor(loginpage.closeModal,"#666");
          loginpage.validateElementOpacity(loginpage.closeModal,"0.65");
          loginpage.validateButtonHoveringOpacity(loginpage.closeModal,"1");
    }


}
