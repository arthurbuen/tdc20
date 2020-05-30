package tdc.poc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tdc.core.BaseTest;
import tdc.page.LoginPage;

import static org.awaitility.Awaitility.await;
import static tdc.core.DriverFactory.getDriver;

public class SeleniumLoginTest extends BaseTest {

    private LoginPage login;

    @BeforeMethod
    public void before() {
        login = new LoginPage();
        getDriver().get("file:///C:/Users/arthur_bueno/Documents/tdc/LoginV2/Login/index.html");
    }

    @Test
    public void sucessTest(){

        login.setUsername("tdcfloripa");
        login.setPassword("tdcfloripa");
        login.actionLogin();

        await().untilAsserted(() -> Assert.assertEquals(login.getSucessMessage(), "Bem-vindo ao TDC Floripa Online"));
    }

    @Test
    public void requiredFieldsTest(){

        login.setUsername("");
        login.setPassword("");
        login.actionLogin();

        await().untilAsserted(() -> Assert.assertEquals(login.getErrorMessage(), "Required fields."));
    }

    @Test
    public void invalidLoginTest(){

        login.setUsername("tdc");
        login.setPassword("floripa");
        login.actionLogin();

        await().untilAsserted(() -> Assert.assertEquals(login.getErrorMessage(), "Invalid username or password."));
    }
}
