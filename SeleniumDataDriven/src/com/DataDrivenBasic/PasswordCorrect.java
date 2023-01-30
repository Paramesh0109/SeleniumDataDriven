package com.DataDrivenBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PasswordCorrect {

	@Test
	public void ValidUsername() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IT\\Desktop\\SeleniumLearn\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://activationcall.ftxtradingsoftware.com/login");
		Thread.sleep(1000);
				
		driver.findElement(By.id("email")).sendKeys("nication@ftxtradingsoftware.com");
		driver.findElement(By.id("password")).sendKeys("Activation8903233335");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.quit();
	}

}
