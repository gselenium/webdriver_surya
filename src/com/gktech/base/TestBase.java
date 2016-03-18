package com.gktech.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gktech.util.XLS_Reader;

public class TestBase {
	public static boolean isInitialized;
	public static Properties OR,CONFIG;
	public static FileInputStream cp,ip;
	public static XLS_Reader Suitexls, newcarsxls,sellcarsxls,usedcarsxls;	
	public static String[] runmodes;
	public static WebDriver driver;
	
	public void Initialize() throws Exception{
		if(!isInitialized){
			OR=new Properties();
			ip=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/OR.properties");
			OR.load(ip);
			CONFIG=new Properties();
			cp=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/config.properties");
			CONFIG.load(cp);
			Suitexls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/Suite.xlsx");
			newcarsxls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/newcars.xlsx");
			sellcarsxls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/sellcars.xlsx");
			usedcarsxls=new XLS_Reader(System.getProperty("user.dir")+"/src/com/gktech/xlsfiles/usedcars.xlsx");
		}
	}
	
	public void OpenBrowser(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	public void CloseBrowser(){
		driver.close();
	}
	
	public static WebElement getObject(String xpathkey){
		return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
		
	}

}
