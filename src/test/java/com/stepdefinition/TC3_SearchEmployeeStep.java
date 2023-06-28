package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SearchEmployeeStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should search employee all fields {string},{string}")
	public void userShouldSearchEmployeeAllFields(String name, String mobile) throws InterruptedException {
		pom.getSearchEmployeePage().searchEmployee(name, mobile);
	}

	@Then("User should verify all first name {string}")
	public void userShouldVerifyAllFirstName(String expFirstName) {
		List<String> allFirstName = pom.getSearchEmployeePage().getAllFirstName();
		for (String actFirstName : allFirstName) {
			Assert.assertEquals("verify first name", expFirstName, actFirstName);
			
		}
		
	}

	@Then("User should verify all mobile number {string}")
	public void userShouldVerifyAllMobileNumber(String expMobileNum) {
		List<String> allMobileNumber = pom.getSearchEmployeePage().getAllMobileNumber();
		for (String actMobileNum : allMobileNumber) {
			Assert.assertEquals("verify mobile number", expMobileNum, actMobileNum);	
		}
	}

	@Then("User should click on search employee menu")
	public void userShouldClickOnSearchEmployeeMenu() {
		pom.getHomePage().searchEmployee();

	}

	@Then("User should search employee only with mobile {string}")
	public void userShouldSearchEmployeeOnlyWithMobile(String mobile) throws InterruptedException {
		pom.getSearchEmployeePage().searchEmployeeWithMobile(mobile);
	}

	@Then("User should search employee only with firstName {string}")
	public void userShouldSearchEmployeeOnlyWithFirstName(String firstName) throws InterruptedException {
		pom.getSearchEmployeePage().searchEmployee(firstName);
	}

	@Then("User should search employee only with fullName {string}")
	public void userShouldSearchEmployeeOnlyWithFullName(String fullName) throws InterruptedException {
		pom.getSearchEmployeePage().searchEmployee(fullName);
	}

	@Then("User should verify all full name {string}")
	public void userShouldVerifyAllFullName(String expFullName) {
		List<String> allFullName = pom.getSearchEmployeePage().getAllFullName();
		for (String actFullName : allFullName) {
			Assert.assertEquals("verify full name", expFullName, actFullName);
			
			
		}
	}

	@Then("User should verify message {string}")
	public void userShouldVerifyMessage(String expMsg) {
		String actMsg = getTextFromElement(pom.getSearchEmployeePage().getTxtErrorMsg());
		Assert.assertEquals("verify error msg", expMsg, actMsg);
	}

	@Then("User should click on edit button")
	public void userShouldClickOnEditButton() {
		clickElement(pom.getSearchEmployeePage().getBtnEdit());
	}

	@Then("User should click on delete button")
	public void userShouldClickOnDeleteButton() {
		pom.getSearchEmployeePage().performDelete();
	}

	@Then("User should verify success edit message {string}")
	public void userShouldVerifySuccessEditMessage(String expSuccessMsg) {
		String actSuccessMsg = pom.getSearchEmployeePage().getTxSuccessMsg().getText();
		Assert.assertEquals("verify Success msg", expSuccessMsg, actSuccessMsg);
	}

	@Then("User should verify success delete message {string}")
	public void userShouldVerifySuccessDeleteMessage(String expSuccessMsg) {
		String actSuccessMsg = pom.getSearchEmployeePage().getTxSuccessMsg().getText();
		Assert.assertEquals("verify Success msg", expSuccessMsg, actSuccessMsg);
	}
	
	@Then("User should update details")
	public void userShouldUpdateDetails() {
		clickElement(pom.getSearchEmployeePage().getBtnUpdate());
	   }




}
