package com.stepdefinition;

import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.List;

import com.manager.PageObjectManager;

import io.cucumber.datatable.DataTable;

public class TC9_LinksStep {
	PageObjectManager pom =new PageObjectManager();
	
	@Then("User should select the links {string}")
	public void userShouldSelectTheLinks(String links) {
		pom.getLinksPage().clickLInks(links);
	}
	@Then("User should vrify all links are working links")
	public void userShouldVrifyAllLinksAreWorkingLinks(DataTable dataTable) {
		List<String> links = dataTable.asList();
		pom.getLinksPage().workingLinks(links);
	}



	@Then("User should veriy all links are broken links")
	public void userShouldVeriyAllLinksAreBrokenLinks() throws IOException {
		pom.getLinksPage().brokenLinks();
	}



	@Then("User should verify all links are image links")
	public void userShouldVerifyAllLinksAreImageLinks() throws IOException {
		pom.getLinksPage().imageLinks();
	}

	@Then("user should verify all status codes")
	public void userShouldVerifyAllStatusCodes(DataTable dataTable) throws IOException {
		List<String> list = dataTable.asList();
		pom.getLinksPage().statusCodes(list);
	}





}
