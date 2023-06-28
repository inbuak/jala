package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchEmployeePage extends BaseClass {
	
	public SearchEmployeePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h3")
	private WebElement txtSearch;
	@FindBy(id= "Name")
	private WebElement txtName;
	@FindBy(id = "MobileNo")
	private WebElement txtMobileNo;
	@FindBy(id = "btnSearch")
	private WebElement btnSearch;
	@FindBy(tagName = "tbody")
	private WebElement tbody;
	@FindBy(xpath = "//a[text()='Edit']")
	private WebElement btnEdit;
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement btnDelete;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYes;
	@FindBy(id = "FirstName")
	private WebElement txtFirstName;
	@FindBy(tagName = "button")
	private WebElement btnUpdate;
	@FindBy(className = "toast-title")
	private WebElement txSuccessMsg;
	@FindBy(xpath = "//td[contains(text(),'No')]")
	private WebElement txtErrorMsg;
	

	public WebElement getTxtSearch() {
		return txtSearch;
	}


	public WebElement getTxtName() {
		return txtName;
	}


	public WebElement getTxtMobileNo() {
		return txtMobileNo;
	}


	public WebElement getBtnSearch() {
		return btnSearch;
	}


	public WebElement getTbody() {
		return tbody;
	}


	public WebElement getBtnEdit() {
		return btnEdit;
	}


	public WebElement getBtnDelete() {
		return btnDelete;
	}


	public WebElement getTxtFirstName() {
		return txtFirstName;
	}


	public WebElement getBtnUpdate() {
		return btnUpdate;
	}


	public WebElement getTxSuccessMsg() {
		return txSuccessMsg;
	}
	
	
	
	public WebElement getTxtErrorMsg() {
		return txtErrorMsg;
	}


	public WebElement getBtnYes() {
		return btnYes;
	}


	public void searchEmployee() {
		clickElement(getBtnSearch());

	}
	public void searchEmployee(String name,String mobile) throws InterruptedException {
		sendKeysToElement(getTxtName(), name);
		sendKeysToElement(getTxtMobileNo(), mobile);
		clickElement(getBtnSearch());
		Thread.sleep(3000);
   }
	public void searchEmployee(String name) throws InterruptedException {
		sendKeysToElement(getTxtName(), name);
		clickElement(getBtnSearch());
		Thread.sleep(3000);
		

	}
	public void searchEmployeeWithMobile(String mobile) throws InterruptedException {
		sendKeysToElement(getTxtMobileNo(), mobile);
		clickElement(getBtnSearch());
		Thread.sleep(3000);
		

	}
	public List<String> getAllFirstName() {
		List<String> allValues= new ArrayList<String>();
		List<WebElement> tRow = getTbody().findElements(By.tagName("tr"));
		for (int i = 0; i < tRow.size(); i++) {
	    List<WebElement> tData = tRow.get(i).findElements(By.tagName("td"));	
		String text = tData.get(0).getText();
		System.out.println(text);
		allValues.add(text);
		}
		return allValues ;
		

	}
	public List<String> getAllFullName() {
		List<String> allValues= new ArrayList<String>();
		List<WebElement> tRow = getTbody().findElements(By.tagName("tr"));
		for (int i = 0; i < tRow.size(); i++) {
	    List<WebElement> tData = tRow.get(i).findElements(By.tagName("td"));	
		String text = tData.get(0).getText()+tData.get(1).getText();
		System.out.println(text);
		allValues.add(text);
		}
		return allValues ;
		
}
	public List<String> getAllMobileNumber() {
		List<String> allValues= new ArrayList<String>();
		List<WebElement> tRow = getTbody().findElements(By.tagName("tr"));
		for (int i = 0; i < tRow.size(); i++) {
	    List<WebElement> tData = tRow.get(i).findElements(By.tagName("td"));	
		String text = tData.get(2).getText();
		System.out.println(text);
		allValues.add(text);
		}
		return allValues ;
		
		
	}
	public void performDelete() {
		clickElement(getBtnDelete());
		clickElement(getBtnYes());

	}
	
	
	
	

}
