package pages;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import hooks.TestNgHooks;

public class CreatePage extends TestNgHooks {

	public CreatePage getNumber() {
		driver.switchTo().frame("gsft_main");
		click(locateElement("xpath", "//button[@id='lookup.incident.caller_id']//span[1]"));
		String number = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("incident number is" + number);
		return this;
	}

	public UsersPage clickCallerId() throws InterruptedException {
		click(locateElement("xpath", "//span[@class='icon icon-search']"));
		Thread.sleep(5000);
		return new UsersPage();
	}

	public CreatePage clickDescription(String sentence) {
		switchToWindow(0);
		driver.switchTo().frame("gsft_main");
		type(locateElement("id", "incident.short_description"), sentence);
		return this;
	}

	public IncidentsPage clickSubmit() {
		click(locateElement("xpath", "//button[@type='submit']"));
		return new IncidentsPage();
	}

}
