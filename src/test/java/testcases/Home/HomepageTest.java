package testcases.Home;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import utilities.DriverSetup;

public class HomepageTest extends DriverSetup {

    Homepage homepage=new Homepage();


    @BeforeMethod
    public void loadPage(){
        homepage.loadAWebPage(homepage.HOMEPAGE_URL);
    }

    @Test
    public void clickHomepageLogo(){
        homepage.clickOnElement(homepage.logo);
    }






}
