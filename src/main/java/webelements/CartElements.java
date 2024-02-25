package webelements;

import org.openqa.selenium.By;

public interface CartElements {
    By cartItem = By.xpath("//div[@class='cc-item-content-top']");
    By deleteProduct=By.xpath("//a[@class='remove remove_from_cart_button']//*[name()='svg']");
    By browseBtn=By.xpath("//a[text()='Browse Products']");
}
