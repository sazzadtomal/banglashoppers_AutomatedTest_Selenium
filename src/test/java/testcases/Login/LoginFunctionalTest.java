package testcases.Login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loginpage;
import utilities.DriverSetup;

import java.util.regex.Pattern;

public class LoginFunctionalTest extends DriverSetup {

    Loginpage loginpage=new Loginpage();


    @BeforeMethod
    public void navigateToLogin(){
        loginpage.openLoginModal();
    }



    //both valid but registered and unregistered
    @Test
    public void loginWithRegisteredEmailAndCorrectPassword(){
        loginpage.getElement(loginpage.emailInput).sendKeys("frotesting@gmail.com");
        loginpage.getElement(loginpage.passwordInput).sendKeys("FroTesting123$$$");
        loginpage.clickOnElement(loginpage.loginButton);
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.myAccount));
    }

    @Test
    public void loginWithUnregisteredButValidCredentials(){
        loginpage.getElement(loginpage.emailInput).sendKeys("frotestingnotregistered@gmail.com");
        loginpage.getElement(loginpage.passwordInput).sendKeys("FroTesting123$$$");
        loginpage.clickOnElement(loginpage.loginButton);
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.errorHeader));
    }

    @Test
    public void loginWithRegisteredEmailButWrongPassword(){
        loginpage.getElement(loginpage.emailInput).sendKeys("frotesting@gmail.com");
        loginpage.getElement(loginpage.passwordInput).sendKeys("wrongpassword123$$$");
        loginpage.clickOnElement(loginpage.loginButton);
        Assert.assertTrue(loginpage.getDisplayStatus(loginpage.errorHeader));
    }



    @Test(dataProvider = "invalidAndBlankLoginData",dataProviderClass = LoginTestData.class)
    public void loginWithBlankAndInvalidCredentials(String email,String password){
        loginpage.getElement(loginpage.emailInput).sendKeys(email);
        loginpage.getElement(loginpage.passwordInput).sendKeys(password);
        loginpage.clickOnElement(loginpage.loginButton);

        int emailLength=email.length();

        if(emailLength==0){
            Assert.assertEquals(loginpage.getElementText(loginpage.emailError),"This is a required field.");
        }else if(!Pattern.matches(loginpage.EMAIL_VALIDATION_REGEX,email)){
            Assert.assertEquals(loginpage.getElementText(loginpage.emailError),"Please enter a valid email address (Ex: johndoe@domain.com).");
        }

        int passwordLength=password.length();
        if(passwordLength==0){
            Assert.assertEquals(loginpage.getElementText(loginpage.passwordError),"This is a required field.");
        }else if(passwordLength<6){
            Assert.assertEquals(loginpage.getElementText(loginpage.passwordError),"Please enter 6 or more characters. Leading and trailing spaces will be ignored.");
        }
    }



    @Test
    public void modalClosingByBackdrop() throws InterruptedException {
        loginpage.clickOnElement(loginpage.backDrop);
        Thread.sleep(1000);
        boolean shown=loginpage.getElement(loginpage.modal).isDisplayed();
        Assert.assertFalse(shown);
    }


    @Test
    public void modalClosingByCloseButton() throws InterruptedException {
        loginpage.clickOnElement(loginpage.closeModal);
        Thread.sleep(1000);
        boolean shown=loginpage.getElement(loginpage.modal).isDisplayed();
        Assert.assertFalse(shown);
    }




}
