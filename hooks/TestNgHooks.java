package hooks;

import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ReadExcelForDataProviding;

import wrappers.BaseDriver;

public class TestNgHooks extends BaseDriver {

	public String excelSheetName;
	
	@BeforeSuite
	public void init() {
		// start reporting
		createTestReport();
	}

	@BeforeTest
	public void setUpTests() {
		// later, lets do it!!
	}

	@BeforeClass
	public void beforClass() {
		createTestcaseEntry(testcase,testDescription,author,category);
	}

	

	@BeforeMethod
	public void invoke() {
		// starting the application
		startIteration(nodeName);
		startApp("chrome", "https://dev103117.service-now.com/");
	}

	@AfterMethod
	public void close() {
		// close the browser
		closeActiveBrowser();
	}

	@AfterClass
	public void afterClass() {
		// later, lets do it !!
	}

	@AfterTest
	public void completeTests() {
		// later, lets do it !!
	}

	@AfterSuite
	public void tearDown() {
		// publish the report
		publishReport();
	}
	@Before
	public void iniBefore() {
		invoke();
	}
	@After
	public void afterClose() {
		close();
	}
	
	@DataProvider(name = "FetchExcelData")
	public Object[][] readExcel(){
		try {
			return ReadExcelForDataProviding.readExcel(excelSheetName);
		} catch (InvalidFormatException e) {
			System.err.println("the excel is in invalid format. looks corrupted");
		} catch (IOException e) {
			System.err.println("the file does not exist");
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
