package TestNG_framwork;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test_Rywh {
	private WebDriver driver;
	private String baseUrl;
	private String uid ;
	private String old_window;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new InternetExplorerDriver();
		baseUrl = "http://127.0.0.1:8040/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void Login() throws Exception {

		driver.get(baseUrl); 

		driver.findElement(By.name("imageField")).click();

		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void Search() throws Exception {

		driver.switchTo().frame(1);

		driver.findElement(By.id("ri2")).click(); 

		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
		driver.findElement(By.id("select-key:useruuid")).sendKeys("zhangsan8421"); 

		driver.findElement(By.name("select-key_submit")).click(); 

	}

	@Test(priority=3)
	public String Add() throws Exception {
		
		driver.findElement(By.name("record_record_addRecord")).click(); 

	    old_window = driver.getWindowHandle();

		for (int a = 0; a <= 9; a++) { 

			Set<String> windowHandles = driver.getWindowHandles();

			for (String handler : windowHandles) { // 循环2
				System.out.println(handler);
				driver.switchTo().window(handler); // 尝试切换
				String title = driver.getTitle();
				if ("增加人员维护".equals(title)) {
					a = 10;
					break; 
				}
			}
		}

		System.out.println(driver.getTitle());

		String uid = "testfan" + getRandom(99999);
		driver.findElement(By.id("record:useruuid")).sendKeys(uid);
		driver.findElement(By.id("record:name")).sendKeys("testfan");
		driver.findElement(By.id("record:department")).sendKeys("test");

		Select sel_role = new Select(driver.findElement(By.id("record:roleuuid")));
		Select sel_abili = new Select(driver.findElement(By.id("record:ability")));

		sel_role.selectByIndex(2);
		sel_abili.selectByIndex(1);

		driver.findElement(By.name("record_record_saveAndExit")).click();
		
		Thread.sleep(1000);

		
		return uid;
	}
	
@Test(priority=4)
	 public void Delete() throws Exception {

		driver.switchTo().window(old_window); 
		driver.switchTo().frame(3);

		driver.findElement(By.id("select-key:useruuid")).clear();
		driver.findElement(By.id("select-key:useruuid")).sendKeys(uid); 

		driver.findElement(By.name("select-key_submit")).click(); 

		driver.findElement(By.name("record:_flag")).click();
		driver.findElement(By.name("record_record_deleteRecord")).click();

		driver.switchTo().alert().accept();

		Thread.sleep(1000); 
		driver.switchTo().alert().accept();
	}
	

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit(); 
	}

	public static int getRandom(int max) throws Exception {
		return ((int) (Math.random() * max) + 1); 
	}

}
