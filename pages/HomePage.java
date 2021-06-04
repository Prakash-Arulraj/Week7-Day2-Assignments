package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;

public class HomePage extends TestNgHooks {

	public HomePage verifyHomePage() {
		verifyPartialText(locateElement("xpath", "//a[@data-original-title='ServiceNow Home Page']"), "ServiceNow");
		return this;
	}

	public HomePage clickFillter(String value) {
		type(locateElement("id", "filter"), value);
		return this;
	}

	public CreatePage clickCreateNew() {
		click(locateElement("xpath", "//div[text()='Create New']"));
		return new CreatePage();
	}

	public HomePage clickFillterUpdate(String value) {
		type(locateElement("id", "filter"), value);
		return this;
	}

	public IncidentsPage clickIncidents() {
		click(locateElement("xpath", "(//div[text()='Incidents'])[2]"));
		return new IncidentsPage();
	}

	public TakeSurveyPage clickTakeSurveyButton() {
		click(locateElement("xpath", "//div[text()='Take Survey']"));
		return new TakeSurveyPage();
	}

}
