package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CreateEmployeePage extends BaseClass {

	public CreateEmployeePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	private WebElement txtFirstName;
	@FindBy(id = "LastName")
	private WebElement txtlastName;
	@FindBy(id = "EmailId")
	private WebElement txtMailId;
	@FindBy(id = "MobileNo")
	private WebElement txtMobileNum;
	@FindBy(id = "DOB")
	private WebElement txtDOB;
	@FindBy(name = "rdbGender")
	private List<WebElement> rdbGender;
	@FindBy(id = "Address")
	private WebElement txtAddress;
	@FindBy(id = "CountryId")
	private WebElement ddnCountry;
	@FindBy(id = "CityId")
	private WebElement ddnCity;
	@FindBy(xpath = "//span[@class='checkmark']")
	private WebElement chkOtherCity;
	@FindBy(id = "OtherCity")
	private WebElement txtOtherCity;
	@FindBy(xpath = "//div[@class='col-sm-3']")
	private List<WebElement> chkSkills;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;
	@FindBy(xpath = "//span[@for='FirstName']")
	private WebElement txtFirstErrormsg;
	@FindBy(xpath = "//span[@for='LastName']")
	private WebElement txtLastErrormsg;
	@FindBy(xpath = "//span[@for='EmailId']")
	private WebElement txtMailtErrormsg;
	@FindBy(xpath = "//span[@for='MobileNo']")
	private WebElement txtMobileErrormsg;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtlastName() {
		return txtlastName;
	}

	public WebElement getTxtMailId() {
		return txtMailId;
	}

	public WebElement getTxtMobileNum() {
		return txtMobileNum;
	}

	public WebElement getTxtDOB() {
		return txtDOB;
	}

	public List<WebElement> getRdbGender() {
		return rdbGender;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getDdnCountry() {
		return ddnCountry;
	}

	public WebElement getDdnCity() {
		return ddnCity;
	}

	public WebElement getChkOtherCity() {
		return chkOtherCity;
	}

	public WebElement getTxtOtherCity() {
		return txtOtherCity;
	}

	public List<WebElement> getChkSkills() {
		return chkSkills;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	

	public WebElement getTxtFirstErrormsg() {
		return txtFirstErrormsg;
	}

	public WebElement getTxtLastErrormsg() {
		return txtLastErrormsg;
	}

	public WebElement getTxtMailtErrormsg() {
		return txtMailtErrormsg;
	}

	public WebElement getTxtMobileErrormsg() {
		return txtMobileErrormsg;
	}

	public void createEmployeeCommonStep(String firstName, String lastName, String mailId, String mobileNum) {
		sendKeysToElement(getTxtFirstName(), firstName);
		sendKeysToElement(getTxtlastName(), lastName);
		sendKeysToElement(getTxtMailId(), mailId);
		sendKeysToElement(getTxtMobileNum(), mobileNum);

	}

	public void createEmployee(String firstName, String lastName, String mailId, String mobileNum) {
		createEmployeeCommonStep(firstName, lastName, mailId, mobileNum);
		createEmployee();

	}

	public void createEmployee(String firstName, String lastName, String mailId, String mobileNum, String DOB,
			String gender, String address, String country, String city, List<String> skills)
			throws InterruptedException {
		createEmployeeCommonStep(firstName, lastName, mailId, mobileNum);
		sendKeysToElement(getTxtDOB(), DOB);
		for (WebElement rdbGender : getRdbGender()) {
			String rdbValue = rdbGender.getAttribute("id");
			if (rdbValue.equals("rdb" + gender)) {
				clickElement(rdbGender);
				break;
			}

		}
		sendKeysToElement(getTxtAddress(), address);
		selectOptionByText(getDdnCountry(), country);
		List<String> cities = new ArrayList<String>();
		List<WebElement> allcities = getAllOptions(getDdnCity());
		for (WebElement webElement : allcities) {
			cities.add(webElement.getText());
		}
		if (cities.contains(city)) {
			selectOptionByText(getDdnCity(), city);
		} else {
			clickElement(getChkOtherCity());
			sendKeysToElement(getTxtOtherCity(), city);
		}

		for (int i = 0; i < getChkSkills().size(); i++) {
			String skill = getChkSkills().get(i).getText();
			if (skills.contains(skill)) {
				getChkSkills().get(i).click();
			}

		}
		Thread.sleep(5000);

		createEmployee();

	}

	public void createEmployee() {
		clickElement(getBtnSave());

	}
}
