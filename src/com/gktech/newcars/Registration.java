package com.gktech.newcars;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class Registration extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		if(!TestUtil.isTestCaseRunnable(newcarsxls, "Registration")){
			throw new SkipException("Runmode of the Registration test case is set as no, so skipping Registration testcase");
		}
		runmodes=TestUtil.getTestDataRunmodes(newcarsxls, "Registration");
	}
	//test case
	@Test(dataProvider="getData")
	public void registration(String name, String email, String mobile, String pass, String confpass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode of the test data is set as no, so skipping rownumber: "+count+1);
		}
		//executing test case
		System.out.println("Executing test case with test data as: "+name+"=="+email+"=="+mobile+"=="+pass+"=="+confpass);
		//webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("loglink").click();
		getObject("regsignup").click();
		getObject("regname").sendKeys(name);
		getObject("regemail").sendKeys(name);
		getObject("regmobile").sendKeys(name);
		getObject("regpass").sendKeys(name);
		getObject("regconfpass").sendKeys(name);
		getObject("regsignupbutton").click();
	}
	
	@DataProvider
	public String[][] getData(){
		return TestUtil.getTestData(newcarsxls, "Registration");
		
	}

}
