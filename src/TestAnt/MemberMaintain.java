package TestAnt;

import org.testng.annotations.Test;

import mx4j.log.Log;
import java.util.Set;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;


public class MemberMaintain {
	
	private WebDriver driver;
	private String baseUrl;
	private static String string = "abcdefghijklmnopqrstuvwxyz";
	private String userid;

  @BeforeClass
  public void beforeClass() {
		driver = new InternetExplorerDriver();
		baseUrl = "http://127.0.0.1:8040/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
  }

  @Test(priority=1)
  public void Login() {
  driver.get(baseUrl);
		driver.findElement(By.id("imageField")).click();
		Assert.assertEquals("欢迎使用开发平台", driver.getTitle());
  }
  
  @Test(priority=2)
  public void Add(){
	    driver.switchTo().frame("code").findElement(By.xpath("//*[@id='2']/td/span/span")).click();
		driver.switchTo().defaultContent();
		
	    driver.switchTo().frame("main").findElement(By.name("record_record_addRecord")).click();
		driver.switchTo().defaultContent();

		String currentWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = driver.switchTo().window(handle);
			Log.getLogger("title,url = " + (window).getTitle() + "," + window.getCurrentUrl());

			WebElement W = driver.findElement(By.id("record:useruuid"));
			userid = getRandomString(5);
			W.sendKeys(userid);

			driver.findElement(By.name("record:name")).sendKeys("HongZhou");
			driver.findElement(By.name("record:department")).sendKeys("TEST");

			WebElement S = driver.findElement(By.name("record:roleuuid"));
			org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(S);
			select.selectByIndex(1);

			WebElement S2 = driver.findElement(By.name("record:ability"));
			org.openqa.selenium.support.ui.Select select2 = new org.openqa.selenium.support.ui.Select(S2);
			select2.selectByIndex(1);

			WebElement S3 = driver.findElement(By.name("record:sex"));
			org.openqa.selenium.support.ui.Select select3 = new org.openqa.selenium.support.ui.Select(S3);
			select3.selectByIndex(3);

			driver.findElement(By.name("record:phone")).sendKeys("123");
			driver.findElement(By.name("record:mobile")).sendKeys("456");
			driver.findElement(By.name("record:email")).sendKeys("789");
			driver.findElement(By.name("record:jobyear")).sendKeys("4");
			driver.findElement(By.name("record:memo")).sendKeys("555555555555");

			driver.findElement(By.name("record_record_saveAndExit")).click();
			driver.switchTo().window(currentWindow);
		}
  }
  
  @Test(priority=3)
  public void Search() {
	    driver.switchTo().frame("main").findElement(By.id("select-key:useruuid")).clear();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main").findElement(By.id("select-key:useruuid")).sendKeys(userid);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main").findElement(By.name("select-key_submit")).click();
		driver.switchTo().defaultContent();
  }
  
  @Test(priority=4)
  public void Update() {
		driver.switchTo().frame("main").findElement(By.name("record:_flag")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main").findElement(By.name("record_record_updateRecord")).click();
		driver.switchTo().defaultContent();

		String currentWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = driver.switchTo().window(handle);
			Log.getLogger("title,url = " + (window).getTitle() + "," + window.getCurrentUrl());
		}

		driver.findElement(By.name("record:memo")).sendKeys("555555555555" + "\n" + "66666666666");
		driver.findElement(By.name("record_record_saveAndExit")).click();
		driver.switchTo().window(currentWindow);
  }
  
  @Test(priority=5)
  public void Delete() throws Exception {
	    driver.switchTo().defaultContent();
		driver.switchTo().frame("main").findElement(By.name("record_record_deleteRecord")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);

		alert = driver.switchTo().alert();
		alert.accept();
  } 
  
	private static int getRandom(int count) {
		return ((int) Math.round(Math.random() * count));
	}

	private static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(getRandom(len - 1)));
		}
		return (sb.toString());
	}
  
	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
