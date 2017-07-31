package seleniumItems_Locate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class testItems_page {
    private WebDriver driver;
    private String baseUrl;
    private String Username = "xinyuan_7625@163.com";
    private String Password = "test123";
    private String FilePath = "C:\\TestFolder\\Header.jpeg";

    @BeforeClass
    public void setUp() throws Exception {
        // driver = new FirefoxDriver();
        driver = new InternetExplorerDriver();
        // driver = new ChromeDriver();
        baseUrl = "http://www.12306.cn/mormhweb/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void GetTitles() {
        driver.get(baseUrl);

        List<WebElement> TitlesList = driver.findElements(By.xpath(
                    "//div[@class='excellent_list pc_display']//div[@class='excel_tit']"));
        System.out.print("Total Link Count:  " + TitlesList.size() + "\n");

        Iterator<WebElement> it = TitlesList.iterator();

        while (it.hasNext()) {
            WebElement w = (WebElement) it.next();
            System.out.print("Title is :  " + w.getText() + "\n");
        }
    }

    @Test(enabled = false)
    public void GetTitles2() {
        driver.get(baseUrl);

        List<WebElement> TitlesList = driver.findElements(By.xpath(
                    "//div[@class='excellent_list pc_display']//div[@class='excel_tit']"));
        System.out.print("Total Link Count:  " + TitlesList.size() + "\n");

        for (WebElement W : TitlesList) {
            System.out.print("Title is :  " + W.getText() + "\n");
        }
    }

    @Test(enabled = false)
    public void Operate() throws Exception {
        Login();
        Thread.sleep(2000);

        //uploadImage();
        //Login();//thread switch back
    }

    public void Login() throws Exception {
        driver.get("http://ask.testfan.cn/login");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Username);
        driver.findElement(By.xpath("//input[@type='password']"))
              .sendKeys(Password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        uploadImage();

        //driver.get("http://ask.testfan.cn/login");//thread switch back
    }

    public void uploadImage() throws Exception {
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']/span"))
              .click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[3]/a"))
              .click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(FilePath);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void UpdateHeader() throws Exception {
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']/span"))
              .click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[3]/a"))
              .click();
        driver.findElement(By.xpath("//div[@class='change-avatar']/button"));

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(enabled = false)
    public void ActionExe() throws Exception {
        driver.get(baseUrl);

        Actions builder = new Actions(driver);
        //builder.moveToElement(driver.findElement(By.xpath("//*[@id='shBingAppQR']"))).perform();
        //Thread.sleep(3000);
        builder.moveToElement(driver.findElement(By.xpath("//*[@id='sh_sh']")))
               .perform();
        driver.findElement(By.id("sh_shwc")).click();
        Thread.sleep(3000);

        //driver.findElement(By.xpath("//*[@id='sh_lt']")).click();
        //Thread.sleep(3000); 
    }

    @Test(enabled = false)
    public void Frametry() throws Exception {
        driver.get(baseUrl);

        WebElement webElement = driver.switchTo().frame(0)
                                      .findElement(By.className("ad_notice"));
        System.out.println(webElement.getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
    }

    @Test(enabled = false)
    public void Alert() throws Exception {
        driver.get("C:\\TestFolder\\dialogs.html");
        driver.findElement(By.id("alert")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        //alert.dismiss();
    }

    @Test(enabled = false)
    public void Confirm() throws Exception {
        driver.get("C:\\TestFolder\\dialogs.html");
        driver.findElement(By.id("confirm")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test(enabled = false)
    public void Prompt() throws Exception {
        driver.get("C:\\TestFolder\\dialogs.html");
        driver.findElement(By.id("confirm")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test(enabled = false)
    public void TableTry() throws Exception {
        driver.get("C://TestFolder//table.html");

        WebElement table = driver.findElement(By.id("myTable"));
        List<WebElement> row = table.findElements(By.tagName("tr"));
        System.out.println(row.get(1).findElement(By.tagName("th")).getText());
    }

    @Test(enabled = false)
    public void WindowHandles() throws Exception {
        driver.get("http://cn.bing.com/");
        driver.findElement(By.xpath("//*[@id='sb_help']"));

        for (int a = 0; a <= 9; a++) {
            Set<String> handles = driver.getWindowHandles();

            for (String handler : handles) {
                driver.switchTo().window(handler); //????

                String title = driver.getTitle();

                if (title.contains("??")) {
                    a = 10;

                    break; //????2
                }
            }
        }
    }

    @Test(enabled = false)
    public void SearchInIE() throws Exception {
        driver.get("http://localhost:8040");
        driver.findElement(By.id("imageField")).click();
        driver.switchTo().frame("code")
              .findElement(By.xpath("//*[@id='2']/td/span/span")).click();
        driver.findElement(By.className("menu-selected-item")).sendKeys("test");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main").findElement(By.name("select-key_submit"))
              .click();

        driver.findElement(By.name("record_record_addRecord")).click();
        driver.switchTo().defaultContent();

        driver.findElement(By.id("record:useruuid")).sendKeys("1");
        driver.findElement(By.name("record:name")).sendKeys("test3");
        driver.findElement(By.name("record:department")).sendKeys("TEST");

        WebElement S = driver.findElement(By.name("record:roleuuid"));
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(S);
        select.selectByIndex(1);

        WebElement S2 = driver.findElement(By.name("record:ability"));
        org.openqa.selenium.support.ui.Select select2 = new org.openqa.selenium.support.ui.Select(S2);
        select2.selectByIndex(1);

        WebElement S3 = driver.findElement(By.name("record:sex"));
        org.openqa.selenium.support.ui.Select select3 = new org.openqa.selenium.support.ui.Select(S3);
        select3.selectByIndex(1);

        driver.findElement(By.name("record:phone")).sendKeys("1");
        driver.findElement(By.name("record:mobile")).sendKeys("2");
        driver.findElement(By.name("record:email")).sendKeys("3");
        driver.findElement(By.name("record:jobyear")).sendKeys("4");
        driver.findElement(By.name("record:memo")).sendKeys("555555555555");

        driver.findElement(By.name("record_record_saveAndExit")).click();
    }

    @Test
    public void Select() throws Exception {
        driver.get("http://www.divcss5.com/yanshi/201308/2013080203/");

        WebElement S = driver.findElement(By.xpath("//*[@id='divselect']"));
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(S);
        select.selectByIndex(1);

        driver.findElement(By.cssSelector("#divselect cite")).click(); //?????????????
        Thread.sleep(1000); //????????????????

        driver.findElement(By.linkText("??select??")).click(); //??????
                                                               //driver.findElement(By.cssSelector("#divselect li:nth-of-type(2)")).click();//css????

        Thread.sleep(5000);
        driver.quit();
    }

    @AfterClass
    public void afterClass() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
