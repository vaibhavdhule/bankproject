package com.bankproject.testcase;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.bankproject.pageobject.AddCustomerPageObject;

public class TC_001_AddCustomer extends BaseClass {
	@Test
	public void addCustomer() {
		
		AddCustomerPageObject ac = new AddCustomerPageObject(driver);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		ac.clickHomeButton();
		ac.clickMngButton();
		ac.addCustButton();
		ac.setFirstName("abc");
		ac.setLastName("xyz");
		ac.setPassCode("123");
		ac.clickOnAddCust();
		
		Alert a = driver.switchTo().alert();
		
		String text = a.getText();
		
		System.out.println(text);
		
		a.accept();
		
	}

}
