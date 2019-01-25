package com.soph.AutomationAssignment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationTestSteps {
	
	
	private WebDriver driver;
	ExtentTest test;

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test = RegistrationRunner.report.startTest("Registration Test");
	}
	
	@After
	public void teardown() {
		driver.quit();
		RegistrationRunner.report.endTest(test);
	}
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application()  {
		driver.get(Constants.React_Application);
		test.log(LogStatus.INFO,"navigated to application correctly");
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form()  {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.navtoform();
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1)  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.selectCountry(arg1);
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1) {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.enterEmail(arg1);
	}
	

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1)  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.enterPassword1(arg1);
		
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1)  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.enterPassword2(arg1);
	
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message()  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		
		if(form.getsuccesswords().equals("Success!")) {
			test.log(LogStatus.PASS, "registration was a success!");
		}
		else {
			test.log(LogStatus.FAIL, "registration was a fail");
		}
		
		assertEquals("Success!", form.getsuccesswords());
		
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1)  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		form.enterPassword2(arg1);
		
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match()  {
		FormPage form = PageFactory.initElements(driver, FormPage.class);
		if(form.getpasswordfail().equals("The passwords do not match")) {
			test.log(LogStatus.PASS,"the passwords dont match");
		}
		else {
			test.log(LogStatus.FAIL, "the passwords do match");
		}
		assertEquals("The passwords do not match", form.getpasswordfail());
		
	
	}
}
