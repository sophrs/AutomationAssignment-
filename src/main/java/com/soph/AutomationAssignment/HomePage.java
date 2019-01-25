package com.soph.AutomationAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement linktoform;
	
	public void navtoform() {
		linktoform.click();
	}
	
}
