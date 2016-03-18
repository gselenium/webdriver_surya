package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import com.gktech.base.TestBase;
import com.gktech.util.TestUtil;

public class TestSuiteBase extends TestBase{
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{
		Initialize();
		if(!TestUtil.isSuiteRunnable(Suitexls, "sellcars")){
			throw new SkipException("Runmode of the sellcars suite is set as no, so skipping runmodes suite");
		}
	}
	

}
