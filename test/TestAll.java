package test;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestAll extends TestSuite{
	public static Test suite(){
		TestSuite suite=new TestSuite("TestSuite Test"); 
		return suite;
	}
	public static void main(String args[]){
		TestRunner.run(suite());
	}

}
