package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;

public class ResolveIncidentTest extends TestNgHooks {
	
	@BeforeTest
	public void loginExcel() {
		excelSheetName = "Resolve Incident";
		testcase = "Resolve Incident";
		testDescription = "Resolved Incident To Service Now Application";
		author = "Prakash";
		nodeName = "Resolve Incident Iteration";
		category = "Sanity";
				
	}
	
	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password, String update, String number, String description) throws InterruptedException {
		new LoginPage()
			.typeUsername(username)
			.typePassword(password)
			.clickLogin()
			.verifyHomePage()
			.clickFillterUpdate(update)
			.clickIncidents()
			.clickNumber()
			.typeNumber(number)
			.selectBox()
			.clickPriority()
			.updateSelect()
			.enterStae()
			.updateDescription(description)
			.clickFinalUpdate();
			
			
				
			
			

	}	

}
