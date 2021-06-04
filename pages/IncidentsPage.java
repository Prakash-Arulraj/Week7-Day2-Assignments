package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hooks.TestNgHooks;

public class IncidentsPage extends TestNgHooks {

	public IncidentsPage verifyIncidentsPage() {
		verifyPartialTitle("Incidents");
		// driver.findElement(By.xpath("//a[@data-list_id='incident']")).click();
		return this;
	}

	public IncidentsPage clickNumber() {
		driver.switchTo().frame("gsft_main");
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		new Select(forTextNum).selectByIndex(1);
		return this;
	}

	public IncidentsPage typeNumber(String number) {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(number);
		//typeAndEnter(locateElement("xpath", "//input[@placeholder='Search']\\"), number);
		// type(locateElement("xpath", "//input[@placeholder='Search']\"), number);
		return this;
	}

	public IncidentsPage selectBox() {
		click(locateElement("xpath", "//label[@class='checkbox-label']"));
		return this;
	}

	public IncidentsPage clickPriority() {
		click(locateElement("xpath", "//table[@id='incident_table']/thead[1]/tr[1]/th[7]/span[1]/i[1]"));
		return this;
	}

	public IncidentPage updateSelect() {
		click(locateElement("xpath", "//div[text()='Update Selected']"));
		return new IncidentPage();
	}

	public UsersPage clickName() {
		click(locateElement("xpath", "//a[@class='linked']"));
		return new UsersPage();
	}

}
