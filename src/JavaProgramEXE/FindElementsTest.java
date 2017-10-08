package JavaProgramEXE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsTest {
	private static WebDriver driver;
	private static String baseUrl;

	public static void main(String[] args) {
		driver=new ChromeDriver();
		baseUrl="https://www.jd.com/";
		JD_NavLinks(driver, baseUrl);
		//JD_NavLinks2(driver, baseUrl);
		driver.quit();
	}
	
	public static void JD_NavLinks(WebDriver dr, String URL){
		dr.get(URL);
		List<WebElement> NLinks = dr.findElements(By.className("cate_menu_item"));
		for (WebElement link : NLinks) {
			System.out.println(link.getText());
		}
	}
	
	public static void JD_NavLinks2(WebDriver dr, String URL){
		dr.get(URL);
		List<WebElement> NLinks = dr.findElements(By.cssSelector("ul[class='JS_navCtn cate_menu'] li"));
		for (WebElement link : NLinks) {
			System.out.println(link.getText());
		}
	}
}
