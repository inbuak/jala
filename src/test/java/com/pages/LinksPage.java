package com.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LinksPage extends BaseClass {
	public LinksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='nav-tabs-custom']//child::li")
	private List<WebElement> lnklinks;
	@FindBy(xpath = "//div[@id='tab_1']//a")
	private List<WebElement> lnkWorking;
	@FindBy(xpath = "//div[@id='tab_2']//a")
	private List<WebElement> lnkBroken;
	@FindBy(xpath = "//div[@id='tab_3']//a")
	private List<WebElement> lnkImage;
	@FindBy(xpath = "//div[@id='tab_4']//a")
	private List<WebElement> lnkStatusCode;

	public List<WebElement> getLnkWorking() {
		return lnkWorking;
	}

	public List<WebElement> getLnkBroken() {
		return lnkBroken;
	}

	public List<WebElement> getLnkImage() {
		return lnkImage;
	}

	public List<WebElement> getLnkStatusCode() {
		return lnkStatusCode;
	}

	public List<WebElement> getLnklinks() {
		return lnklinks;
	}

	public void clickLInks(String links) {
		for (WebElement linkTab : getLnklinks()) {
			String txtTab = getTextFromElement(linkTab);
			if (txtTab.equals(links)) {
				if (!linkTab.getAttribute("class").equals("active")) {
					clickElement(linkTab);
				}
			}

		}

	}

	public void workingLinks(List<String> links) {
		List<WebElement> workingLinks = getLnkWorking();
		for (int i = 0; i < workingLinks.size(); i++) {
			String url = workingLinks.get(i).getAttribute("href");
			if (url != null) {
				clickElement(workingLinks.get(i));
				Set<String> windows = driver.getWindowHandles();
				driver.switchTo().window(windows.toArray()[1].toString());
				String title = driver.getTitle();
				Assert.assertEquals("verify title", links.get(i), title);
				driver.close();
				driver.switchTo().window(windows.toArray()[0].toString());

			}

		}

	}

	public void brokenLinks() throws IOException {
		List<WebElement> brokenLinks = getLnkBroken();
		for (WebElement webElement : brokenLinks) {
			String url = webElement.getAttribute("href");
			if (url != null) {
				URL uRL = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) uRL.openConnection();
				int responseCode = connection.getResponseCode();
				System.out.println(responseCode);
				if (responseCode >= 400) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

		}

	}

	public void imageLinks() throws IOException {
		List<WebElement> imageLinks = getLnkImage();
		for (WebElement webElement : imageLinks) {
			List<WebElement> findElements = webElement.findElements(By.tagName("img"));
			String attribute = findElements.get(0).getAttribute("src");
			System.out.println(attribute);
			if (findElements.size()!=0) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		}

	}

	public void statusCodes(List<String> codes) throws IOException {
		List<WebElement> links = getLnkStatusCode();
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++) {
			String url = links.get(i).getAttribute("href");
			if (url != null) {
				URL uRL = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) uRL.openConnection();
				int actCode = connection.getResponseCode();
				System.out.println(actCode);
				int expCode = Integer.parseInt(codes.get(i));
				Assert.assertEquals("verify code", expCode, actCode);

			}
		}
	}
}
