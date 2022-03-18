package com.bankproject.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankproject.pageobject.AddCustomerPageObject;
import com.bankproject.utilities.XLUtils;

public class TC_002_MultipleCustomer extends BaseClass {

	@Test(dataProvider = "xldata")
	public void addAllCustomer(String fname, String lname, String passcode) {

		AddCustomerPageObject ac = new AddCustomerPageObject(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ac.clickHomeButton();
		ac.clickMngButton();
		ac.addCustButton();
		ac.setFirstName(fname);
		ac.setLastName(lname);
		ac.setPassCode(passcode);
		ac.clickOnAddCust();

		if (isAlertPresent() == true) {
			Alert a = driver.switchTo().alert();
			String s = a.getText();
			System.out.println(s);
			a.accept();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() {// user define method to check wether alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {

			return false;
		}
	}

	@DataProvider(name = "xldata")
	String[][] getData() throws IOException {

		String path = "F:\\BankFramwork\\com.bankproject.www\\src\\test\\java\\com\\bankproject\\testData\\Test.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colcount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}
		}
		return logindata;
	}

}
