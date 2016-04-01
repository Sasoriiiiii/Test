package test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class PublicFunction {
	private Selenium selenium;
	
	public void openbrowser(String browsername,String addr){
		selenium = new DefaultSelenium("localhost", 4444, browsername,addr);
		selenium.start();
		selenium.open(addr);
		selenium.captureEntirePageScreenshot("C:\\Users\\Administrator\\Desktop\\picture\\1.jpg", "");
		
	}

}
