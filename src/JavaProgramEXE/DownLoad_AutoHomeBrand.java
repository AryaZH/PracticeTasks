package JavaProgramEXE;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class DownLoad_AutoHomeBrand {
	public static FirefoxDriver driver;

	public static void main(String[] args) {
				
				driver.get("https://www.autohome.com.cn/beijing/");
				
				WebElement S = driver.findElement(By.xpath("//*[@id='auto-index-carbrand']/div[@class='select-option']/dl"));
				
				Select select = new Select(S);
				List<WebElement> ListBrand = select.getOptions();
				
				System.out.println(ListBrand.size());
				
//				int i=0;
//				while(i < ListBrand.size())
//				{
//					System.out.println(ListBrand.indexOf(i));
//					i++;
//				}

	}

}