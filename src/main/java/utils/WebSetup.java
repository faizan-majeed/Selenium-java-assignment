package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class WebSetup {
    public static WebSetup instance;

    private WebDriver driver;

    public static WebSetup getInstance() {
        if (instance == null)
            instance = new WebSetup();
        return instance;
    }

    public void nullDriver(){
        driver = null;
    }

    public WebDriver initDriver() {
        if (driver == null) {
            System.setProperty("headless", "false");
            WebDriverManager.chromedriver().setup();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("incognito");
            chromeOptions.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
