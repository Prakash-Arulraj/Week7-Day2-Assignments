package utils;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {

	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static ExtentTest node;
	public static File folder;
	public String testcase, testDescription, author, nodeName, category;

	/**
	 * A method to create a new html reporting with appending option
	 * 
	 */
	public void createTestReport() {
		// to store an current date to create automatic
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		folder = new File("./reports/" + date);
		if (!folder.exists()) {
			folder.mkdir();
		}
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(new File(folder + "/index.html"));
		htmlReporter.setAppendExisting(true);
		extent.attachReporter(htmlReporter);
	}

	/***
	 * A method to create a test case entry inside the report.
	 * 
	 * @return ExtentTest the report test case object for the running test.
	 * @param testcase        - the name of the testcase
	 * @param testDescription - the description of the testcase.
	 * @param author          - the automation engineer name for the testcase.
	 * @param category        - the type of estcase (smoke/sanity/regression).
	 */
	public ExtentTest createTestcaseEntry(String testcase, String testDescription, String author, String category) {

		test = extent.createTest(testcase, testDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
		return test;
	}

	public ExtentTest startIteration(String iteration) {
		node = test.createNode(iteration);
		return node;
	}

	public abstract long takeSanp();

	public void reportStep(String step, String status) {
		
		MediaEntityModelProvider snap = null;
		if (!status.equalsIgnoreCase("INFO")) {
			try {
				long snapNumber = takeSanp();
				snap = MediaEntityBuilder.createScreenCaptureFromPath("./../../" + folder + "/" + snapNumber + ".png")
						.build();
			} catch (IOException e) {
			}
		}
		if (status.equalsIgnoreCase("PASS")) {
			node.log(Status.PASS, step, snap);
		} else if (status.equalsIgnoreCase("FAIL")) {
			node.log(Status.FAIL, step, snap);
		} else if (status.equalsIgnoreCase("FAIL")) {
			node.log(Status.WARNING, step, snap);
		} else if (status.equalsIgnoreCase("FAIL")) {
			node.log(Status.INFO, step);
		}
	}

	public void publishReport() {
		extent.flush();
	}

}
