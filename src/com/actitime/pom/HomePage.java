package com.actitime.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.generic.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(id = "logoutLink")
	private WebElement logout;
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement taskMenu;
    public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public void setLogout() {
//		logout.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(logout));
	}
    public void setTaskMenu() {
    	taskMenu.click();
    }
    
}