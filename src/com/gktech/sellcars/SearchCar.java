package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class SearchCar extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		if(!TestUtil.isTestCaseRunnable(sellcarsxls, "SearchCar")){
			throw new SkipException("Runmode of the SearchCar test case is set as no, so skipping SearchCar testcase");
		}
		runmodes=TestUtil.getTestDataRunmodes(sellcarsxls, "SearchCar");
	}
	//test case
	@Test(dataProvider="getData")
	public void searchCar(String name, String email, String mobile, String pass, String confpass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode of the test data is set as no, so skipping rownumber: "+count+1);
		}
		//executing test case
		System.out.println("Executing test case with test data as: "+name+"=="+email+"=="+mobile+"=="+pass+"=="+confpass);
		//webdriver code
	}
	
	@DataProvider
	public String[][] getData(){
		return TestUtil.getTestData(sellcarsxls, "SearchCar");
		
	}

}
