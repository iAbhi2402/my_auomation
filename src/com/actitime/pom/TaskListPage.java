package com.actitime.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.actitime.generic.BaseClass;

public class TaskListPage extends BaseClass{

	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	@FindBy(xpath = "//div[@class='item createNewCustomer']")
	private WebElement newCustomerBtn;
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement customerName;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDescription;
	@FindBy(xpath="(//div[text()='- Select Customer -'])[1]")
	private WebElement companyDropdown;
	@FindBy(xpath="//div[text()='Big Bang Company']")
	private WebElement companyName;
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createCustomerBtn;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[@class='title']")
	private WebElement actualCustomer;
	
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void setAddNew() {
		addNewBtn.click();
		
	}
	public void setNewCustomer() {
		newCustomerBtn.click();
	}
	public void setCustomerName(String cn,String cd) {
		customerName.sendKeys(cn);
		customerDescription.sendKeys(cd);
		companyDropdown.click();
		Actions a = new Actions(driver);
		a.moveToElement(companyName).click().perform();
        createCustomerBtn.click();
	}
	public WebElement getActualCustomer() {
		return actualCustomer;
	}
	
	
	
	
}