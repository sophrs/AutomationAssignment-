package com.soph.AutomationAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage {
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement countryButton;
	
	@FindBy(xpath ="//*[@id=\"nameInput\"]")
	private WebElement emailInput;
	
	@FindBy(xpath = "//*[@id=\"passInput\"]")
	
	private WebElement firstPasswordInput;
	
	@FindBy(xpath = "//*[@id=\"passInput2\"]")
	private WebElement secondPasswordInput;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement unitedKingdom;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement france;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement germany;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submitbutton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement successtitle;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/p[10]")
	private WebElement passwordunmatch;
	
	public void selectCountry(String country) {
		countryButton.click();
		if(country.equals("United Kingdom")) {
			unitedKingdom.click();
		}
		else if(country.equals("France")) {
			france.click();
		}
		else {
			germany.click();
		}
	}
	
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void enterPassword1(String password) {
		firstPasswordInput.sendKeys(password);
	}
	
	public void enterPassword2(String password) {
		secondPasswordInput.sendKeys(password);
		submitbutton.click();
	}
	
	public String getsuccesswords() {
		return successtitle.getText();
	}
	
	public String getpasswordfail() {
		return passwordunmatch.getText();
	}

}
