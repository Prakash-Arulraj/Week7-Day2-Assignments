package pages;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import hooks.TestNgHooks;

public class UsersPage extends TestNgHooks {

	public UsersPage clickSearch(String name) throws InterruptedException {
		switchToWindow(1);
		typeAndEnter(locateElement("xpath", "//input[@placeholder='Search']"), name);
		Thread.sleep(5000);
		return this;
	}

	public CreatePage clickFirstMatch() {
		click(locateElement("xpath", "//tr[@collapsed='true']//a"));
		return new CreatePage();
	}

	public UsersPage clickDelete() {
		click(locateElement("xpath", "//button[text()='Delete']"));
		return this;
	}
	/*
	 * public IncidentsPage acceptAlert() { Alert alert = driver.switchTo().alert();
	 * System.out.println("Alert: " + alert.getText()); alert.accept(); return new
	 * IncidentsPage(); }
	 */

}
