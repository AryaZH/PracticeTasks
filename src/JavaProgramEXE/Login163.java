package JavaProgramEXE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login163 {
	
    private static WebDriver driver;
    private static String url;

	public static void main(String[] args) throws Exception{
       Login();
	
	}
	
	public static  void Login()
	{
	    driver = new ChromeDriver();
	    url = "http://mail.163.com/";
	    driver.get(url);
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.id("lbNormal")).click();
	    driver.switchTo().frame("x-URS-iframe");

	    driver.findElement(By.xpath("//*[@id='account-box']/div/input")).sendKeys("test");
	    driver.findElement(By.xpath(".//*[@class='u-input box']/input[@name='password']")).sendKeys("test");
	    
		//driver.quit();
	}

}
