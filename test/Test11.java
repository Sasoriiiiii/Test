package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test11 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		WebDriver dr= new FirefoxDriver();
		dr.get("http://192.168.0.51/portal");
		dr.findElement(By.name("loginName")).sendKeys("21010829");
		dr.findElement(By.name("loginPwd")).sendKeys("123456");
		dr.findElement(By.id("loginBtn")).click();
		//dr.findElement(By.cssSelector("#kw")).sendKeys("≤‚ ‘");
		//dr.findElement(By.cssSelector(".s_ipt")).sendKeys("≤‚ ‘");
		//dr.findElement(By.cssSelector("#su")).click();
		
		dr.findElement(By.xpath("//li/h4")).click();
		dr.findElement(By.xpath("//li/ul/li[1]")).click();

		
	}

}
