package JavaProgramEXE;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreeClasses {
	
	private static WebDriver driver;
	private static String baseUrl;

	public static void main(String[] args) throws Exception{
	    driver = new ChromeDriver();
	    baseUrl = "http://www.testfan.cn/";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
		LocateFreeClass();
	}
	
	public static void LocateFreeClass() throws Exception
	{   
		driver.get(baseUrl);
		driver.findElement(By.cssSelector("li#nav3 a")).click();
		List<WebElement> ulList = driver.findElements(By.cssSelector(".openClassBox li"));
		for(WebElement li : ulList) {
			System.out.print(li.findElement(By.className("class_top1")).getText()+ ":    ");
			System.out.print(li.findElement(By.cssSelector(".class_top5 a")).getAttribute("href")+"\n\n");
		}	
	    driver.quit();
	}

}
