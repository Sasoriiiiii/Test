package test;
 
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
 
public class TestAppium {
    private AppiumDriver driver;
 
    @Before
    public void setUp() throws Exception {
    }
 
    @After
    public void tearDown() throws Exception {

    }
 
    @Test
    public void addContact(){
    	try{
            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "apps");
            File app = new File(appDir, "futureve-mobile-zhihu-release-3.1.0(305).apk");
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName","emulator-5554");
            capabilities.setCapability("platformVersion", "4.4");
//            capabilities.setCapability("noReset", "true");
//            capabilities.setCapability("autoLaunch", "false");
//            System.out.println("111111111111111111==============");
//            capabilities.setCapability("app", app.getAbsolutePath());
//            System.out.println("####==============");
            capabilities.setCapability("appPackage", "com.zhihu.android");
            capabilities.setCapability("appActivity", ".app.ui.activity.MainActivity");
//            System.out.println("++++==============");
//            AppiumDriver driver;
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//            System.out.println("==============");
            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;
            System.out.println("width:"+width+"------height:"+height);
            driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2,5000);
//            driver.get("http://192.168.0.51/portal");
//            driver.findElement(By.name("loginName")).sendKeys("21010829");
//            driver.findElement(By.name("loginPwd")).sendKeys("123456");
//            driver.findElement(By.id("loginBtn")).click();
            driver.quit();
    		}catch(Exception e){
    			e.printStackTrace();
    			driver.quit();
    		}
    }
}
//import org.apache.commons.io.FileUtils;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
////import org.testng.annotations.Test;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
// 
//public class TestAppium {
//    private  AppiumDriver  driver;
//    //static String currentPath = System.getProperty("user.dir");
// 
//    @Before
//    public void setUp() throws Exception {
//    	 File classpathRoot = new File(System.getProperty("user.dir"));
//       File appDir = new File(classpathRoot, "apps");
//       File app = new File(appDir, "futureve-mobile-zhihu-release-3.1.0(305).apk");
//       
//       DesiredCapabilities capabilities = new DesiredCapabilities();
////       capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
//       capabilities.setCapability("platformName", "Android");
//       capabilities.setCapability("deviceName","emulator-5554");
//       capabilities.setCapability("platformVersion", "4.4");
////       capabilities.setCapability("noReset", "true");
////       capabilities.setCapability("autoLaunch", "false");
////       System.out.println("111111111111111111==============");
////       capabilities.setCapability("app", app.getAbsolutePath());
////       System.out.println("####==============");
//       capabilities.setCapability("appPackage", "com.zhihu.android");
//       capabilities.setCapability("appActivity", ".app.ui.activity.MainActivity");
////       System.out.println("++++==============");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        
//    }
// 
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
//    
//    @Test 	
//    public void swipeToRight(){
//    	System.out.println("swipe function");
//    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2,500);
//   }
//}