package testgi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class YandexTest {
    WebDriver driver;

    @BeforeClass
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
        driver =new ChromeDriver();
    }

    @Test
    public void SearchTest(){
        driver.get("https://yandex.ru");
        driver.findElement(By.id("text")).sendKeys("Погода Пенза");
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[accesskey=\"1\"]")).getText().contains("Пензе"));
    }

    @AfterClass
    public void EndTest(){
        driver.quit();
    }

}
