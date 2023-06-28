package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ToolTipsPage extends BaseClass {
	public ToolTipsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "button")
	private WebElement btnTooltip;

	public WebElement getBtnTooltip() {
		return btnTooltip;
	}

	public String beforeClick() {
		String text = getBtnTooltip().getAttribute("data-original-title");
		return text;
	}
	public String afterClick() {
		clickElement(getBtnTooltip());
		String text = getBtnTooltip().getAttribute("data-original-title");
		return text;
	}

}
