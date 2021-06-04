package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hooks.TestNgHooks;

public class TakeSurveyPage extends TestNgHooks {

	public TakeSurveyPage clickExcelent() {
		driver.switchTo().frame("gsft_main");
		click(locateElement("xpath", "//label[text()='A - Excellent']"));
		return this;
	}

	public TakeSurveyPage clickChooseButton() {
		WebElement aSMTQUESTIONadafacedcfb = driver.findElement(By.xpath("//table[@class='question_spacer survey_table ']//select"));
		new Select(aSMTQUESTIONadafacedcfb).selectByIndex(2);
		return this;
	}

	public TakeSurveyPage clickHelpful() {
		WebElement aSMTQUESTI = driver.findElement(By.xpath("(//table[@role='presentation']//select)[2]"));
		new Select(aSMTQUESTI).selectByIndex(4);
		return this;
	}

	public TakeSurveyPage clickTecnicianRate() {
		WebElement aSMTQUESTI = driver.findElement(By.xpath("(//table[@role='presentation']//select)[3]"));
		new Select(aSMTQUESTI).selectByIndex(2);
		return this;
	}

	public TakeSurveyPage satisfactionOrNot() {
		WebElement aSMTQUESTI = driver.findElement(By.xpath("(//select[@datatype='boolean'])[3]"));
		new Select(aSMTQUESTI).selectByIndex(2);
		return this;
	}

	public TakeSurveyPage clickSurveySubmit() {
		click(locateElement("xpath", "(//button[@name='submit'])[2]"));
		return this;
	}

}
