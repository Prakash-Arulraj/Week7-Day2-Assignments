package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;

public class LoginTest extends TestNgHooks {
	
	@BeforeTest
	public void loginExcel() {
		excelSheetName = "Login Incident";
		testcase = "Login";
		testDescription = "Login To Service Now Application";
		author = "Prakash";
		nodeName = "Login Iteration";
		category = "Smoke";
				
	}

	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password) {
		new LoginPage()
			.typeUsername(username)
			.typePassword(password)
			.clickLogin()
			.verifyHomePage();

	}

}
