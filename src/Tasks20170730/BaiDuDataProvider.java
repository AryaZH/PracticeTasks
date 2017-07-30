package Tasks20170730;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class BaiDuDataProvider {
    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.baidu.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "dp")
    public void f(String s) {
        driver.get(baseUrl);
        driver.findElement(By.id("kw")).sendKeys(s);
        driver.findElement(By.id("su")).click();
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            new Object[] { "selenium" },
            new Object[] { "other" },
        };
    }

    @AfterMethod
    private void afterMethod() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
