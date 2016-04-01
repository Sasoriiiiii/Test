package test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class ab {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://192.168.0.51/");
		selenium.start();
	}

	@Test
	public void testAb() throws Exception {
		selenium.open("/pc/html/index.html");
		selenium.click("css=button.login-btn");
		selenium.click("id=_href_link");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=loginName", "21010828");
		selenium.type("name=loginPwd", "123456");
		selenium.click("id=loginBtn");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=[ ÍË ³ö ]");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=loginName", "21010828");
		selenium.type("name=loginPwd", "123456");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
