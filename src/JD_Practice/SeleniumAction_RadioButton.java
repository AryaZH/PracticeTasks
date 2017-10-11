package JD_Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumAction_RadioButton {
	private static WebDriver driver;
	private static String baseUrl;

	public static void main(String[] args) {
		driver=new FirefoxDriver();
		baseUrl="http://jipiao.jd.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		PlainTravel_RadioButton(driver);
		//driver.quit();
	}
	
	public static void PlainTravel_RadioButton(WebDriver dr){
		dr.findElement(By.id("depCity")).clear();
		dr.findElement(By.id("depCity")).sendKeys("北京");
		
		dr.findElement(By.id("arrCity")).clear();
		dr.findElement(By.id("arrCity")).sendKeys("武汉");
		
		dr.findElement(By.id("roundFlight")).click();
		
		Calendar cal2= Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String CurrentDate = f.format(cal2.getTime());
		String StartDate = String.valueOf((Integer.valueOf(CurrentDate)+1));
		String RoundDate = String.valueOf((Integer.valueOf(CurrentDate)+7));
		
		System.out.println(CurrentDate);
		System.out.println(StartDate);
		System.out.println(RoundDate);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('depDate').readOnly=false;");
		dr.findElement(By.id("depDate")).clear();
		dr.findElement(By.id("depDate")).sendKeys(StartDate);
		
		js.executeScript("document.getElementById('arrDate').readOnly=false;");
		dr.findElement(By.id("arrDate")).clear();
		dr.findElement(By.id("arrDate")).sendKeys(RoundDate);
		
		dr.findElement(By.id("validQuery")).click();	
	}
}

