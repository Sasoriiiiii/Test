package test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class login {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://192.168.0.51/");
		selenium.start();
	}

	@Test
	public void testLogin() throws Exception {
		selenium.open("/pc/html/index.html");
		selenium.click("css=button.login-btn");
		selenium.click("id=_href_link");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
