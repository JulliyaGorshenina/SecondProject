package testgi;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MarketPage;

public class MarketSearchTest extends BaseTest {

    @Test
    public void TabletSearch(){
        driver.get("https://market.yandex.ru/");
        MarketPage marketPage = new MarketPage(driver);
        marketPage.Search("Планшеты");
        marketPage.scrollToButton();
        marketPage.selectChoice();
        int i = driver.findElements(By.cssSelector("div[class='price']")).size();
        Assert.assertEquals(i,12);
        marketPage.allResult();
        int b = driver.findElements(By.cssSelector("div[class='price']")).size();
        Assert.assertEquals(b,48);
    }

    @Test
    public void SortPrice(){
        driver.get("https://market.yandex.ru/");
        MarketPage marketPage = new MarketPage(driver);
        marketPage.Search("Планшеты");
        marketPage.Filter();
        Assert.assertTrue(marketPage.FilterCheckOne());
        Assert.assertTrue(marketPage.FilterCheckSecond());
    }

    @Test
    public void  IconPresent() {
        driver.get("https://market.yandex.ru/");
        MarketPage marketPage = new MarketPage(driver);
        marketPage.Search("Планшеты");
        marketPage.Filter();
        Assert.assertTrue(marketPage.isElementPresent());
    }

}
