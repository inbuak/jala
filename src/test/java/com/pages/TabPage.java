package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.BaseClass;

public class TabPage extends BaseClass{
	public TabPage() {
		PageFactory.initElements(driver,this);
	
	}
	@FindBy(xpath="//div[@class='nav-tabs-custom']//child::li")
	private List<WebElement> linkTabs;
	@FindBy(xpath="//div[@class='tab-pane active']/p")
	private WebElement txtPara;
	
	public WebElement getTxtPara() {
		return txtPara;
	}
	public List<WebElement> getLinkTabs() {
		return linkTabs;
	}
	public void cilcktab(String tab) {
		for (WebElement linkTab :getLinkTabs()) {
			String txtTab = getTextFromElement(linkTab);
			if(txtTab.equals(tab)) {
				if(!linkTab.getAttribute("class").equals("active"))
				{
					clickElement(linkTab);
				}
			}
			
		}

	}
	

}
