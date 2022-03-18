package com.bankproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPageObject {

	WebDriver rdriver;

	public AddCustomerPageObject(WebDriver ldriver) {

		rdriver = ldriver;

		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//button[@class=\"btn home\"]")
	WebElement home_btn;

	@FindBy(xpath = "//*[text()=\"Bank Manager Login\"]")
	WebElement bank_mng_btn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
	WebElement add_cust_btn;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")
	WebElement first_name;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")
	WebElement last_name;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")
	WebElement postcode;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
	WebElement add_cust;

	public void clickHomeButton() {

		home_btn.click();
	}

	public void clickMngButton() {

		bank_mng_btn.click();
	}

	public void addCustButton() {

		add_cust_btn.click();
	}

	public void setFirstName(String fName) {

		first_name.sendKeys(fName);
	}

	public void setLastName(String lName) {

		last_name.sendKeys(lName);
	}

	public void setPassCode(String passCode) {

		postcode.sendKeys(passCode);
	}

	public void clickOnAddCust() {

		add_cust.click();
	}

}
