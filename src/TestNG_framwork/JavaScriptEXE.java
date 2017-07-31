package TestNG_framwork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class JavaScriptEXE {
    private WebDriver driver;
    
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void Operate() throws Exception {
        driver.get("file:///C:/TestFolder/css.html");

        //List<WebElement> inputs = driver.findElements(By.cssSelector("input~input"));
        //System.out.println(inputs.size());
        //w.sendKeys("test");

        //driver.findElement(By.cssSelector("ul:nth-of-type(3)"));
        //System.out.println(driver.findElement(By.cssSelector("li:nth-of-type(2)")).getText());	
        //System.out.println(driver.findElement(By.cssSelector("li:nth-of-type(3)")).getText());
        //System.out.println(driver.findElement(By.cssSelector("li:nth-child(4)")).getText());
    }

    @Test
    public void JavaScriptOperate() throws Exception {
        driver.get("https://www.zuche.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //js.executeScript("document.getElementById('fromDate').setAttribute('value','2013-06-21');");

        //change read-only to false
        js.executeScript("document.getElementById('fromDate').readonly=false");
        //set date value
        //js.executeScript("document.getElementById('fromDate').setAttribute('value','2013-06-21');");

        //update body content
        //js.executeScript("document.body.innerHTML='ABCDEFG'");

        //equal_effection
        js.executeScript("arguments[0].click();",
            driver.findElement(By.id("fromDate")));

        //js.executeScript("driver.findElement(By.id(\"fromDate\")).sendKeys(\"test\");");
    }

    @AfterClass
    public void afterClass() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
