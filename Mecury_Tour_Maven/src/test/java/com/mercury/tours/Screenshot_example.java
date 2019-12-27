package com.mercury.tours;


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


public class Screenshot_example {
	ChromeDriver driver; // global variable
	String filepath=System.getProperty("user.dir");
	

	
	@BeforeTest //predefined

	public void LaunchBrowser(){
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		}
	
	@Test
public void Sign_on_Sucessful_login() throws InterruptedException{
		

	 driver.findElement(By.linkText("SIGN-ON")).click();
	 driver.findElement(By.name("userName")).sendKeys("testing");
	 driver.findElement(By.name("password")).sendKeys("testing");
	 driver.findElement(By.name("logins")).click();
	 Thread.sleep(6000);
	 
	 
	
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException{
		if(ITestResult.FAILURE==result.getStatus()){
			File Browserscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(Browserscreenshot, new File("C:\\Users\\user1\\Desktop\\Selenium Training\\workspace\\Mecury_Tour_Maven\\Mecury_Tour_Maven\\screenshots\\error.png"));
			
			
			FileUtils.copyFile(Browserscreenshot, new File(filepath+"\\screenshots"+"/"+result.getName()+"_"+System.nanoTime()+".png"));
			
		}
		
		
	}
@AfterTest //post defined

private void closeBrowser() {
	driver.quit();
	
} 		
		

	

}
