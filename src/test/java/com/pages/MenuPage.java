package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class MenuPage extends BaseClass {
	public MenuPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-tabs']//child::li")
	private List<WebElement> lnkMenu;

	@FindBy(xpath = "//ul[@class='menu col-sm-4']")
	private List<WebElement> lnkCourse;

	@FindBy(xpath = "//li[@class='dropdown']")
	private List<WebElement> linkSubMenu;
	@FindBy(xpath = "//span[@id='label']")
	private WebElement txtCourse;
	@FindBy(xpath = "//span[@id='label1']")
	private WebElement txtSubCourse;

	public List<WebElement> getLnkMenu() {
		return lnkMenu;
	}

	public List<WebElement> getLnkCourse() {
		return lnkCourse;
	}

	public List<WebElement> getLinkSubMenu() {
		return linkSubMenu;
	}

	public WebElement getTxtCourse() {
		return txtCourse;
	}

	public WebElement getTxtSubCourse() {
		return txtSubCourse;
	}

	public void selectMenu(String menu) {
		for (WebElement menus : getLnkMenu()) {
			String textMenu = getTextFromElement(menus);
			System.out.println(textMenu);
			if (textMenu.equals(menu)) {
				clickElement(menus);
				break;
			}

		}

	}
	public void selectSubMenu(String subMenu) {
			for (WebElement element : getLinkSubMenu()) {
				String text = element.findElement(By.tagName("a")).getText();
				if(text.equals(subMenu)) {
					moveToElement(element);
					break;
				}
			}
			

		
	}

	public void selectCourse(String course) throws InterruptedException {

		for (WebElement menu : getLnkMenu()) {
			String textMenu = getTextFromElement(menu);
			if (textMenu.equals("Single Menus")) {
				WebElement linkCourse = getLnkCourse().get(1).findElement(By.xpath("//a[normalize-space()='"+course+"']"));
				clickElement(linkCourse);
				break;
			} 
			else {
				WebElement linkCourse = getLnkCourse().get(2).findElement(By.xpath("//a[normalize-space()='"+course+"']"));
				clickElement(linkCourse);
				break;
			

		}
		}

		Thread.sleep(5000);

	}

	public String getCourseMsg() {
		String courseMsg = null;

		for (WebElement menus : getLnkMenu()) {
			if(menus.getAttribute("class").equals("active")) {
				if (menus.getText().equals("Single Menus")) {
					courseMsg = getTextFromElement(getTxtCourse());
					break;
				} else {
					courseMsg = getTextFromElement(getTxtSubCourse());
					break;
				}


			}
				
							}

		System.out.println(courseMsg);
		return courseMsg;
	}
}
