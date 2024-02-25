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

public class VerifyUserIsAbleToRemoveProductFromCart extends BaseTest {
    @Test
    public void verifyUserIsAbleToAddProductToCart() throws IOException {
        ExtentTestManager.createTest("Verify user is able to remove product from cart","Verify user is able to remove product from cart");

        //get data from data.properties file
        String url = Utility.getValue("url");
        String productName = Utility.getValue("miniPortableJuicer");
        String expectedTitle = Utility.getValue("title");

        //pageObjects
        HomePage homePage = new HomePage();
        ProductDetailPage productDetailPage=new ProductDetailPage();
        CartPage cartPage=new CartPage();
        openUrl(url);

        String title = homePage.getTitle();
        ExtentTestManager.getTest().info("Expected: " + expectedTitle);
        ExtentTestManager.getTest().info("Actual: " + title);
        Assert.assertEquals(title, expectedTitle, "Title didn't matched");
        ExtentTestManager.getTest().info(title + " is successfully matched");

        homePage.searchProduct(productName);
        homePage.clickProduct(productName);
        productDetailPage.clickAddToCart();

        boolean actualResultProductAdded=cartPage.verifyProductAddedToCart();
        ExtentTestManager.getTest().info("Expected: Product should be added into cart");
        Assert.assertTrue(actualResultProductAdded,"Product is not added to cart");
        ExtentTestManager.getTest().info("Product is successfully added into cart");

        cartPage.deleteProductFromCart();

        boolean actualResultProductDeleted=cartPage.verifyProductDeletedFromCart();
        ExtentTestManager.getTest().info("Expected: Product should be deleted into cart");
        Assert.assertTrue(actualResultProductDeleted,"Product is not deleted to cart");
        ExtentTestManager.getTest().info("Product is successfully deleted into cart");




    }
}
