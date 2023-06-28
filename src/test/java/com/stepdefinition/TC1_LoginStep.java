package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {
 PageObjectManager pom =new PageObjectManager();
	@Given("User is on the jala academy login page")
	public void userIsOnTheJalaAcademyLoginPage() {
		}

	@When("User should perform login {string} , {string}")
	public void userShouldPerformLogin(String userName, String password) {
		pom.getLoginPage().login(userName, password);
	}
	@Then("User should verify after login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expSuccessmsg) {
		WebElement txtLoginSuccessMsg = pom.getHomePage().getTxtLoginSuccessMsg();
		String actSuccessMsg = getTextFromElement(txtLoginSuccessMsg);
		Assert.assertEquals("Verify after login success msg", expSuccessmsg, actSuccessMsg);
	}

	@Then("User should verify after login error pup-up {string}")
	public void userShouldVerifyAfterLoginErrorPupUp(String expInvalidErrormsg) {
		WebElement txtInvalidErrorMsg = pom.getLoginPage().getTxtInvalidErrorMsg();
		String actInvalidErrormsg = getTextFromElement(txtInvalidErrorMsg);
		Assert.assertEquals("Verify after login error msg", expInvalidErrormsg, actInvalidErrormsg);
	}

	@When("User should click on sign-in button")
	public void userShouldClickOnSignInButton() {
		pom.getLoginPage().clickLogin();
	}

	@Then("User should verify error messages {string},{string}")
	public void userShouldVerifyErrorMessages(String expEmailErrorMsg, String expPasswordErrorMsg) {
		WebElement txtEmailErrorMsg = pom.getLoginPage().getTxtEmailErrorMsg();
		String actEmailErrorMsg = getTextFromElement(txtEmailErrorMsg);
		WebElement txtPasswordErrorMsg = pom.getLoginPage().getTxtPasswordErrorMsg();
		String actPasswordErrorMsg = getTextFromElement(txtPasswordErrorMsg);
		Assert.assertEquals("Verify email error msg", expEmailErrorMsg, actEmailErrorMsg);
		Assert.assertEquals("Verify password error msg", expPasswordErrorMsg, actPasswordErrorMsg);
		
	}

	
	
}
