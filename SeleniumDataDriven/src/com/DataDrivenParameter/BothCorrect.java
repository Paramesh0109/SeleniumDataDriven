package com.DataDrivenParameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	
	@Test
	@Parameters({"username","password"})
	public void ValidUsername(String Uname, String Pwd) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IT\\Desktop\\SeleniumLearn\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://activationcall.ftxtradingsoftware.com/login");
						
		driver.findElement(By.id("email")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(Pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.quit();
		
	}

}
