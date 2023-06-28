package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_TapStep  extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	@Then("User should select a menu in Home page {string}")
	public void userShouldSelectAMenuInHomePage(String menu)  {
		pom.getHomePage().clickMenu(menu);
	  }
	@Then("User should select tab {string}")
	public void userShouldSelectTab(String tab) {
		pom.getTabPage().cilcktab(tab);
	  }
	@Then("User should verify text {string}")
	public void userShouldVerifyText(String expText) {
	String actText = getTextFromElement(pom.getTabPage().getTxtPara());
	boolean b = actText.contains(expText);
	Assert.assertTrue("verify text msg",b);
	
	  }




}
