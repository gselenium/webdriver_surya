package com.gktech.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {
	
	/*public static void main(String[] args) throws Exception {
		XLS_Reader xls=new XLS_Reader("D:/OnlineTraining/SuryaHYD/Workspace/WebDriver_TestNG_DataDriven/src/com/gktech/xlsfiles/newcars.xlsx");
		getTestData(xls, "Registration");
		Properties OR=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/OR.properties");
		OR.load(ip);
		System.out.println(OR.getProperty("loguname"));
		System.out.println(OR.getProperty("logpass"));
		
		Properties CONFIG=new Properties();
		FileInputStream cp=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/config.properties");
		CONFIG.load(cp);
		System.out.println(CONFIG.getProperty("baseurl"));
		System.out.println(CONFIG.getProperty("browsertype"));
		
		//to get the project address
		System.out.println(System.getProperty("user.dir"));
		
	}*/
	
	
	//to get the runmode of the suite;
	public static boolean isSuiteRunnable(XLS_Reader xls, String suiteName){
		boolean isExecutable=false;
		for(int i=2;i<=xls.getRowCount("Testsuites");i++){
			String suite=xls.getCellData("Testsuites", "TSID", i);
			String runmode=xls.getCellData("Testsuites", "Runmode", i);
			System.out.println(suite+"==="+runmode);
			if(suite.equalsIgnoreCase(suiteName)){
				if(runmode.equalsIgnoreCase("Y")){
					isExecutable=true;
				}
			}
		}
		return isExecutable;		
	}
	
	//to get the runmode of the testcase;
	public static boolean isTestCaseRunnable(XLS_Reader xls, String testcaseName){
		boolean isExecutable=false;
		for(int i=2;i<=xls.getRowCount("Testcases");i++){
			String testcase=xls.getCellData("Testcases", "TCID", i);
			String runmode=xls.getCellData("Testcases", "Runmode", i);
			System.out.println(testcase+"==="+runmode);
			if(testcase.equalsIgnoreCase(testcaseName)){
				if(runmode.equalsIgnoreCase("Y")){
					isExecutable=true;
				}
			}
		}
		return isExecutable;		
	}
	//to get the test data runmodes
	public static String[] getTestDataRunmodes(XLS_Reader xls, String sheetName){
		if(!xls.isSheetExist(sheetName)){
			System.out.println("Test data sheet not found");
		}
		//size declaration
		String[] runmodes=new String[xls.getRowCount(sheetName)-1];
		//values declaration
		for(int i=2;i<=xls.getRowCount(sheetName);i++){
			runmodes[i-2]=xls.getCellData(sheetName, "Runmode", i);
			System.out.println(xls.getCellData(sheetName, "Runmode", i));
		}
		return runmodes;		
	}
	//to get the test case test data from the sheet
	public static String[][] getTestData(XLS_Reader xls, String sheetName){
		if(!xls.isSheetExist(sheetName)){
			System.out.println("Test data sheet not found");
		}
		int rows=xls.getRowCount(sheetName);
		int cols=xls.getColumnCount(sheetName);
		System.out.println("Total rows: "+rows);
		System.out.println("Total cols: "+cols);
		//size declaration
		String[][] data=new String[rows-1][cols-1];
		//values declaration
		for(int rowNum=2;rowNum<=rows;rowNum++){
			for(int colNum=0;colNum<=cols-2;colNum++){
				data[rowNum-2][colNum]=xls.getCellData(sheetName, colNum, rowNum);
				System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"===");
			}
			System.out.println();
		}
		return data;
		
	}
	
}
