package tdc.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(1200, 765));
            return driver;
        }
        return driver;
    }

    static void killDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
