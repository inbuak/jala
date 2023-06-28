package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.tlh.ach;

public class TC8_ToolTipsStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify message before click {string}")
	public void userShouldVerifyMessageBeforeClick(String expMsg) {
		String actMsg = pom.getToolTipsPage().beforeClick();
		Assert.assertEquals("verify before msg", expMsg, actMsg);

	}

	@Then("User should click on button and verify mesage {string}")
	public void userShouldClickOnButtonAndVerifyMesage(String expMsg) {
		String actMsg = pom.getToolTipsPage().afterClick();
		Assert.assertEquals("verify before msg", expMsg, actMsg);

	}

	@Then("User should move slider to desired position {int}")
	public void userShouldMoveSliderToDesiredPosition(Integer desiredPosition) {
		pom.getSliderPage().dragSlider(desiredPosition.intValue());

	}

	@Then("User should verify the position {int}")
	public void userShouldVerifyThePosition(Integer expPosition) {
		int actPosition = pom.getSliderPage().currentPosition();
		Assert.assertEquals("verify position ", expPosition.intValue(), actPosition);
	}

}
