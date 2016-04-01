package test;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class TestSelendroid {
//  private SelendroidLauncher selendroidServer = null;
//  private WebDriver driver = null;

  @Test
  public void test() throws Exception {
  SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.17.0");
  WebDriver driver = new SelendroidDriver(capa);
  WebElement inputField = driver.findElement(By.id("my_text_field"));
  Assert.assertEquals("true",inputField.getAttribute("enabled"));
  inputField.sendKeys("Selendroid");
  Assert.assertEquals("Selendroid",inputField.getText());
  System.out.println(inputField.getText());
  driver.quit();
  }

  @Before
//  public void startSelendroidServer() throws Exception {
//	  System.out.println("==========");
//    if (selendroidServer != null) {
//      selendroidServer.stopSelendroid();
//    }
//    SelendroidConfiguration config = new SelendroidConfiguration();
//    System.out.println("---------==========");
//    selendroidServer = new SelendroidLauncher(config);
//    System.out.println("!!!!==========");
//    selendroidServer.launchSelendroid();
//    System.out.println("$$$$==========");
//    DesiredCapabilities caps = SelendroidCapabilities.android();
//    System.out.println("@@@@==========");
//    driver = new SelendroidDriver(caps);
//  }

  @After
  public void stopSelendroidServer() {
//    if (driver != null) {
//      driver.quit();
//    }
//    if (selendroidServer != null) {
//      selendroidServer.stopSelendroid();
//    }
  }
}
