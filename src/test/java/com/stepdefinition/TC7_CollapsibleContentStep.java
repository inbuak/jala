package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC7_CollapsibleContentStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should select the collapse {string}")
	public void userShouldSelectTheCollapse(String collapse) {
		pom.getCollapsibleContent().selectcollapse(collapse);

	}

	@Then("User should click each collapse to verify only one text visible at a time")
	public void userShouldClickEachCollapseToVerifyOnlyOneTextVisibleAtATime() throws InterruptedException {
		boolean singleCollapse = pom.getCollapsibleContent().singleCollapse();
		Assert.assertTrue(singleCollapse);
	}

	@Then("User should click each collapse to verify all text are visible at a time")
	public void userShouldClickEachCollapseToVerifyAllTextAreVisibleAtATime() throws InterruptedException {
		boolean multipleCollapse = pom.getCollapsibleContent().multipleCollapse();
		Assert.assertTrue(multipleCollapse);
	}

}
