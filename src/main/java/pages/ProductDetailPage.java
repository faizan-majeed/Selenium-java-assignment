package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.HomeElements;
import webelements.ProductDetailElements;

import java.time.Duration;
import java.util.List;

public class ProductDetailPage extends BasePage{
    public void clickAddToCart(){
        WebElement element = waitForElementToBeClickable(ProductDetailElements.addToCartBtn,10);
        clickElement(element,"add to cart button");
    }

}
