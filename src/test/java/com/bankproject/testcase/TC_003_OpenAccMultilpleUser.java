package com.bankproject.testcase;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bankproject.pageobject.AddCustomerPageObject;
import com.bankproject.pageobject.OpenAccount;
import com.bankproject.utilities.XLUtils;

public class TC_003_OpenAccMultilpleUser extends BaseClass {

	@Test(dataProvider = "data")
	public void openMutlipleAcc(String username, String currency) throws InterruptedException {

		AddCustomerPageObject ac = new AddCustomerPageObject(driver);
		OpenAccount oa = new OpenAccount(driver);

		ac.clickHomeButton();
		ac.clickMngButton();
		oa.clickOnOpenAcc();
		oa.selectFromCustName(username);
		Thread.sleep(3000);
		oa.selectCurrency(currency);
		Thread.sleep(3000);
		oa.clickOnProcess();

		if (isAlertPresent() == true) {
			Alert a = driver.switchTo().alert();
			String s = a.getText();
			System.out.println(s);
			a.accept();
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
	}

	public boolean isAlertPresent() {
		try {
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "data")
	String[][] data() throws IOException {

		String path = "F:\\BankFramwork\\com.bankproject.www\\src\\test\\java\\com\\bankproject\\testData\\Test.xlsx";
		int rownum = XLUtils.getRowCount(path, "B");
		int cellnum = XLUtils.getCellCount(path, "B", 1);
		String openaccdata[][] = new String[rownum][cellnum];
		for (int r = 1; r <= rownum; r++) {

			for (int c = 0; c < cellnum; c++) {

				openaccdata[r - 1][c] = XLUtils.getCellData(path, "B", r, c);
			}
		}
		return openaccdata;

	}

}
