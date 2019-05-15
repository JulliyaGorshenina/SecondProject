package testgi;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MarketPage;
import pages.SearchPage;

public class YandexTest extends BaseTest{

    protected static SearchPage searchPage;
    protected static MarketPage marketPage;

    @BeforeClass
    public void beforeTest(){
        searchPage = PageFactory.initElements(driver,SearchPage.class);
        marketPage = PageFactory.initElements(driver,MarketPage.class);
    }

    @Test
    public void SearchTest() {
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
        marketPage.Search("Планшет");
        marketPage.getResult();
        Assert.assertTrue(marketPage.getResult().contains("планшет"));
    }
}

