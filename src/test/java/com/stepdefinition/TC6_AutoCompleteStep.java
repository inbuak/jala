package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC6_AutoCompleteStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should select the value {string}")
	public void userShouldSelectTheValue(String value) {
		pom.getAutoCompletePage().selectValue(value);

	}

	@Then("User should enter letters and verify suggestions have those letters {string}")
	public void userShouldEnterLettersAndVerifySuggestionsHaveThoseLetters(String letters) {
		List<String> listSuggestion = pom.getAutoCompletePage().enterLetters(letters);
		for (String suggestion : listSuggestion) {
			System.out.println(suggestion);
			boolean b = suggestion.toLowerCase().contains(letters);
			Assert.assertTrue(b);
		}
	}

}
