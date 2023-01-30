package com.DataDrivenParameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PasswordCorrect {

	@Test
	@Parameters({"username","password"})
	public void ValidPassword(String Uname, String Pwd) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IT\\Desktop\\SeleniumLearn\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://activationcall.ftxtradingsoftware.com/login");
		Thread.sleep(1000);

		driver.findElement(By.id("email")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(Pwd);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.quit();
	}

}
