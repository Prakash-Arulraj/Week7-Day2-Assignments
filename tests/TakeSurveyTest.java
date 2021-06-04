package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;


public class TakeSurveyTest extends TestNgHooks {
	
	@BeforeTest
	public void loginExcel() {
		excelSheetName = "Take Survey";
		testcase = "Take Survey";
		testDescription = "Take Survey To Service Now Application";
		author = "Prakash";
		nodeName = "Take Survey";
		category = "Sanity";
				
	}
	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password, String fillter) {
		new LoginPage()
			.typeUsername(username)
			.typePassword(password)
			.clickLogin()
			.verifyHomePage()
			.clickFillter(fillter)
			.clickTakeSurveyButton()
			.clickExcelent()
			.clickChooseButton()
			.clickHelpful()
			.satisfactionOrNot()
			.clickSurveySubmit();
			
			
	}
}
