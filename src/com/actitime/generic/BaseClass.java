package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		Reporter.log("Open Browser",true);
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("Close Browser",true);
		driver.quit();
	}
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("Login",true);
		FileLib f = new FileLib();
	   String url = f.getPropertyData("url");
	   driver.get(url);
	   String un = f.getPropertyData("username");
	   String pw = f.getPropertyData("password");
		LoginPage l = new LoginPage(driver);
		l.setLogin(un, pw);	
	}
	@AfterMethod
	public void logout() {
		Reporter.log("Logout",true);
		HomePage h = new HomePage(driver);
		h.setLogout();
	}
}