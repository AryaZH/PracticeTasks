package Task;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.List;
import java.util.Iterator;


public class BaiduEXE {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass
  public void setUp() throws Exception {
   // driver = new FirefoxDriver();
	 driver = new InternetExplorerDriver();
	//  driver = new ChromeDriver();
    baseUrl = "https://www.baidu.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }
  
  @Test(enabled=false)
  public void GetLinks1() throws Exception {
	driver.get(baseUrl);
	List<WebElement> Links = driver.findElements(By.xpath(".//*[@id='u1']/a"));
    System.out.print("Total Link  "+Links.size()+"\n");
    int Count = Links.size()-1;
    while(true){
   	WebElement w = Links.get(Count--);
   	if(Count<0)
    		break;
    	System.out.print("Links Text"+w.getText()+"\n");
    }
  }
 

  @Test
  public void GetLinks2() throws Exception {
	driver.get(baseUrl);
	List<WebElement> Links = driver.findElements(By.xpath(".//*[@id='u1']/a"));
    System.out.print("Total Link Count:  "+Links.size()+"\n");
    Iterator<WebElement> it = Links.iterator();
    while(it.hasNext()){
    	WebElement w = (WebElement) it.next();
    	System.out.print("LinkText:  "+w.getText()+"\n");
    }
  }


  @AfterClass
  public void tearDown() throws Exception {
    //driver.quit();
    
    }
}