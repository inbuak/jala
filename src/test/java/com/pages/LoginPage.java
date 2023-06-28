package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * 
 * @author Inbanesan
 * @see used to maintain Login page elements and methods
 * @date 19/06/23
 * 
 *
 */
public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="UserName")
	private WebElement txtUserName;
	@FindBy(id="Password")
	private WebElement txtPassword;
	@FindBy(id="btnLogin")
	private WebElement btnLogin;
	@FindBy(xpath="//span[contains(text(),'Please enter email')]")
	private WebElement txtEmailErrorMsg;
	@FindBy(xpath="//span[contains(text(),'Please enter pass')]")
	private WebElement txtPasswordErrorMsg;
	@FindBy(xpath="//div[contains(text(),'Invalid ')]")
	private WebElement txtInvalidErrorMsg;
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public WebElement getTxtEmailErrorMsg() {
		return txtEmailErrorMsg;
	}
	public WebElement getTxtPasswordErrorMsg() {
		return txtPasswordErrorMsg;
	}
	public WebElement getTxtInvalidErrorMsg() {
		return txtInvalidErrorMsg;
	}
	public void login(String userName,String password) {
		sendKeysToElement(getTxtUserName(), userName);
		sendKeysToElement(getTxtPassword(), password);
		clickLogin();
   }
	public void clickLogin() {
		clickElement(getBtnLogin());

	}
	
	
	
	
	

}
