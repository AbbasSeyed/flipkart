package org.base.flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartBase {
	
	public static WebDriver driver;
	public static HashMap<String,String> hm;

	public void excelText() {
		File f = new File(
				"C:\\Users\\SEYED ABBAS\\eclipse-workspace\\TestNgClass\\src\\test\\resources\\TestNg\\Inputs.xlsx");
		try {
			hm = new HashMap<String, String>();
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(f);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(0);
			ArrayList<String> head = new ArrayList<String>();
			for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
				Cell cell = row.getCell(i);
				head.add(cell.getStringCellValue());
			}
			ArrayList<String> value = new ArrayList<String>();
			Row row1 = sheet.getRow(1);
			for (int j = 0; j < row1.getPhysicalNumberOfCells(); j++) {
				Cell cell = row1.getCell(j);
				value.add(cell.getStringCellValue());

			}

			for (int k = 0; k < head.size(); k++) {
				hm.put(head.get(k), value.get(k));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void lounchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	public void manage() {
		driver.manage().window().maximize();
	}

	public void openurl(String url) {
		driver.get(url);
	}

	public void getUrl() {
		driver.getCurrentUrl();
	}

	public void closebrowser() {
		driver.close();
	}

	public void wait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public void navigateUrl() {
		driver.navigate();
	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void sendkeyes(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void clear(WebElement element) {
		element.clear();
	}

	public void submit(WebElement element) {
		element.submit();
	}

	public void getText(WebElement element) {
		element.getText();
	}

	public void doubleClick(WebElement element) {
		Actions acc = new Actions(driver);
		acc.doubleClick().perform();
	}

	public void rightClick(WebElement element) {
		Actions acc = new Actions(driver);
		acc.contextClick().perform();
	}

	public void moveElement(WebElement element) {
		Actions acc = new Actions(driver);
		acc.moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement place) {
		Actions acc = new Actions(driver);
		acc.dragAndDrop(source, place).perform();
	}

	public void clickAndHold(WebElement source, WebElement place) {
		Actions acc = new Actions(driver);
		acc.clickAndHold(source).moveToElement(place).release().perform();
	}

	public void windowsHandle(int windowsNumber) {
		Set<String> window = driver.getWindowHandles();
		List<String> wind = new ArrayList<>(window);
		driver.switchTo().window(wind.get(windowsNumber));

	}

	public void screenshort(String name) {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
		File save = new File("C:\\NewFile\\" + name + ".png");
		try {
			FileHandler.copy(file, save);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alerts(String alerts, String value) {
		if (alerts.equalsIgnoreCase("accept")) {
			Alert click = driver.switchTo().alert();
			click.accept();
		} else if (alerts.equalsIgnoreCase("dismiss")) {
			Alert click = driver.switchTo().alert();
			click.dismiss();
		} else if (alerts.equalsIgnoreCase("send")) {
			Alert click = driver.switchTo().alert();
			click.sendKeys(value);
		}
	}

	public void scrollMove() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo[0],document.body.scrollHeight");
	}

	public void scrollClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void scrollElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
