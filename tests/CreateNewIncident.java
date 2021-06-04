package tests;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;


public class CreateNewIncident extends TestNgHooks {
	
	@BeforeTest
	public void loginExcel() {
		excelSheetName = "Create Incident";
		testcase = "Create Incident";
		testDescription = "Create Incident To Service Now Application";
		author = "Prakash";
		nodeName = "Create Incident Iteration";
		category = "Sanity";
				
	}
	
	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password, String fillter, String search, String description) throws InterruptedException {
		new LoginPage()
			.typeUsername(username)
			.typePassword(password)
			.clickLogin()
			.verifyHomePage()
			.clickFillter(fillter)
			.clickCreateNew()
			.getNumber()
			.clickCallerId()
			.clickSearch(search)
			.clickFirstMatch()
			.clickDescription(description)
			.clickSubmit();
			
	}

}
