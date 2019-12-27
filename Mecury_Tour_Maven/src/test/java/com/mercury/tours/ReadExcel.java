package com.mercury.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel{
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;


public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
	//Create a object of File class to open xlsx file
	File file =	new File(filePath+"\\"+fileName);
	//Create an object of FileInputStream class to read excel file
	FileInputStream inputStream = new FileInputStream(file);
		
	//Find the file extension by spliting file name in substing and getting only extension name 
	String fileExtensionName = fileName.substring(fileName.indexOf("."));
	//Check condition if the file is xlsx file
	if(fileExtensionName.equals(".xlsx")){
	//If it is xlsx file then create object of XSSFWorkbook class
		//KDWorkbook = new XSSFWorkbook(inputStream);
		
			String[][] arrayExcelData =null;
			FileInputStream Excelfile =new FileInputStream(fileName);
			ExcelWBook=new XSSFWorkbook(Excelfile);
			ExcelWSheet=ExcelWBook.getSheet(sheetName);
			int totalNoOfRows=ExcelWSheet.getLastRowNum();
			int totalNOCols_0=ExcelWSheet.getRow(0).getLastCellNum();
					
			arrayExcelData= new String[totalNoOfRows][totalNOCols_0];
			for(int i=0;i <totalNoOfRows;i++ ){
				int totalNoOfCols=ExcelWSheet.getRow(i).getLastCellNum();
				
				for(int j=0;j<totalNoOfCols;j++){
					arrayExcelData[i][j]=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			
			
			
			
			System.out.println(arrayExcelData);
			return arrayExcelData;
			
			
		}
		
	}
	//Check condition if the file is xls file
	else if(fileExtensionName.equals(".xls")){
		//If it is xls file then create object of XSSFWorkbook class
		KDWorkbook = new HSSFWorkbook(inputStream);
	}
	//Read sheet inside the workbook by its name
	Sheet  TestSheet = KDWorkbook.getSheet(sheetName);
	 return TestSheet;	
	}

}