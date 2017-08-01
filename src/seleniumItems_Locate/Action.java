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
	
	/*1�� Qunar��Ʊ��������

	1) ����Qunar��Ʊ��ҳhttp://flight.qunar.com��ѡ�񡰵��̡������������������У�
	ѡ��today+7�պ�����ڣ�
	        �㡰����������ת����Ʊ���������б�ҳ��
	2) ���б�ҳͣ��1���ӣ�����ҳ���ϳ��֡�������������
	3) ������ֺ����б����ڳ��֡�ÿ�κ���������˰�ѡ����������ѡ����Ʊ����ť��
	         ��չ�����б��л���֡���һ�̡��� ���ڶ��̡�������û�г��֡�ÿ�κ���������˰�ѡ����������ѡ����Ʊ����ť��
	         ��չ�����б�ײ��л���֡����۷�Χ��
	4) ��������ֺ����б���ҳ�����֡��ú��ߵ�ǰ�޿��ۺ��ࡱ*/

	@Test
	 public void Qunar() throws Exception{
		//--------1----------------------
		driver.get("https://flight.qunar.com/");
		driver.findElement(By.id("searchTypeSng")).click();
		
		driver.findElement(By.name("fromCity")).clear();
		driver.findElement(By.name("fromCity")).sendKeys("����");
		
		driver.findElement(By.name("toCity")).clear();
		driver.findElement(By.name("toCity")).sendKeys("�Ϻ�");
		
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
