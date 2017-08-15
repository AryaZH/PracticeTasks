package JavaProgramEXE;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class First5Pages {
	
	private static WebDriver driver;
	private static String url;
	private static int PageNum=2;	

	public static void main(String[] args) throws Exception{
	    driver = new ChromeDriver();
	    url = "http://ask.testfan.cn/articles";
	    driver.manage().window().maximize();
	    printLinks();
	    
	    while(PageNum<6){
	    	IteratePage();
	    	printLinks();
	    	PageNum++;
	    }  
	    driver.quit();
	}
	
	public static void IteratePage(){
		
		driver.get(url+"?page="+PageNum);
		System.out.println("This is Number -"+PageNum+"- page!");
	}
	
	public static void printLinks() throws Exception
	{   	
		List<WebElement> ulList = driver.findElements(By.xpath("//section[@class='stream-list-item clearfix']/div/h2/a"));
		for(WebElement a : ulList) {
			System.out.print(a.getText()+ ":   ");
			System.out.print(a.getAttribute("href")+"\n\n");
		}	
	}

}