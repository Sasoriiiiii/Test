package test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class TestIOS {
	
	
	private AppiumDriver driver;
  @Test
  public void loginInIOS(){
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(CapabilityType.BROWSER_NAME, "Safari");
      capabilities.setCapability("platformVersion", "9.2");
      capabilities.setCapability("platformName", "iOS");
      capabilities.setCapability("deviceName", "iPad Air");
//      capabilities.setCapability("app", "safari");
      capabilities.setCapability("noReset", "true");
      try {
		driver = new AppiumDriver(new URL("http://192.168.137.105:4723/wd/hub"), capabilities);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      driver.get("http://192.168.0.51/portal");
      driver.findElement(By.name("loginName")).sendKeys("21010841");
      driver.findElement(By.name("loginPwd")).sendKeys("123456");
      driver.findElement(By.id("loginBtn")).click();
      System.out.println("==================================");
      driver.quit();
  }
}
