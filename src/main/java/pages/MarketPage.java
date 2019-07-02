package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MarketPage {

    private By SearchFild = By.id("header-search");
    private By SearchButton = By.cssSelector("[type='submit']");
    private By SelectButton = By.cssSelector("div[class='n-pager i-bem n-pager_js_inited'] [role='listbox']");
    private By TwelveResult = By.xpath("//span[text()='Показывать по 12']");
    private By AllResults = By.xpath("//span[text()='Показывать по 48']");
    private By PriceResult = By.cssSelector("div[class='price']");
    private By PriceFilter = By.xpath("//div[@class='n-filter-block_pos_left i-bem']//a[text()='по цене']");
    private By WaitPrice = By.cssSelector("div[class^='preload']");
    private By PresentIcon = By.cssSelector("div[class*='n-filter-sorter_sort_asc n-filter-sorter_state_select']");

    private final WebDriver driver;

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForElement(By locator) {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private void waitForElementDisappear(By locator) {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
    }

    public void Search(String text) {
        waitForElement(SearchFild);
        driver.findElement(SearchFild).sendKeys(text);
        driver.findElement(SearchButton).click();
    }

    private void scroll(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollToButton() {
        waitForElement(SelectButton);
        scroll(SelectButton);
        driver.findElement(SelectButton);
    }

    public void selectChoice() {
        driver.findElement(SelectButton).click();
        driver.findElement(TwelveResult).click();
        waitForElementDisappear(WaitPrice);
    }

    public void allResult() {
        driver.findElement(SelectButton).click();
        driver.findElement(AllResults).click();
        waitForElementDisappear(WaitPrice);
    }

    public void Filter() {
        driver.findElement(PriceFilter).click();
        waitForElementDisappear(WaitPrice);
    }

    private int convertStringToNumber(WebElement element) {
        String onlyNumeral = element.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(onlyNumeral);
    }

    public boolean FilterCheckOne() {
        List<Integer> list = new ArrayList<Integer>();
        List<WebElement> elements = driver.findElements(PriceResult);
        for (WebElement element : elements) {
            list.add(convertStringToNumber(element));
        }
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) < list.get(i - 1)) {
                   return false;
            }
        }
        return true;
    }

    public boolean FilterCheckSecond() {
        driver.findElement(PriceFilter).click();
        waitForElementDisappear(WaitPrice);
        List<Integer> list = new ArrayList<Integer>();
        List<WebElement> elements = driver.findElements(PriceResult);
        System.out.println(elements);
        for (WebElement element : elements) {
            list.add(convertStringToNumber(element));
        }
        for (int i = 1; i< list.size(); ++i) {
            if (list.get(i) > list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isElementPresent(){
        try{
            driver.findElement(PresentIcon);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

}









