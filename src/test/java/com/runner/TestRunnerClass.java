package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * 
 * @author Inbanesan
 * @see used to start the execution of test
 * @date 19-06-2023
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = ("@a"), dryRun =false, snippets = SnippetType.CAMELCASE, monochrome = true, plugin = { "pretty",
		"json:target\\index.json" }, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")
public class TestRunnerClass extends BaseClass {

	
/**
 * @see used to generate jvmReport
 * @throws FileNotFoundException
 * @throws IOException
 */
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {

		Reporting.generateJvmReport(getProjectPath() + getPropertyFileValue("jsonPath"));

	}

}
