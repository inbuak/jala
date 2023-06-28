package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Inbanesan
 * @see used to maintain all reusable methods
 * @date 18-01-2023
 */
public class BaseClass {
	public static WebDriver driver;
	/**
	 * @see used to take screenshot of a webpage and return as byte[]
	 * @return
	 */
	public byte[] takeWebpageScreenShot() {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}
	/**
	 * @see used to launch the browser
	 * @param browserType
	 */
	public static void getDriver(String browserType) {
//		switch (browserType) {
//		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
//			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();	
//			break;
//		case "ie":
//			WebDriverManager.iedriver().setup();
//			driver=new InternetExplorerDriver();
//			break;
//		case "edge":
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//			break;
//
//		default:
//			break;
//		}
		
	}
	/**
	 * @see used to get project path
	 * @return String
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	/**
	 * @see usedto get the value from property file
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value=(String)object;
		return value;
	}
	/**
	 * @see used to perform keypress and keyrelease actions
	 * @param keyCode
	 * @throws AWTException
	 */
	public void robotKey(int keyCode) throws AWTException {
		Robot robot= new Robot();
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);
	}
	/**
	 * @see usedto write the data to excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	public void writeCellData(String sheetName,int rowNum,int cellNum,String data) throws IOException {
		File file = new File(getProjectPath()+"\\Excel Sheet\\adactinHotel.xlsx");
		FileInputStream inputStream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream outputStream=new FileOutputStream(file);
		workbook.write(outputStream);
	
	}
	/**
	 * @see used to modify data in excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 */
	public void updateCellData(String sheetName,int rowNum,int cellNum,String oldData,String newData) throws IOException {
		File file = new File(getProjectPath()+"\\Excel Sheet\\adactinHotel.xlsx");
		FileInputStream inputStream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if(value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream outputStream=new FileOutputStream(file);
		workbook.write(outputStream);
	}
	/**
	 * @see used to read data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws IOException
	 */
	public String readCellData(String sheetName,int rowNum,int cellNum) throws IOException {
		String res ="";
		File file = new File(getProjectPath()+"\\Excel Sheet\\adactinHotel.xlsx");
		FileInputStream inputStream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(date);
				}else {
					double value = cell.getNumericCellValue();
					long round = Math.round(value);
				    if(value!=round) {
				    	res = String.valueOf(value);
				    }else {
				    	res = String.valueOf(round);
				    }
				  }
			
			break;

		default:
			break;
		}
		return res;
		}
	/**
	 * @see used to enter application url
	 * @param url
	 */
	public static void enterUrl(String url) {
		driver.get(url);
	}
	/**
	 * @see used to close the current window
	 */
	public static void closeWindow() {
		driver.close();
	}
	/**
	 * @see used to quit the browser
	 */
	public static void quitWindow() {
		driver.quit();
	}
	/**
	 * @see used to maximize the window
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	/**
	 * @see used to get the current  window title
	 * @return String
	 */
	public String getWindowTitle() {
		String title = driver.getTitle();
		return title;
	}
	/**
	 * @see used to get the current url
	 * @return String
	 */
	public String getWindowUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	/**
	 * @see used to find webElement in a webPage using id
	 * @param id
	 * @return WebElment
	 */
	public WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	/**
	 * @see used to find webElements in a webPage
	 * @param name
	 * @return List of WebElement
	 */
	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	/**
	 * @see used to find webElement in a webPage using className
	 * @param className
	 * @return WebElment
	 */
	
	public WebElement findElementByClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}
	/**
	 * @see used to find webElement in a webPage using xpath
	 * @param xpath
	 * @return WebElment
	 */
	
	public WebElement findElementByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}
	/**
	 * @see used to find webElement in a webPage using tagName
	 * @param tagName
	 * @return WebElment
	 */
	public WebElement findElementByTagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}
	/**
	 * @see used to clear the textbox in a webPage
	 * @param element
	 */
	public void clearElement(WebElement element) {
		element.clear();
	}
	/**
	 * @see used to click a element in a webPage
	 * @param element
	 */
	public void clickElement(WebElement element) {
		element.click();
	}
	/**
	 * @see used to get text from a WebElement
	 * @param element
	 * @return String
	 */
	public String getTextFromElement(WebElement element) {
		String text = element.getText();
		return  text;
	}
	/**
	 * @see used to pass characters to a text box
	 * @param element
	 * @param data
	 */
	public void sendKeysToElement(WebElement element,String data) {
		element.sendKeys(data);
	}
	/**
	 * @see used to get attribute value of a WebElement
	 * @param element
	 * @return String
	 */
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	/**
	 * @see used to perform right click
	 * @param element
	 */
	public void rightClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * See used to perform double click
	 * @param element
	 */
	public void doubleClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * See used to perform mouse over action
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * See used to perform drag and drop
	 * @param srcElement
	 * @param destElement
	 */
	public void dragAndDrop(WebElement srcElement,WebElement destElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(srcElement,destElement).perform();
	}
	/**
	 * @see used to accept the alert message
	 */
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	/**
	 * @see used to dismiss the alert message
	 */
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 * @see used to get the text from alert box
	 * @return String
	 */
	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}
	/**
	 * @see used to pass characters to alert box
	 * @param data
	 */
	public void sendKeysToAlert(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}
	/**
	 * used to switch into frame using index
	 * @param index
	 */
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to switch into frame using id
	 * @param frameId
	 */
	public void switchToFrameById(String frameId) {
		driver.switchTo().frame(frameId);
	}
	/**
	 * used to switch into frame using element
	 * @param element
	 */
	public void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * used to switch into parent frame 
	 */
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	/**
	 * @see used to take screen shot of a webPage
	 * @param filePathToSave
	 * @throws IOException
	 */
	
	public void takeWebPageScreenShot(String filePathToSave) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePathToSave);
		FileUtils.copyFile(source, destination);
	}
	/**
	 * @see used to pass characters to text box using javaScript
	 * @param data
	 * @param element
	 */
	public void sendKeysByJs(String data,WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}
	/**
	 * @see used to get attribute value of element using javaScript
	 * @param element
	 * @return String
	 */
	public String getAttributeValueByJs(WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor) driver;
		String text= (String) executor.executeScript("return arguments[0].getAttribute('value')", element);
		return text;
	}
	/**
	 * @see used to click element using javaScript
	 * @param element
	 */
	public void clickElementByJs(WebElement element) {
		JavascriptExecutor executor= (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}
	/**
	 * @see used to scroll down to a element
	 * @param uptoElement
	 */
	public void scrollDownByJs(WebElement uptoElement) {
		JavascriptExecutor executor= (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)",uptoElement);
	}
	/**
	 * @see used to scroll up to a element
	 * @param uptoElement
	 */
	public void scrollUpByJs(WebElement uptoElement) {
		JavascriptExecutor executor= (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)",uptoElement);
	}
	/**
	 * @see used to select option from dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectOptionByIndex(WebElement element,int index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * @see select option from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void selectOptionByText(WebElement element,String text ){
		Select select = new Select(element);
		select.selectByVisibleText(text);;
	}
	/**
	 * @see select option from dropdown using value
	 * @param element
	 * @param value
	 */
	public void selectOptionByValue(WebElement element,String value){
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * @see deselect option from dropdown using index
	 * @param element
	 * @param index
	 */
	public void deselectOptionByIndex(WebElement element,int index){
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	/**
	 * @see deselect option from dropdown using visible text
	 * @param element
	 * @param text
	 */
	
	public void deselectOptionByText(WebElement element,String text ){
		Select select = new Select(element);
		select.deselectByVisibleText(text);;
	}
	/**
	 * @see deselect option from dropdown using value
	 * @param element
	 * @param value
	 */
	
	public void deselectOptionByValue(WebElement element,String value){
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	/** 
	 * @see used to deselect all selected options in a dropdown
	 * @param element
	 */
	public void deselectAllOptions(WebElement element){
		Select select = new Select(element);
		select.deselectAll();
	}
	/**
	 * @see used to get the first selected option
	 * @param element
	 * @return WebElement
	 */
	public WebElement getFirstselectOption(WebElement element){
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}
	/**
	 * @see used to get all options from drpdown
	 * @param element
	 * @return List of WebElements
	 */
	
	public List<WebElement> getAllOptions(WebElement element){
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	/**
	 * @see used to get all options as text 
	 * @param element
	 * @return List of WebElement
	 */
	public List<String> getAllOptionsAsText(WebElement element){
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> text = new ArrayList<String>();
		for (WebElement webElement : options) {
			String string = webElement.getText();
			text.add(string);
		}
		return text;
	}
	/**
	 * @see used to get all options as value
	 * @param element
	 * @return List of WebElement
	 */
	public List<String> getAllOptionsAsValue(WebElement element){
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> value = new ArrayList<String>();
		for (WebElement webElement : options) {
			String string = webElement.getAttribute("value");
			value.add(string);
		}
		return value;
	}
	/**
	 * @see used to get all selected options
	 * @param element
	 * @return List of WebElement
	 */
	public List<WebElement> getAllSelectedOptions(WebElement element){
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}
	/**
	 * @see used to check weather dropdown has multiple options
	 * @param element
	 * @return boolean
	 */
	public boolean verifyMutiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	/**
	 * @see used to switch into parent window 
	 */
	public void switchToParentWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list= new ArrayList<String>();
		list.addAll(windowHandles);
		String parentWindow = list.get(0);
		driver.switchTo().window(parentWindow);
	}
	/**
	 * @see used to switch into child window
	 * @param windowNum
	 */
	public void switchToChildWindow(int windowNum) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list= new ArrayList<String>();
		list.addAll(windowHandles);
		String childWindow = list.get(windowNum);
		driver.switchTo().window(childWindow);
	}
	/**
	 * @see used to get all window ids
	 * @return Set of String
	 */
	public Set<String> getAllWindowsId() {
		Set<String> windowIds = driver.getWindowHandles();
		return windowIds;
	}
	/**
	 * @see used to navigate ta a window
	 * @param url
	 */
	public void navigateToWindow(String url) {
		driver.navigate().to(url);
	}
	/**
	 * @see used to navigate to back
	 */
	public void pageBack() {
		driver.navigate().back();
	}
	/**
	 * @see used to navigate to forward
	 */
	public void pageForward() {
		driver.navigate().forward();
	}
	/**
	 * @see used to refresh the page
	 */
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	/**
	 * @see get the row text from a webTable
	 * @param elementTable
	 * @param rowIndex
	 * @return String
	 */
	public String getRowTextFromTable(WebElement elementTable,int rowIndex) {
		List<WebElement> tRow = elementTable.findElements(By.tagName("tr"));
		String text = tRow.get(rowIndex).getText();
		return  text;
	}
	/**
	 * @see get data from webTable
	 * @param elementTable
	 * @param rowIndex
	 * @param columnIndex
	 * @return String
	 */
	public String getDataFromTable(WebElement elementTable,int rowIndex,int columnIndex) {
		List<WebElement> tRow = elementTable.findElements(By.tagName("tr"));
		WebElement elementRow = tRow.get(rowIndex);
		List<WebElement> tData = elementRow.findElements(By.tagName("td"));
		String text = tData.get(columnIndex).getText();
		return text;
	}
	/**
	 * @see maintain implicitly waits based on duration
	 * @param duration
	 * @param timeUnit
	 */
    public void implicitWait(long duration,TimeUnit timeUnit) {
    	driver.manage().timeouts().implicitlyWait(duration, timeUnit);
    }
    /**
     * @see maintain explicitly wait for element to click
     * @param timeOutInSeconds
     * @param element
     */
    public void webdriverWaitForElementClick(long timeOutInSeconds, WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	}
    /**
     * @see maintain explicitly wait for element to select
     * @param timeOutInSeconds
     * @param element
     */
    public void webdriverWaitForElementSelect(long timeOutInSeconds, WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.elementToBeSelected(element));
    	}    
    /**
     * @see maintain explicitly wait for element to visible
     * @param timeOutInSeconds
     * @param element
     */
    
    public void webdriverWaitForElementVisible(long timeOutInSeconds, WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.visibilityOf(element));
    	}
    /**
     * @see maintain explicitly wait for element located by id
     * @param timeOutInSeconds
     * @param element
     */
    
    public void webdriverWaitForElementLocatedById(long timeOutInSeconds, String id) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    	}
    /**
     * @see maintain explicitly wait for element located by name
     * @param timeOutInSeconds
     * @param element
     */
    
    public void webdriverWaitForElementLocatedByName(long timeOutInSeconds, String name) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    	}
    /**
     * @see maintain explicitly wait for element located by className
     * @param timeOutInSeconds
     * @param element
     */
    
    public void webdriverWaitForElementLocatedByClasName(long timeOutInSeconds, String className) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    	}
    /**
     * @see maintain explicitly wait for element located by xpath
     * @param timeOutInSeconds
     * @param element
     */
    
    public void webdriverWaitForElementLocatedByXpath(long timeOutInSeconds, String xpath) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    	}
   }
