package com.stepdefinition;

import org.junit.Assert;

import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_MenuStep {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should select menu {string}")
	public void userShouldSelectMenu(String menu) {
		pom.getMenuPage().selectMenu(menu);
	}

	@Then("User should select the course {string}")
	public void userShouldSelectTheCourse(String course) throws InterruptedException {
		pom.getMenuPage().selectCourse(course);
	}
	
	@Then("User should select subMenu {string}")
	public void userShouldSelectSubMenu(String subMenu) {
		pom.getMenuPage().selectSubMenu(subMenu);
	   }




	@Then("User should verify course success msg {string}")
	public void userShouldVerifyCourseSuccessMsg(String expCourseMsg) {
		String actCourseMsg = pom.getMenuPage().getCourseMsg();
		Assert.assertEquals("verify success msg", expCourseMsg, actCourseMsg);
	}

}
