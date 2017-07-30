package Tasks20170730;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class TestNGTask {

/*  @BeforeClass
  public void beforeClass() {
	  System.out.println("11");*/
  //}
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("22");
  }
  @Test(invocationCount=10,threadPoolSize=2)//run three times, 2 turns
  public void f1() {
	  System.out.println("33");
  }
  @Test
  public void f2() {
	  System.out.println("44");
  }
  
  @DataProvider
  public Object[]test1(){
	  return new Object[][]{
		     new Object[] { "selenium" },
	            new Object[] { "other" },
  };
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("55");
  }

/*  @AfterClass
  public void afterClass() {
	  System.out.println("66");*/
 // }

}
