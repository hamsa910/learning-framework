package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight_Login_IE {
	
	InternetExplorerDriver driver;
	
  @Test
  
public void Sign_on(){
		
		//driver.get(url);
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.linkText("SIGN-OFF")).click();
		
	}
  
  @BeforeTest
  public void LaunchBrowser(){
	  //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		String absolutePath = System.getProperty("user.dir");
		String filePath = absolutePath+"\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", filePath);
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		
  }
}
