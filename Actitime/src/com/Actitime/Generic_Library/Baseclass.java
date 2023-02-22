package com.Actitime.Generic_Library;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class Baseclass {
	public static WebDriver driver;  // write here to use this for all class 
	
	FileLibrary f = new FileLibrary(); // declare globally
	
	@BeforeSuite                                 // use for database connection
	public void databaseconnection() {
	 Reporter.log("database connected",true);	
	}
	
	@AfterSuite                                    // use for disconnect database connection
	public void databasedisconnection() {
		Reporter.log("database disconnected",true); 
	}
	
	@BeforeClass
	public void launchbrowser() throws IOException {
         //WebDriver driver=new ChromeDriver();
		  driver=new ChromeDriver();
          driver.manage().window().maximize();
//        driver.get("https://demo.actitime.com"); this is hardcoded
          String Url = f.readDataFromPropertyFile("url");
          driver.get(Url); 	
          Reporter.log("browser Launched succesfully",true);
		
	}
	
	
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed succesfully",true);
	}
	
	
	@BeforeMethod
	public void LoginToActitime() throws IOException {
		String UN = f.readDataFromPropertyFile("username");
		String PW = f.readDataFromPropertyFile("password");
		
		LoginPage lp= new LoginPage(driver);  // when use poi through that login done
		lp.login(UN, PW);
		
		
		
		// below lines are use when poi not used in code
//		driver.findElement(By.id("username")).sendKeys(UN);
//		driver.findElement(By.name("pwd")).sendKeys(PW);
//		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("Login successfully",true);
	}
	
	@AfterMethod
	public void Logout() {
		
//		driver.findElement(By.xpath("//a[.='Logout']")).click();   getting path by xpath
//		driver.findElement(By.id("logoutLink")).click();      // getting path by id // use before poi
		
		HomePage hp=new HomePage(driver); //attach homepage with base class
		
		hp.getLgoutlnk().click(); // call getter methods of home page class
		
		Reporter.log("Logout Succesfully");
		
	}
}
