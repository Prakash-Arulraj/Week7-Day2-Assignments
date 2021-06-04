package wrappers;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
 
import utils.Reporter;

public class BaseDriver extends Reporter implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser " + browser + " is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser " + browser + " launched successfully");
			reportStep("The browser " + browser + " launched successfully", "PASS");
			return true;

		} catch (Exception e) {
			System.err.println("The browser " + browser + " could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> nextWindow = driver.getWindowHandles();
			List<String> secondWindow = new ArrayList<String>(nextWindow);
			String nextWindow1 = secondWindow.get(index);
			driver.switchTo().window(nextWindow1);
			System.out.println("the window of index" + index + "switched");
			reportStep("the window of index" + index + "switched", "PASS");
		} catch (Exception e) {
			System.err.println("the window of index" + index + "could not switched");
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {

		try {
			driver.switchTo().frame(ele);
			System.out.println("switched to frame " + ele + "successfully");
		} catch (Exception e) {
			System.out.println("element could not switched " + ele + "to frame");
		}

	}

	@Override
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("alert to acccept");
		} catch (Exception e) {
			System.out.println("alert not to be accept");
		}

	}

	@Override
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			System.out.println("alert to be dismissed");
		} catch (Exception e) {
			System.out.println("alert could not dismissed");
		}

	}

	@Override
	public String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(getAlertText());
		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void type(WebElement ele, String data) {

		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element " + ele + " is typed with the value " + data);
			reportStep("The element " + ele + " is typed with the value " + data, "PASS");
		} catch (Exception e) {
			System.err.println("The element " + ele + " could not be typed with the value " + data);
		}

	}

	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The element " + ele + " is clicked");
			reportStep("The element " + ele + " is clicked", "PASS");
		} catch (Exception e) {
			System.err.println("The element " + ele + " could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {
		ele.getText();
		return null;
		
		
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)) {
			System.out.println("the element is matched with "+expectedText);
			reportStep("the element is matched with "+expectedText, "PASS");
		}else {
			System.out.println("the element did not matched with "+expectedText);
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		System.out.println(ele.getText());
		System.out.println(expectedText);
		if(ele.getText().contains(expectedText)) {
			System.out.println("the element contains is matched with the text "+expectedText);
			reportStep("the element contains is matched with the text "+expectedText, "PASS");
		}else {
			System.out.println("the element did not contains matched with the text"+expectedText);
		}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator.toLowerCase()) {
			case "id":
				return driver.findElement(By.id(locValue));
			case "name":
				return driver.findElement(By.name(locValue));
			case "link":
				return driver.findElement(By.linkText(locValue));
			case "class":
				return driver.findElement(By.className(locValue));
			case "tag":
				return driver.findElement(By.tagName(locValue));
			case "xpath":
				return driver.findElement(By.xpath(locValue));
			case "css":
				return driver.findElement(By.cssSelector(locValue));
			case "partial":
				return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator " + locator + " with value " + locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		return false;
		
		
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void closeActiveBrowser() {
		try {
			driver.close();
			System.out.println("close the active browser");
			reportStep("close the active browser", "INFO");
		} catch (Exception e) {
			System.err.println("the active browser is already closed,check where it got closed");
		}

	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void typeAndEnter(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data,Keys.ENTER);
			System.out.println("The element " + ele + " is typed and entered with the value " + ele);
		} catch (Exception e) {
			System.err.println("The element " + ele + " could not be typed and entered with the value " + ele);
		}
		
	}

	@Override
	public long takeSanp() {
		long number = (long) Math.floor(Math.random()* 900000000L)+ 10000000L;
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(	src, new File(folder+"/"+number+".png"));
		} catch (IOException e) {
			
		}
		return number;
	}

}
