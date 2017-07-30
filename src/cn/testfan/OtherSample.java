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
		// driver = new FirefoxDriver(); // ��ʼ��ff
		// driver = new ChromeDriver(); //��ʼ��chrome
		driver = new InternetExplorerDriver();// ��ʼ��IE
		baseUrl = "http://localhost:8040/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ȫ�ֵ�Ԫ�صȴ�����
	}

	@Test
	public void testUntitled() throws Exception {

		driver.get(baseUrl); // get ����ַ

		// username
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");

		// password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");

		// login button
		driver.findElement(By.name("imageField")).click();

		Thread.sleep(2000);

		driver.switchTo().frame(1);// frame�л�
		// ����˵�
		driver.findElement(By.id("ri2")).click(); // ������λ��ʽ???
		// driver.findElements(By.tagName("span")).get(2).click();
		// driver.findElement(By.cssSelector("img[name='ri2'] + span")).click();

		// ��ѯһ���û���Ϊzhangsan8421�ļ�¼

		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
		// �Ҳ���
		driver.findElement(By.id("select-key:useruuid")).sendKeys("zhangsan8421"); // ��ѯ����

		// driver.findElement(By.id("btn75")).click(); //id�����Ƕ�̬�ģ����Բ��ʺ�������λ
		// �����ѯ
		driver.findElement(By.name("select-key_submit")).click(); //

		// -----------------------------------------------------------

		driver.findElement(By.name("record_record_addRecord")).click(); // ����һ����������

		String old_window = driver.getWindowHandle();

		// �л�����
		for (int a = 0; a <= 9; a++) { // ѭ��1

			Set<String> windowHandles = driver.getWindowHandles();

			for (String handler : windowHandles) { // ѭ��2
				System.out.println(handler);
				driver.switchTo().window(handler); // �����л�
				String title = driver.getTitle();
				if ("������Աά��".equals(title)) {
					a = 10;
					break; // ����ѭ��2
				}
			}
		}

		System.out.println(driver.getTitle());

		String uid = "testfan" + getRandom(99999);

		// �������ҳ���ϵ�Ԫ�ز���
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

		driver.switchTo().window(old_window); // �л���ԭ���Ĵ���

		System.out.println(driver.getTitle());

		// ���½���frame
		driver.switchTo().frame(3);

		// �ٴβ�ѯ�����ļ�¼
		driver.findElement(By.id("select-key:useruuid")).clear();
		driver.findElement(By.id("select-key:useruuid")).sendKeys(uid); // ��ѯ����

		// �����ѯ
		driver.findElement(By.name("select-key_submit")).click(); //

		// ѡ�в�ѯ�б��еĵ�һ����¼�����ɾ��
		driver.findElement(By.name("record:_flag")).click();
		driver.findElement(By.name("record_record_deleteRecord")).click();

		// ����ȷ���Ƿ�ɾ����alert
		driver.switchTo().alert().accept();

		Thread.sleep(1000); // �˴�Ӧͣ����
		// ������ʾɾ���ɹ���alert
		driver.switchTo().alert().accept();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit(); // �ر������
	}

	public static int getRandom(int max) throws Exception {
		// Math.random()������һ��[0��1)֮��������
		return ((int) (Math.random() * max) + 1); // int ǿ������ת��������ȥС�������Ĳ���
	}

}