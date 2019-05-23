package testgi;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.junit.Test;;
import pages.MarketPage;
import pages.SearchPage;

public class YandexTest extends BaseTest{


    @Test
    public void SearchTest(){
        driver.get("https://yandex.ru");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.Search("Погода Пенза");
        Assert.assertTrue(searchPage.getResult().contains("Пензе"));
    }

    @Test
    public void TabletSearch(){
        driver.get("https://market.yandex.ru/");
        MarketPage marketPage = new MarketPage(driver);
        marketPage.Search("Планшет");
        marketPage.getResult();
        Assert.assertTrue(marketPage.getResult().contains("планшет"));
    }
}

