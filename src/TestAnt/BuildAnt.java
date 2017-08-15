package TestAnt;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BuildAnt {
  @Test
  public void f() {
	  System.out.println("11111111111");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("11111111111");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("11111111111");
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
