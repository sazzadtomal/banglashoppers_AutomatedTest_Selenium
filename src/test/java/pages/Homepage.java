package pages;

import org.openqa.selenium.By;

public class Homepage extends  BasePage{

    public String HOMEPAGE_URL="https://www.banglashoppers.com/";

    public By searchInput=By.xpath("//input[@id='search']");
    public By searchButton=By.xpath("//form[@id='search_mini_form']/div[@class='actions']/button");
    public By logo=By.xpath("//a[@title='BanglaShoppers.com']");
    public By login=By.xpath("//div[@class='customer-links']//a[@class='social-login'][normalize-space()='Login']");
    public By register=By.xpath("//div[@class='header-middle']//li[2]");

}
