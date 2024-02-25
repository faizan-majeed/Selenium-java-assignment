package basetest;

import listeners.TestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import utils.*;

public class BaseTest {
	BasePage basePage=new BasePage();
    @BeforeTest
    public void driver() {
        WebSetup.getInstance().initDriver();
    }

    @AfterTest
    public void closeBrowser() {
    	Utility.attachWebScreenShotToReport(ExtentTestManager.name+"_"+ESTTimeZone.getCurrentDate("dd_MM_yyyy_HH_mm_ss_ms"));
    	WebSetup.getInstance().getDriver().close();
        WebSetup.getInstance().nullDriver();
    }
    
    //Load url
    public void openUrl(String url) {
    	basePage.loadPage(url);
    }

    @AfterSuite
    public void finish(){
        LogUtil.getLoggerInstance().info(TestListener.class.getName() + " onFinish");
        ExtentManager.getReporter().flush();
    }
    
}
