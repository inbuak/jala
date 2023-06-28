package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Then;

public class TC2_CreateEmployeeStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should click on create employee menu")
	public void userShouldClickOnCreateEmployeeMenu() {
		pom.getHomePage().createEmployee();
	}

	@Then("User should create employee with mandatory fields {string},{string},{string},{string}")
	public void userShouldCreateEmployeeWithMandatoryFields(String firstName, String lastName, String mailId,
			String mobileNum) {
		pom.getCreateEmployeePage().createEmployee(firstName, lastName, mailId, mobileNum);
	}

	@Then("User should create employee all fields {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userShouldCreateEmployeeAllFields(String firstName, String lastName, String mailId, String mobileNum,
			String DOB, String gender, String address, String country, String city,
			DataTable dataTable) throws InterruptedException {
		List<String> skills = dataTable.asList();
		pom.getCreateEmployeePage().createEmployee(firstName, lastName, mailId, mobileNum, DOB, gender, address, country, city,skills);
		

	}

	@Then("User should click on save button")
	public void userShouldClickOnSaveButton() {
		pom.getCreateEmployeePage().createEmployee();
	}

	@Then("User should verify create employee success message {string}")
	public void userShouldVerifyCreateEmployeeSuccessMessage(String expSuccessMsg) throws InterruptedException {
		Thread.sleep(5000);
		WebElement txtSearch = pom.getSearchEmployeePage().getTxtSearch();
		String actSuccessMsg = getTextFromElement(txtSearch);
		Assert.assertEquals("verify create employee success msg", expSuccessMsg, actSuccessMsg);
	}

	@Then("User should verify create employee error messages {string},{string},{string},{string}")
	public void userShouldVerifyCreateEmployeeErrorMessages(String string, String string2, String string3,
			String string4) {
		String[] expErrorMsgs= {string,string2,string3,string4};
		String textFromElement = getTextFromElement(pom.getCreateEmployeePage().getTxtFirstErrormsg());
		String textFromElement2 = getTextFromElement(pom.getCreateEmployeePage().getTxtLastErrormsg());
		String textFromElement3 = getTextFromElement(pom.getCreateEmployeePage().getTxtMailtErrormsg());
		String textFromElement4 = getTextFromElement(pom.getCreateEmployeePage().getTxtMobileErrormsg());
		String[] actErrorMsgs= {textFromElement,textFromElement2,textFromElement3,textFromElement4};
		
		
		Assert.assertArrayEquals("verify error msgs", expErrorMsgs, actErrorMsgs);
	}

}
