package JD_Practice;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAction_ShoppingCart {
	private static WebDriver driver;
	private static String baseUrl;

	public static void main(String[] args) throws AWTException {
		driver=new ChromeDriver();
		baseUrl="https://www.jd.com";
		driver.get(baseUrl);
		driver.findElement(By.linkText("我的购物车")).click();

		//System.out.println(currentWindow);
		// 得到所有窗口的句柄
		String windowHandle1 = GetCurrentWindowHandle(driver);
		SwitchWindowHand(windowHandle1);
		System.out.println(windowHandle1);
		
		driver.findElement(By.linkText("登录")).click();
		
		driver.switchTo().frame("dialogIframe");
		driver.findElement(By.linkText("账户登录")).click();
		driver.findElement(By.id("loginname")).sendKeys("xinyuan_7625@163.com");
		driver.findElement(By.id("nloginpwd")).sendKeys("Smile@2017");
		driver.findElement(By.id("loginsubmit")).click();
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='item-form']//a[2]"));
//		System.out.println(list.size());
//		for(WebElement E:list){
//			System.out.println(E.getText());
//		}
		System.out.println(list.get(2).getText());
		list.get(2).click();

		driver.findElement(By.linkText("确定")).click();
	}
	
	public static String GetCurrentWindowHandle(WebDriver dr){
		return dr.getWindowHandle();
	}
	
	public static void SwitchWindowHand(String currentWindow) {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
		String handle = it.next();
		if (currentWindow.equals(handle))
			continue; //跳出当前循环
			WebDriver window = driver.switchTo().window(handle);
		}	
	}
	
}