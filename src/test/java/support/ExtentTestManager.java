package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest extentTest = extent.createTest(testName);
		test.set(extentTest);
		return extentTest;
	}

	public static synchronized ExtentTest getTest() {
		return test.get();
	}

	public static synchronized void endTest() {
		extent.flush();
	}

}
