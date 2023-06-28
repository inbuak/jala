package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Inbanesan
 * @see used to generate test jvmReport
 * @date 18-01-2023
 */
public class Reporting extends BaseClass {
	/**
	 * @see used to generate test jvmReport
	 * @param jsonFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {

		File file = new File(getProjectPath() + getPropertyFileValue("jvmPath"));
		Configuration configuration = new Configuration(file, "AdactinBooking");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS", "Windows");
		configuration.addClassifications("Language", "java");
		configuration.addClassifications("Tool", "Selenium");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}
