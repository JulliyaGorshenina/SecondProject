package testgi;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MarketPage;
import pages.SearchPage;

public class YandexTest extends BaseTest{

    @Test
    public void SearchTest(){
        driver.get("https://yandex.ru");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.Search("Погода Пенза");
        searchPage.getResult();
        Assert.assertTrue(searchPage.getResult().contains("Пензе"));
    }

    @Test
    public void TabletSearch(){
        driver.get("https://market.yandex.ru/");
        MarketPage marketPage = new MarketPage(driver);
        marketPage.Search1("Планшет");
        marketPage.getResult1();
        Assert.assertTrue(marketPage.getResult1().contains("планшет"));
    }
}

