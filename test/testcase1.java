package test;

import com.thoughtworks.selenium.Selenium;

public class testcase1 extends PublicFunction{
	String title="casetitle";
	boolean result=false;

	public static void main(String[] args){
		try{
			testcase1 a=new testcase1();
			a.openbrowser("*chrome","http://www.baidu.com");
			System.out.println("sucess!");	
			a.result=true;
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

