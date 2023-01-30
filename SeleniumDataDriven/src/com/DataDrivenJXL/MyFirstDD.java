package com.DataDrivenJXL;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MyFirstDD {
	
	WebDriver driver;
	
	
	@DataProvider(name = "LoginData")
	public String[][] GetData () throws BiffException, IOException {
		String [][] data = GetDataFromExcel();
		return data;
	}
	
	public String[][] GetDataFromExcel() throws BiffException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\IT\\Downloads\\LoginData.xls");
		Workbook book = Workbook.getWorkbook(file);
		Sheet sheet = book.getSheet(0);
		int allrows = sheet.getRows();
		int allcolumns = sheet.getColumns();
		
		String testdata[][] = new String [allrows-1][allcolumns];
		
		for (int i = 1; i < allrows; i++) {
			for (int j = 0; j < allcolumns; j++) {
				testdata[i-1][j] = sheet.getCell(j, i).getContents();				
			}
			
		}
		return testdata;
		
	}
	
	@BeforeTest
	public void Beforelogin() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", 
				"C:\\Users\\IT\\Desktop\\SeleniumLearn\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void Afterlogin() {
		
		driver.quit();
		
	}
	
	@Test(dataProvider = "LoginData")
	public void LoginwithDD(String Uname, String Pswd) throws InterruptedException {
				
		driver.findElement(By.name("username")).sendKeys(Uname);
		driver.findElement(By.name("password")).sendKeys(Pswd);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
		
	}
	
	}
