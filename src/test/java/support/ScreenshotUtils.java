package support;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String scenarioName) {
	String screenshotDir = System.getProperty("user.dir") + "/target/screenshots/"; 
	String screenshotPath = screenshotDir + scenarioName.replaceAll(" ", "_") + ".png"; try 
	{ 
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		File dir = new File(screenshotDir); 
		if (!dir.exists()) { dir.mkdirs(); } 
		File destFile = new File(screenshotPath); 
		FileUtils.copyFile(srcFile, destFile); 
		} 
	catch (IOException e) { 
		e.printStackTrace(); 
		} 
	return screenshotPath; }
	}
	
	

