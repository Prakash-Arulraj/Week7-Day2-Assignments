package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;


public class DeleteIncidentTest extends TestNgHooks {
	
	@BeforeTest
	public void loginExcel() {
		excelSheetName = "Delete Incident";
		testcase = "Delete Incident";
		testDescription = "Delete Incident To Service Now Application";
		author = "Prakash";
		nodeName = "Delete Incident";
		category = "Sanity";
				
	}
	
	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password, String update, String number) throws InterruptedException {
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
			.clickName()
			.clickDelete();
	}

}
