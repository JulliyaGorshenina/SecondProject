package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage {

    private By SearchFild = By.id("header-search");
    private By SearchButton = By.cssSelector("[type='submit']");
    private By FirstResult = By.cssSelector("div h1");

    private final WebDriver driver;

    public MarketPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElement(By locator){
        (new WebDriverWait(driver, 10))
                .until (ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void Search (String text){
        waitForElement(SearchFild);
        driver.findElement(SearchFild).sendKeys(text);
        driver.findElement(SearchButton).click();
    }

    public String getResult(){
        return driver.findElement(FirstResult).getText();
    }
}
