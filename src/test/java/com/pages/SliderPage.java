package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SliderPage extends BaseClass {
	public SliderPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='slider-track-high']")
	private WebElement slider;
	@FindBy(xpath = "//div[@class='slider-handle min-slider-handle round']")
	private WebElement sliderHandle;
	@FindBy(xpath = "//span[@id='ex6SliderVal']")
	private WebElement currentPosition;

	public WebElement getSlider() {
		return slider;
	}

	public WebElement getSliderHandle() {
		return sliderHandle;
	}

	public WebElement getCurrentPosition() {
		return currentPosition;
	}

	public void dragSlider(int desiredPosition) {
		int minPosition = Integer.parseInt(getSliderHandle().getAttribute("aria-valuemin"));
		int Position = Integer.parseInt(getSliderHandle().getAttribute("aria-valuenow"));
		int maxPosition = Integer.parseInt(getSliderHandle().getAttribute("aria-valuemax"));
		double relativePosition = ((desiredPosition - Position) / (double) (maxPosition - Position));
		double width = (double) getSlider().getSize().getWidth();
		int offset = (int) (width * relativePosition);
		if(desiredPosition>=minPosition && desiredPosition<=maxPosition) {
			Actions actions = new Actions(driver);
			actions.dragAndDropBy(getSliderHandle(), offset, 0).perform();	
		}else {
			System.out.println("positon value out bound");
		}
		

	}

	public int currentPosition() {
		int currentPosition = Integer.parseInt(getCurrentPosition().getText());
		return currentPosition;

	}

}
