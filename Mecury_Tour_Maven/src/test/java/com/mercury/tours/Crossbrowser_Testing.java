package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowser_Testing extends Application_Test_Data {
	
	WebDriver driver;
	@Test(dataProvider = "Login")
	
  public void Sign_on (String uname,String password) throws InterruptedException{
		
		//driver.get(url);
	    driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	    Thread.sleep(1000);
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(9000);
		driver.findElement(By.partialLinkText("SIGN")).click();
		
	}

@BeforeTest
@Parameters("browser")
 public void LaunchBrowser(String browser){
	
	if(browser.equalsIgnoreCase("Chrome")){
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
		 
		}
  else if (browser.equalsIgnoreCase("Internetexplorer")){
	  
	  String absolutePath = System.getProperty("user.dir");
		String filePath = absolutePath+"\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", filePath);
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		
	
}
  else{
	  
	  System.out.println("no browser");
  }

}
}
