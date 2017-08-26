package JavaProgramEXE;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class RobotTest {
	
	private static WebDriver driver;
	private static String url;	
	private static String Filename;	

	public static void main(String[] args) throws AWTException {
	    driver = new ChromeDriver();
	    url = "E:\\20170820\\autotest.html";  
	    driver.get(url);
	    driver.findElement(By.name("file")).click();
	    Filename="E:\\20170820\\autotest - Copy";
	    
	    KeyEventClipboard(Filename);
	    KeyEventEnter();
	}
	
	public void KeyEvent(int asc) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(asc);
	}
	
	public static void KeyEventClipboard(String str) throws AWTException {
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable t = new StringSelection(str);
		cb.setContents(t, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void KeyEventEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
}
