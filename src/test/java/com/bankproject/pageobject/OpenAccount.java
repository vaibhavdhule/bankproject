package com.bankproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccount {

	WebDriver ldriver;

	public OpenAccount(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
	WebElement open_acc;

	@FindBy(xpath = "//*[@id=\"userSelect\"]")
	WebElement cust_name;

	@FindBy(xpath = "//*[@id=\"currency\"]")
	WebElement curency;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
	WebElement process;

	public void clickOnOpenAcc() {

		open_acc.click();

	}

	public void selectFromCustName(String custname) {

		Select s = new Select(cust_name);
	
		s.selectByVisibleText(custname);
		
	}

	public void selectCurrency(String currency) {

		Select s = new Select(curency);

		s.selectByVisibleText(currency);

	}

	public void clickOnProcess() {

		process.click();
	}

}
