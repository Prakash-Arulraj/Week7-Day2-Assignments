package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;


public class UpdateIncidentTest extends TestNgHooks{
	
	@BeforeTest
	public void loginExcel() {
		excelSheetName = "Update Incident";
		testcase = "Update Incident";
		testDescription = "Update Incident To Service Now Application";
		author = "Prakash";
		nodeName = "Update Incident";
		category = "Sanity";
				
	}
	
	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password, String update, String number, String text, String notes) throws InterruptedException {
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
			.updateDescription(text)
			.solvedNotes(notes)
			.clickResolution()
			.typeResolution()
			.clickFinalUpdate();
			
			
				
			
			

	}

}
