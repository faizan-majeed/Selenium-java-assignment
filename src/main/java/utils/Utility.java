package utils;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.BasicFileReporter;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;


public class Utility {
	
	public static String captureWebScreenShot(WebDriver driver, String fileName) throws IOException {
		String destinationPath = null;
		String filePath = null;
		try {

			BasicFileReporter reporter = (BasicFileReporter) ExtentTestManager.getTest().getExtent().getStartedReporters().get(0);
			File report = reporter.getFileFile();
			String folder = report.getParent();
			filePath = "screenshot/" + fileName+".png";
			destinationPath = folder + File.separator +  "screenshot/";
			File destination = new File(destinationPath);
			destinationPath = destination.getAbsolutePath();
			Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 500, true).withName(fileName).save(destinationPath);
			Thread.sleep(2000);
		} catch (Exception e) {
			LogUtil.getLoggerInstance().error(e.getMessage(), e);
		}
		return filePath;
	}
	
	public static void attachWebScreenShotToReport( String fileName) {
		try {
			String imagePath = captureWebScreenShot(WebSetup.getInstance().getDriver(), fileName);
			ExtentTestManager.getTest().info("Screen Capture", MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		} catch (Exception e) {
			LogUtil.getLoggerInstance().error("Error while capturing screen", e);
		}

	}

	
	public static String getValue(String value) throws IOException {
		Properties prop = new Properties();
		FileReader reader=new FileReader("data.properties");  
		prop.load(reader);
		return prop.getProperty(value);
	}
	public static String GenerateRandomNumber() {
		Random rand = new Random();

		// Generate random integers in range 0 to 999999
		int rand_num = rand.nextInt(999999);

		return String.valueOf(rand_num);
	}
	public static String GenerateRandomDate() {
		Random rand = new Random();

		// Generate random integers in range 0 to 999999
		int rand_num = rand.nextInt(30);

		return String.valueOf(rand_num);
	}
}
