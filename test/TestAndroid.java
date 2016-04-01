package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

public class TestAndroid {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
        try{

        	  SelendroidCapabilities capa = new SelendroidCapabilities("org.openqa.selenium.android.app:");

        	  WebDriver driver = new SelendroidDriver(capa);
        	  
        	  driver.get("http://192.168.0.51/portal");
        	  driver.findElement(By.name("loginName")).sendKeys("21010844");
       
        	  driver.findElement(By.name("loginPwd")).sendKeys("123456");
        	  WebElement e=driver.findElement(By.id("loginBtn"));
//		System.out.println("++++++++++++++++++++++++++");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		System.out.println("@@@@@++++++++++++++++++++++++++");
//		driver.findElement(By.name("loginName")).sendKeys("21010844");
//		System.out.println("=======++++++++++++++++++++++++++");
//		driver.findElement(By.name("loginPwd")).sendKeys("123456");
//		System.out.println("@@@@@++++++++++++++++++++++++++");
//		WebElement e=driver.findElement(By.id("loginBtn"));
//		System.out.println(e.toString());
//		System.out.println("====@@@@@++++++++++++++++++++++++++");
//		e.click();
//		System.out.println("@@@@@++++++++++++++++++++++++++");
//		driver.findElement(By.id("loginBtn")).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
