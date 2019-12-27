package com.mercury.tours;

import org.testng.annotations.DataProvider;

public class Application_Test_Data {
 //this class is only to hold test data
	
	@DataProvider(name="Login")
	
	public Object[][] getDataFromDataProvider(){
		return new Object[][]{
			{"testing","testing"},
			{"dixit","dixit"},
			{"testabhi","testabhi"},
	
		
	};
	
	}
	
	
	//.........This is to read  XLS Excel data.........
	
	@DataProvider(name="LoginDataXLS")
	public Object[][] ExcelXLS() throws Exception{
		
		ReadExcel_XLS excel=new ReadExcel_XLS();
		Object[][] testObjArray = excel.getExcelData("C:\\Users\\user1\\Desktop\\Selenium Training\\workspace\\Mecury_Tour_Maven\\Mecury_Tour_Maven\\Mecury_Tour_Maven.xls", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
		
	}
	 

	//.........This is to read  XLSX Excel data.........
@DataProvider(name="LoginDataXLSX")
	
	public Object[][] ExcelXLSX() throws Exception{
		
		ReadExcel_XLSX excel=new ReadExcel_XLSX();
		Object[][] testObjArray = excel.getExcelData("C:\\Users\\user1\\Desktop\\Selenium Training\\workspace\\Mecury_Tour_Maven\\Mecury_Tour_Maven\\Mecury_Tour_Maven.xlsx", "Sign_On");
		System.out.println(testObjArray);
		return testObjArray;
		
	}
}

