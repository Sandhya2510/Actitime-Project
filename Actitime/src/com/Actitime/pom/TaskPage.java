package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

	
	//Declaration
	
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addnew;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcust;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement newcustname;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesp;
	
	@FindBy(xpath = "(//div[@class='dropdownButton'])[15]")
	private WebElement dropdown;
	
	@FindBy(xpath = "(//div[.='Our company'])[9]")
	private WebElement ourcompany;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createbtn;
	
	//initalization
	
	public TaskPage(WebDriver driver) 
	{
	PageFactory.initElements(driver,this);
	}

	// after applying getter setter method
	
	public WebElement getAddnew() {
		return addnew;
	}

	public WebElement getNewcust() {
		return newcust;
	}

	public WebElement getNewcustname() {
		return newcustname;
	}

	public WebElement getCustdesp() {
		return custdesp;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getOurcompany() {
		return ourcompany;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}
	
	//business logic or ganeric method
	
	public void completetask(String Custname,String Description) {
		addnew.click();
		newcust.click();
		newcustname.sendKeys(Custname);
		custdesp.sendKeys(Description);
		dropdown.click();
		ourcompany.click();
		createbtn.click();
		
	}
	
	
	
}
