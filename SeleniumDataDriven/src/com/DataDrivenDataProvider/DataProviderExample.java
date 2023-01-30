package com.DataDrivenDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	String [][] data ={
		{"notification@ftxtradingsoftware.com","ivation8903233335"},
		{"notjcation@ftxtradingsoftware.com","Activation8903233335"},
		{"notjcation@ftxtradingsoftware.com","Afivdf903233335"},
		{"notification@ftxtradingsoftware.com","Activation8903233335"}
	};

	@DataProvider(name="LoginData")
	public String[][] LoginDataProvider() {
		return data;
	}

	@Test(dataProvider = "LoginData")
	public void LoginWithDataProvider(String Uname, String Pwd) throws InterruptedException {
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
