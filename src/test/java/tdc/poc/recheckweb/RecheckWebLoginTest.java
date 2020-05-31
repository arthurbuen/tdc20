package tdc.poc.recheckweb;

import de.retest.web.selenium.RecheckDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import de.retest.web.selenium.By;

import static org.awaitility.Awaitility.await;

public class RecheckWebLoginTest {

    private RecheckDriver driver;

    static private String SUCESS_MESSAGE_WELCOME = "Bem-vindo ao TDC Floripa Online";
    static private String ERROR_MESSAGE_REQUIRED_FIELD = "Required fields.";
    static private String ERROR_MESSAGE_INVALID_USER = "Invalid username or password.";

    @BeforeMethod
    public void setUp() {

        driver = new RecheckDriver( new ChromeDriver() );
        driver.manage().window().maximize();
        driver.get("C:/Users/arthur_bueno/Documents/tdc/LoginV2/Login/index.html");

    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test ()
    public void sucessLoginTest() {

        driver.startTest("sucessLoginTest");

        driver.findElement(By.id("login-user")).sendKeys("tdcfloripa");
        driver.findElement(By.id("login-pass")).sendKeys("online");
        driver.findElement(By.id("login-submit")).click();

        //await().untilAsserted(() -> Assert.assertEquals(driver.findElement(By.id("sucess-message")).getText(), SUCESS_MESSAGE_WELCOME));
    }

    @Test
    public void requiredFieldsTest() {

        driver.startTest("requiredFieldsTest");

        driver.findElement(By.id("login-user")).sendKeys("");
        driver.findElement(By.id("login-pass")).sendKeys("");
        driver.findElement(By.id("login-submit")).click();

        //await().untilAsserted(() -> Assert.assertEquals(driver.findElement(By.id("login-error-message")).getText(), ERROR_MESSAGE_REQUIRED_FIELD));
    }

    @Test
    public void invalidLoginTest() {

        driver.startTest("invalidLoginTest");

        driver.findElement(By.id("login-user")).sendKeys("tdc");
        driver.findElement(By.id("login-pass")).sendKeys("floripa");
        driver.findElement(By.id("login-submit")).click();

        //await().untilAsserted(() -> Assert.assertEquals(driver.findElement(By.id("login-error-message")).getText(), ERROR_MESSAGE_INVALID_USER));
    }
}
