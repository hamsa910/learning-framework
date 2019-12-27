package com.mercury.tours;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Uploadfile_RobotClass {
	ChromeDriver driver; // global variable
	String filepath=System.getProperty("user.dir");
	

	
	@BeforeTest //predefined

	public void LaunchBrowser(){
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://gofile.io/?t=uploadFiles");
		}
	
	@Test
public void Sign_on_Sucessful_login() throws InterruptedException{
		

	 String absolutePath=System.getProperty("user.dir");
	 String filepath=absolutePath+"\\images\\hamsa pre assessment.JPG";
	 System.out.println(filepath);
	 driver.findElementById("btnChooseFiles").click();
	 uploadfile(filepath);
	 Thread.sleep(6000);
	 
	}
	
	

	
	public static void uploadfile(String filelocation) {
		
		
		
		try{
			
			StringSelection ss=new StringSelection(filelocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			
			Robot robot = new Robot();
			robot.delay(1000);
			
			
			
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(1000);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			
		} catch(Exception exp){
			
			exp.printStackTrace();
			
		}
		
		
	
	}
@AfterTest //post defined

private void closeBrowser() {
	driver.quit();
	
} 		
		

	

}
