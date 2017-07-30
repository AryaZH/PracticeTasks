package cn.testfan;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OtherSample {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		// driver = new FirefoxDriver(); // 初始化ff
		// driver = new ChromeDriver(); //初始化chrome
		driver = new InternetExplorerDriver();// 初始化IE
		baseUrl = "http://localhost:8040/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 全局的元素等待设置
	}

	@Test
	public void testUntitled() throws Exception {

		driver.get(baseUrl); // get 打开网址

		// username
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");

		// password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");

		// login button
		driver.findElement(By.name("imageField")).click();

		Thread.sleep(2000);

		driver.switchTo().frame(1);// frame切换
		// 点击菜单
		driver.findElement(By.id("ri2")).click(); // 其他定位方式???
		// driver.findElements(By.tagName("span")).get(2).click();
		// driver.findElement(By.cssSelector("img[name='ri2'] + span")).click();

		// 查询一个用户名为zhangsan8421的记录

		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
		// 找不到
		driver.findElement(By.id("select-key:useruuid")).sendKeys("zhangsan8421"); // 查询条件

		// driver.findElement(By.id("btn75")).click(); //id属性是动态的，所以不适合用来定位
		// 点击查询
		driver.findElement(By.name("select-key_submit")).click(); //

		// -----------------------------------------------------------

		driver.findElement(By.name("record_record_addRecord")).click(); // 弹出一个新增窗口

		String old_window = driver.getWindowHandle();

		// 切换窗口
		for (int a = 0; a <= 9; a++) { // 循环1

			Set<String> windowHandles = driver.getWindowHandles();

			for (String handler : windowHandles) { // 循环2
				System.out.println(handler);
				driver.switchTo().window(handler); // 尝试切换
				String title = driver.getTitle();
				if ("增加人员维护".equals(title)) {
					a = 10;
					break; // 跳出循环2
				}
			}
		}

		System.out.println(driver.getTitle());

		String uid = "testfan" + getRandom(99999);

		// 完成新增页面上的元素操作
		driver.findElement(By.id("record:useruuid")).sendKeys(uid);
		driver.findElement(By.id("record:name")).sendKeys("testfan");
		driver.findElement(By.id("record:department")).sendKeys("test");

		Select sel_role = new Select(driver.findElement(By.id("record:roleuuid")));
		Select sel_abili = new Select(driver.findElement(By.id("record:ability")));

		// record:roleuuid
		// record:ability
		sel_role.selectByIndex(2);
		sel_abili.selectByIndex(1);

		driver.findElement(By.name("record_record_saveAndExit")).click();

		Thread.sleep(1000);

		// -----------------------------------------------------------

		driver.switchTo().window(old_window); // 切换回原来的窗口

		System.out.println(driver.getTitle());

		// 重新进入frame
		driver.switchTo().frame(3);

		// 再次查询新增的记录
		driver.findElement(By.id("select-key:useruuid")).clear();
		driver.findElement(By.id("select-key:useruuid")).sendKeys(uid); // 查询条件

		// 点击查询
		driver.findElement(By.name("select-key_submit")).click(); //

		// 选中查询列表中的第一条记录，点击删除
		driver.findElement(By.name("record:_flag")).click();
		driver.findElement(By.name("record_record_deleteRecord")).click();

		// 处理确认是否删除的alert
		driver.switchTo().alert().accept();

		Thread.sleep(1000); // 此处应停顿下
		// 处理提示删除成功的alert
		driver.switchTo().alert().accept();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit(); // 关闭浏览器
	}

	public static int getRandom(int max) throws Exception {
		// Math.random()：产生一个[0，1)之间的随机数
		return ((int) (Math.random() * max) + 1); // int 强制类型转换，会舍去小数点后面的部分
	}

}