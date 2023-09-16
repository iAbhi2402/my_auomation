package com.actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
     @Listeners(com.actitime.generic.ListnerImplementation.class)
     public class CustomerModule extends BaseClass{
   @Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException {
		Reporter.log("Create Customer",true);
		FileLib f = new FileLib();
		String cn = f.getExcelData("Sheet1",1,4);
		String cd = f.getExcelData("Sheet1",1,5);
		HomePage h = new HomePage(driver);
	    h.setTaskMenu();
	    TaskListPage t = new TaskListPage(driver);
	    t.setAddNew();
	    t.setNewCustomer();
	    t.setCustomerName(cn,cd);	
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	    wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomer(),cn));
	    String actualText = t.getActualCustomer().getText();
	    Assert.assertEquals(actualText,cn);
	}
}