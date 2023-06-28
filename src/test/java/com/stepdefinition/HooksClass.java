package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Inbanesan
 * @see used to maintain blocks of code that can run before or after each scenario
 * @date 18-1-2023
 */
public class HooksClass extends BaseClass {
	/**
	 * @see used to get adactin page
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException  {
		getDriver(getPropertyFileValue("browser"));
		enterUrl(getPropertyFileValue("url"));
		maximizeWindow();
		implicitWait(10, TimeUnit.SECONDS);

		
	}

	/**
	 * @see used to take snapshot of output and quit the browser
	 * @param scenario
	 */
	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(takeWebpageScreenShot(), "image/png", "Output SnapShot");

		quitWindow();
	}

}
