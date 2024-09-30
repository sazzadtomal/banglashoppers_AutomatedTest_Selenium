package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetup {

    private static String browserName=System.getProperty("browser","Chrome");
    private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER=new ThreadLocal<>();


    private static void setDriver(WebDriver driver){
        THREAD_LOCAL_DRIVER.set(driver);
    }

    public static WebDriver getDriver(){
        return THREAD_LOCAL_DRIVER.get();
    }


    private WebDriver getBrowser(String name){
        if(name.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        } else if (name.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (name.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }
        throw new IllegalArgumentException("Invalid Browser Name");
    }

    @BeforeMethod
    public void openABrowser(){
        WebDriver driver=getBrowser(browserName);
        driver.manage().window().maximize();
        setDriver(driver);
    }

    @AfterMethod
    public void quitBrowser(){
        getDriver().quit();
    }




}
