package TestNG_framwork;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class suiteApply {
  @Test
  public void f() {
	  System.out.println("11111111111111");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("22222222222222");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("33333333333333");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("44444444444444");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("555555555555");
  }

}
