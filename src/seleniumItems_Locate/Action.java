package seleniumItems_Locate;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.text.DateFormat;

public class Action {
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	/*1、 Qunar机票搜索场景

	1) 访问Qunar机票首页http://flight.qunar.com，选择“单程”，输入出发、到达城市，
	选择today+7日后的日期，
	        点“搜索”，跳转到机票单程搜索列表页。
	2) 在列表页停留1分钟，至到页面上出现“搜索结束”。
	3) 如果出现航班列表，对于出现“每段航班均需缴纳税费”的行随机点选“订票”按钮，
	         在展开的列表中会出现“第一程”、 “第二程”；对于没有出现“每段航班均需缴纳税费”的行随机点选“订票”按钮，
	         在展开的列表底部中会出现“报价范围”
	4) 如果不出现航班列表，则页面会出现“该航线当前无可售航班”*/

	@Test
	 public void Qunar() throws Exception{
		//--------1----------------------
		driver.get("https://flight.qunar.com/");
		driver.findElement(By.id("searchTypeSng")).click();
		
		driver.findElement(By.name("fromCity")).clear();
		driver.findElement(By.name("fromCity")).sendKeys("北京");
		
		driver.findElement(By.name("toCity")).clear();
		driver.findElement(By.name("toCity")).sendKeys("上海");
		
		Date now = new Date();
	    DateFormat d = DateFormat.getDateTimeInstance(); 
	    String str = d.format(now)+7; 
	    
	    driver.findElement(By.id("fromDate")).clear();
		driver.findElement(By.id("fromDate")).sendKeys(str);
		
		driver.findElement(By.className("btn_search")).click();
		
		Thread.sleep(10000);
		List<WebElement> FlightList = driver.findElements(By.xpath("//div[contains(@class,'b-airfly')]"));
	    Random Num = new Random();
	    int random = Num.nextInt(FlightList.size()-1);
	    
	    driver.findElement(By.xpath("//div[@class='m-airfly-lst']/div["+random+"]"));
	}

    @AfterClass
    public void afterClass() throws Exception {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
