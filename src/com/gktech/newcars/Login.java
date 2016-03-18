package com.gktech.newcars;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class Login extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		if(!TestUtil.isTestCaseRunnable(newcarsxls, "Login")){
			throw new SkipException("Runmode of the Login test case is set as no, so skipping Login test case");
		}
		runmodes=TestUtil.getTestDataRunmodes(newcarsxls, "Login");
	}
	//test case
	@Test(dataProvider="getData")
	public void login(String uname, String pass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode of the test data is set as no, so skipping rownumber: "+(count+1));
		}
		//executing test case
		System.out.println(uname+"==="+pass);
		//webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("loglink").click();
		getObject("loguname").sendKeys(uname);
		getObject("logpass").sendKeys(pass);
		getObject("logbutton").click();
		//CloseBrowser();
		
	}
	@DataProvider
	public String[][] getData(){
		return TestUtil.getTestData(newcarsxls, "Login");
		
	}

}
