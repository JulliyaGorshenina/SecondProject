package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketPage {

    private By SearchFild = By.id("header-search");
    private By SearchButton = By.cssSelector("[type='submit']");
    private By FirstResult = By.cssSelector("div h1");

    private final WebDriver driver;

    public MarketPage(WebDriver driver){
        this.driver = driver;
    }

    public void Search1 (String text){
        driver.findElement(SearchFild).sendKeys(text);
        driver.findElement(SearchButton).click();
    }

    public String getResult1(){
        return driver.findElement(FirstResult).getText();
    }
}
