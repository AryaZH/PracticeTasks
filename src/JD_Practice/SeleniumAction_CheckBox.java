package JD_Practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumAction_CheckBox {
	private static WebDriver dr;
	private static String baseUrl;

	public static void main(String[] args) {
		dr=new FirefoxDriver();
		baseUrl="https://search.jd.com/Search?keyword=Apple&enc=utf-8&pvid=b94c83c97ffa43b3b3e8ae87dc1c55fb";
		dr.get(baseUrl);
		dr.findElement(By.id("key")).clear();
		dr.findElement(By.id("key")).sendKeys("Apple");
		dr.findElement(By.className("button")).click();

		CheckBox_Practice(dr);
	}
	
	public static void CheckBox_Practice(WebDriver dr){

		List<WebElement> CheckBoxList = dr.findElements(By.xpath("//div[@id='J_feature']/ul/li/a"));
		for(WebElement checkbox : CheckBoxList) {
			String currentWindow = driver.getWindowHandle();
			
			System.out.println(checkbox.getText());
			checkbox.click();

		}
	}
	
	public String getWindowHandle(WebDriver driver){
	    String currentWindow = driver.getWindowHandle();
	    return currentWindow;
	}
	
	public static void switchToNewWindow(WebDriver driver){
	String currentWindow = driver.getWindowHandle();
	    Set<String> handles = driver.getWindowHandles();
	    Iterator<String> it = handles.iterator();
	    while(it.hasNext()){
	        if(currentWindow == it.next())  continue;
	        driver.switchTo().window(it.next());      
	    }   
	}
	 
  
		
}
