package testcases.Basic;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.DriverSetup;

public class BasicTest extends DriverSetup {


    BasePage page=new BasePage();

    @Test
    public void openSite(){
        getDriver().get("https://www.banglashoppers.com/");
    }

    @Test
    public void locateWithWebdriverWait(){
        getDriver().get("https://www.banglashoppers.com/");
        getDriver().findElement(By.xpath("//lala"));
    }
}
