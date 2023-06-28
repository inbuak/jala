package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private WebElement txtLoginSuccessMsg;
	@FindBy(xpath = "//a[normalize-space()='Employee']")
	private WebElement lnkEmployeeMenu;
	@FindBy(xpath = "//a[normalize-space()='Create']")
	private WebElement lnkCreateEmployee;
	@FindBy(xpath = "//a[normalize-space()='Search']")
	private WebElement lnkSearchEmployee;
	@FindBy(xpath = "//a[normalize-space()='More']")
	private WebElement lnkMoreMenu;
	@FindBy(xpath = "//li[@class='treeview menu-open']//ul[@class='treeview-menu']")
	private WebElement listMenu;

	public WebElement getLnkMoreMenu() {
		return lnkMoreMenu;
	}

	public WebElement getListMenu() {
		return listMenu;
	}

	public WebElement getTxtLoginSuccessMsg() {
		return txtLoginSuccessMsg;
	}

	public WebElement getLnkEmployeeMenu() {
		return lnkEmployeeMenu;
	}

	public WebElement getLnkCreateEmployee() {
		return lnkCreateEmployee;
	}

	public WebElement getLnkSearchEmployee() {
		return lnkSearchEmployee;
	}

	public void createEmployee() {
		clickElement(getLnkEmployeeMenu());
		clickElement(getLnkCreateEmployee());
	}

	public void searchEmployee() {
		clickElement(getLnkEmployeeMenu());
		clickElement(getLnkSearchEmployee());

	}

	public void clickMenu(String menu) {
		clickElement(getLnkMoreMenu());
		WebElement lnkMenu = getListMenu().findElement(By.xpath("//a[normalize-space()='" + menu + "']"));
		clickElement(lnkMenu);
		
	}

}
