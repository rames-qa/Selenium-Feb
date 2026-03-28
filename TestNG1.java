package selenium.advanced;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG1 {
		@BeforeSuite
		void beforesuite() {
   System.out.println("Beforesuite");
		}
		@BeforeTest
		void beforetest() {
			System.out.println("BeforeTest");
	}
       @BeforeClass
       void BeforeClass() {
          System.out.println("BeforeClass");
       }
     @org.testng.annotations.BeforeMethod
     void BeforeMethod() {
    	 System.out.println("BeforeMethod");
     }
     @Test
     void Test() {
    	 System.out.println("Testing....");
     }
     @AfterMethod
     void AfterMethod() {
    	 System.out.println("AfterMethod");
     }
 @AfterClass
 void AfterClass() {
	 System.out.println("AfterClass");
 }
 @AfterTest
 void Aftertest() {
	 System.out.println("AfterTest");
 }
 @AfterSuite
 void AfterSuite() {
	 System.out.println("AfterSuite");
 }
}
