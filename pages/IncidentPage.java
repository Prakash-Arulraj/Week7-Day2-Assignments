package pages;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hooks.TestNgHooks;


public class IncidentPage extends TestNgHooks {
	Set<String> allWindowHandles = driver.getWindowHandles();
	List<String> NextWindowHandles = new ArrayList<String>(allWindowHandles);
	
	public IncidentPage enterStae() {
		WebElement incidentstate = driver.findElement(By.id("incident.state")); 
		new Select(incidentstate).selectByIndex(4); 
		return this;
	}
	public IncidentPage updateDescription(String value1) {
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys(value1);
		return this;
	}
	public IncidentPage solvedNotes(String notes) {
		driver.findElement(By.id("incident.work_notes")).sendKeys(notes);
		return this;
	}
	public IncidentPage clickResolution() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		Thread.sleep(3000);
		return this;
	}
	public IncidentPage typeResolution() throws InterruptedException {
		Thread.sleep(2000);
		WebElement incidentclosecode = driver.findElement(By.id("incident.close_code")); 
		new Select(incidentclosecode).selectByValue("Closed/Resolved by Caller"); 
		return this;
	}
	public IncidentsPage clickFinalUpdate() {
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		return new IncidentsPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
