package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CollapsibleContent extends BaseClass {
	public CollapsibleContent() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='nav-tabs-custom']//child::li")
	private List<WebElement> linkCollapse;
	@FindBy(xpath = "//a[@class='collapsed']")
	private List<WebElement> lnkSingleCollapse;
	@FindBy(xpath = "//a[@class='trigger collapsed']")
	private List<WebElement> lnkMultipleCollapse;
	@FindBy(xpath = "//div[@class='panel-body']")
	private List<WebElement> txtPanelBody;

	public List<WebElement> getLinkCollapse() {
		return linkCollapse;
	}

	public List<WebElement> getLnkSingleCollapse() {
		return lnkSingleCollapse;
	}

	public List<WebElement> getLnkMultipleCollapse() {
		return lnkMultipleCollapse;
	}

	public List<WebElement> getTxtPanelBody() {
		return txtPanelBody;
	}

	public void selectcollapse(String collapse) {
		for (WebElement collapses : getLinkCollapse()) {
			String textValue = getTextFromElement(collapses);
			System.out.println(textValue);
			if (textValue.equals(collapse)) {
				if (!collapses.getAttribute("class").equals("active"))
					clickElement(collapses);
				break;
			}

		}

	}

	public boolean singleCollapse() throws InterruptedException {
		int count = 0;
		Thread.sleep(1000);
		List<WebElement> singleCollapse = getLnkSingleCollapse();
		for (WebElement collapse : singleCollapse) {
			clickElement(collapse);
			Thread.sleep(1000);
		}
		List<WebElement> txtPanelBody = getTxtPanelBody();
		for (WebElement webElement : txtPanelBody) {
			if (webElement.isDisplayed()) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean multipleCollapse() throws InterruptedException {
	int count=0;
	Thread.sleep(1000);
	List<WebElement> multipleCollapse = getLnkMultipleCollapse();
	for (WebElement collapse : multipleCollapse) {
		clickElement(collapse);
		Thread.sleep(1000);
	}
	List<WebElement> txtPanelBody = getTxtPanelBody();
	for (WebElement webElement : txtPanelBody) {
		if (webElement.isDisplayed()) {
			count++;
		}
	}
	if(count>1) {
		return true;
	}else {
		return false;
	}
	}
}
