package com.DataDrivenJXL;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenExcel {

	String [][] data=null;

	@DataProvider(name ="Logindata")
	public String[][] LoginDataProvider() throws BiffException, IOException {

		data = GetdataFromExcel();
		return data;

	}
	public String[][] GetdataFromExcel() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("C:\\Users\\IT\\Downloads\\LoginData.xls");
		Workbook book = Workbook.getWorkbook(excel);
		Sheet sheet = book.getSheet(0);
		int rowcount = sheet.getRows();
		int columncount = sheet.getColumns();

		String testdata[][] = new String[rowcount-1][columncount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < columncount; j++) {
				testdata[i-1][j] = sheet.getCell(j, i).getContents();
			}  
		}
		return testdata;		

	}


	@Test(dataProvider = "Logindata")
	public void GetData(String Uname, String Pwd) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\IT\\Desktop\\SeleniumLearn\\ChromeDriver\\chromedriver.exe");
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
