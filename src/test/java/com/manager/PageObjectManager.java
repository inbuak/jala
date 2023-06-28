package com.manager;

import com.pages.AutoCompletePage;
import com.pages.CollapsibleContent;
import com.pages.CreateEmployeePage;
import com.pages.HomePage;
import com.pages.LinksPage;
import com.pages.LoginPage;
import com.pages.MenuPage;
import com.pages.SearchEmployeePage;
import com.pages.SliderPage;
import com.pages.TabPage;
import com.pages.ToolTipsPage;

/**
 * 
 * @author Inbanesan
 * @see used to create pages object
 * @date 18-01-2023
 *
 */
public class PageObjectManager {
	private LoginPage loginPage;
	private HomePage homePage;
	private CreateEmployeePage createEmployeePage;
	private SearchEmployeePage searchEmployeePage;
	private TabPage tabPage;
	private MenuPage menuPage;
	private AutoCompletePage autoCompletePage;
	private CollapsibleContent collapsibleContent;
	private ToolTipsPage toolTipsPage;
	private SliderPage sliderPage;
	private LinksPage linksPage;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage() : homePage;
	}

	public CreateEmployeePage getCreateEmployeePage() {
		return (createEmployeePage == null) ? createEmployeePage = new CreateEmployeePage() : createEmployeePage;
	}

	public SearchEmployeePage getSearchEmployeePage() {
		return (searchEmployeePage == null) ? searchEmployeePage = new SearchEmployeePage() : searchEmployeePage;
	}

	public TabPage getTabPage() {
		return (tabPage == null) ? tabPage = new TabPage() : tabPage;
	}

	public MenuPage getMenuPage() {
		return (menuPage == null) ? menuPage = new MenuPage() : menuPage;
	}

	public AutoCompletePage getAutoCompletePage() {
		return (autoCompletePage == null) ? autoCompletePage = new AutoCompletePage() : autoCompletePage;
	}

	public CollapsibleContent getCollapsibleContent() {
		return (collapsibleContent == null) ? collapsibleContent = new CollapsibleContent() : collapsibleContent;
	}

	public ToolTipsPage getToolTipsPage() {
		return (toolTipsPage == null) ? toolTipsPage = new ToolTipsPage() : toolTipsPage;
	}

	public SliderPage getSliderPage() {
		return (sliderPage == null) ? sliderPage = new SliderPage() : sliderPage;
	}

	public LinksPage getLinksPage() {
		return (linksPage==null) ? linksPage=new LinksPage() : linksPage;
	}
	

}
