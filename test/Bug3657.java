package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Bug3657 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.0.51/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBug3657() throws Exception {
    driver.get(baseUrl + "/pc/html/index.html");
    driver.findElement(By.cssSelector("button.login-btn")).click();
    //driver.findElement(By.id("_href_link")).click();
    driver.findElement(By.name("loginName")).clear();
    driver.findElement(By.name("loginName")).sendKeys("21010829");
    driver.findElement(By.name("loginPwd")).clear();
    driver.findElement(By.name("loginPwd")).sendKeys("123456");
    driver.findElement(By.id("loginBtn")).click();
    driver.findElement(By.xpath("//li[3]/h4")).click();
    driver.findElement(By.xpath("(//li[@id='showOrders'])[11]")).click();
    WebElement frame=driver.findElement(By.id("mainFrame"));
    driver.switchTo().frame(frame);
    driver.findElement(By.xpath("//tr[@id='datagrid-row-r1-2-16']/td[3]/div/a")).click();
    for(int i=1;i<=20;i++){
    driver.findElement(By.xpath("//input[@value='´¢ Öµ']")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[29]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[29]")).sendKeys("100");
    driver.findElement(By.id("sub1")).click();
    System.out.println("run 1 time");
    }
    //driver.findElement(By.linkText("ç¡®å®š")).click();
    //driver.findElement(By.linkText("[ é€?å‡?]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
