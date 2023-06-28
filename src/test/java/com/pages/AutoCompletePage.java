package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

import dev.failsafe.Timeout;

public class AutoCompletePage extends BaseClass {

	public AutoCompletePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-tabs']//child::li")
	private List<WebElement> lnkValue;
	@FindBy(id = "txtSingleAutoComplete")
	private WebElement txtSingleAutoComplete;
	@FindBy(id= "txtMultipleAutoComplete")
	private WebElement txtMultipleAutoComplete;
	@FindBy(xpath = "//ul[@id='ui-id-1']")
	private WebElement listSingle;
	@FindBy(xpath = "//ul[@id='ui-id-2']")
	private WebElement listMultiple;

	public List<WebElement> getLnkValue() {
		return lnkValue;
	}

	public WebElement getTxtSingleAutoComplete() {
		return txtSingleAutoComplete;
	}

	public WebElement getTxtMultipleAutoComplete() {
		return txtMultipleAutoComplete;
	}

	public WebElement getListSingle() {
		return listSingle;
	}

	public WebElement getListMultiple() {
		return listMultiple;
	}

	public void selectValue(String value) {
		for (WebElement values : getLnkValue()) {
			String textValue = getTextFromElement(values);
			System.out.println(textValue);
			if (textValue.equals(value)) {
				clickElement(values);
				break;
			}

		}
	}

	public List<String> enterLetters(String letters) {
		Wait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<String> list = new ArrayList<String>();
		for (WebElement values : getLnkValue()) {
			String textValue = getTextFromElement(values);
			if (values.getAttribute("class").equals("active")) {
				if (textValue.equals("Single Values")) {
					sendKeysToElement(getTxtSingleAutoComplete(), letters);
				
					w.until(ExpectedConditions.visibilityOf(getListSingle()));
					List<WebElement> listElements = getListSingle().findElements(By.xpath("//li//div"));
					for (WebElement webElement : listElements) {
						String textFromElement = getTextFromElement(webElement);
						list.add(textFromElement);
					}
					clickElement(listElements.get(0));

				} else {
					sendKeysToElement(getTxtMultipleAutoComplete(), letters);
					w.until(ExpectedConditions.visibilityOf(getListMultiple()));
					List<WebElement> listElements = getListMultiple().findElements(By.xpath("//li//div"));
					for (WebElement webElement : listElements) {
						list.add(getTextFromElement(webElement));
					}

					clickElement(listElements.get(0));

				}
				
			}
		}
		return list;
	}

}
