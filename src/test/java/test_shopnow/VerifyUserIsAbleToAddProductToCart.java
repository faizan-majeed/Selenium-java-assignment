package test_shopnow;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import utils.ExtentTestManager;
import utils.Utility;

import java.io.IOException;

public class VerifyUserIsAbleToAddProductToCart extends BaseTest {

    @Test
    public void verifyUserIsAbleToAddProductToCart() throws IOException {
        ExtentTestManager.createTest("Verify user is able to add product to cart","Verify user is able to add product to cart");

        //Get Data from data.properties file
        String url = Utility.getValue("url");
        String productName=Utility.getValue("miniPortableJuicer");
        String expectedTitle=Utility.getValue("title");

        //PageObjects
        HomePage homePage = new HomePage();
        ProductDetailPage productDetailPage=new ProductDetailPage();
        CartPage cartPage=new CartPage();
        openUrl(url);

        String title=homePage.getTitle();
        ExtentTestManager.getTest().info("Expected: "+expectedTitle);
        ExtentTestManager.getTest().info("Actual: "+title);
        Assert.assertEquals(title,expectedTitle,"Title didn't matched");
        ExtentTestManager.getTest().info(title+" is successfully matched");

        homePage.searchProduct(productName);
        homePage.clickProduct(productName);
        productDetailPage.clickAddToCart();
        boolean actualResultProductAdded=cartPage.verifyProductAddedToCart();
        ExtentTestManager.getTest().info("Expected: Product should be added into cart");
        Assert.assertTrue(actualResultProductAdded,"Product is not added to cart");
        ExtentTestManager.getTest().info("Product is successfully added into cart");
    }
}
