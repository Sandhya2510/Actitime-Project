package com.Actitime.test_script;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Actitime.Generic_Library.Baseclass;
import com.Actitime.Generic_Library.FileLibrary;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

public class CreateCustomer extends Baseclass {

	FileLibrary flib=new FileLibrary(); 
	
	
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException
	{
		//driver.findElement(By.xpath("//div[.='Tasks']")).click();
		//Reporter.log("Customer created");
		
		HomePage hp =new HomePage(driver);
		hp.getTasklnk().click();
		
		TaskPage tp=new TaskPage(driver);
		String custname = flib.readDataFromExcelFile("sheet1", 1, 1);
		String descriptions = flib.readDataFromExcelFile("sheet1", 1, 2);
		tp.completetask(custname, descriptions);
	}
	
	
	
}
