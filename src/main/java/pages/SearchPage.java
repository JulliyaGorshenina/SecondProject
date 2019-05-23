package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private By SearchFild = By.id("text");
    private By SearchButton = By.cssSelector("[type='submit']");
    private By FirstLink = By.cssSelector("[accesskey='1']");

    private final WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver=driver;
    }

    public void waitForElement(By locator){
        (new WebDriverWait(driver, 10))
                .until (ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void Search(String text){
        waitForElement(SearchFild);
        driver.findElement(SearchFild).sendKeys(text);
        driver.findElement(SearchButton).click();
    }

    public String getResult(){
        return driver.findElement(FirstLink).getText();
    }

}
