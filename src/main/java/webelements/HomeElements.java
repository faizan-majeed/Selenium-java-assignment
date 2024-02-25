package webelements;

import org.openqa.selenium.By;

public interface HomeElements {
	By memberIcon = By.xpath("//div[@class='header-group-action']//a[@href='https://shopnow.com.pk/my-account/']//i");
	By createAnAccount = By.xpath("//a[@title='Register']");
	By searchBar = By.cssSelector("#woocommerce-product-search-field-0");

}
