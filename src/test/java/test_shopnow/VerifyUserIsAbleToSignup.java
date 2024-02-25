package test_shopnow;

import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ExtentTestManager;
import utils.Utility;

import java.io.IOException;

public class VerifyUserIsAbleToSignup extends BaseTest {

    @Test
    public void verifyUserIsAbleToSignup() throws IOException {
        ExtentTestManager.createTest("Verify user is able to signup","Verify user is able to signup");
        String url= Utility.getValue("url");
        HomePage homePage=new HomePage();
        openUrl(url);
        homePage.clickMemberIcon();
        homePage.clickCreateAnAccount();
        //Unable to proceed due to unavailability of signup flow (reference Bug ID:001)
        //Note: it is assumed that assignment document is requirement specification

    }


}
