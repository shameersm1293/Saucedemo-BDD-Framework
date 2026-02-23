package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + "/target/ExtentReport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setDocumentTitle("SauceDemo Automation Report");
			reporter.config().setReportName("BDD Automation Results");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

}
