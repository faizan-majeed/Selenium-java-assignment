package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.HomeElements;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{

    public String getTitle(){
        return getWebDriver().getTitle();
    }
    public void clickMemberIcon(){
        WebElement element = waitForElementToBeClickable(HomeElements.memberIcon,60);
        clickElement(element,"member icon");
    }
    public void clickCreateAnAccount(){
        WebElement element = waitForElementToBeClickable(HomeElements.createAnAccount,10);
        clickElement(element,"create an account");
    }
    public void searchProduct(String product){
        WebElement element=waitForElementToBeVisible(HomeElements.searchBar,10);
        sendKeysToElement(element,product,"to search field "+product);
    }
    public void clickProduct(String product){
        String path = "//h3[contains(text(),'"+product+"')]//parent::div//parent::a";
        WebElement element=waitForElementToBeClickable(By.xpath(path),10);
        clickElement(element,product);
    }


}
