package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.CartElements;
import webelements.ProductDetailElements;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{
    public boolean verifyProductAddedToCart(){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartElements.cartItem));
        List<WebElement> elementList = getWebDriver().findElements(CartElements.cartItem);
        return !elementList.isEmpty();
    }
    public void deleteProductFromCart(){
        WebElement element=waitForElementToBeClickable(CartElements.deleteProduct,10);
        clickElement(element,"delete button");
    }
    public boolean verifyProductDeletedFromCart(){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartElements.browseBtn));
        List<WebElement> elementList = getWebDriver().findElements(CartElements.browseBtn);
        return !elementList.isEmpty();
    }
}
