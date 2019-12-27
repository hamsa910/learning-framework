package com.mercury.tours;




import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ReadDataFrom_XLS extends Application_Test_Data {
	
	ChromeDriver driver; // global variable
	
	@BeforeTest //predefined

	public void LaunchBrowser(){
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		}
	
	@Test(dataProvider= "LoginDataXLS")
    public void Sign_on_Sucessful_login(String uname,String password) throws InterruptedException{
	 driver.findElement(By.linkText("SIGN-ON")).click();
	 driver.findElement(By.name("userName")).sendKeys(uname);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.name("login")).click();
	 Thread.sleep(6000);
	 
	 //validate actual and expected sing off page
	
	 driver.findElement(By.linkText("SIGN-OFF")).click();;
	
	
}
	
@AfterTest //post defined

private void closeBrowser() {
	driver.quit();
	
} 		
		

	

}
