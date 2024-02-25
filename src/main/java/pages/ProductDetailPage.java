package pages;

import org.openqa.selenium.WebElement;
import webelements.ProductDetailElements;

public class ProductDetailPage extends BasePage{
    public void clickAddToCart(){
        WebElement element = waitForElementToBeClickable(ProductDetailElements.addToCartBtn,10);
        clickElement(element,"add to cart button");
    }

}
