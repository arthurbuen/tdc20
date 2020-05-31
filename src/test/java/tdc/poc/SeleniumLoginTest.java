package tdc.poc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tdc.core.BaseTest;
import tdc.page.LoginPage;

import java.nio.file.Paths;

import static org.awaitility.Awaitility.await;
import static tdc.core.DriverFactory.getDriver;

public class SeleniumLoginTest extends BaseTest {

    private LoginPage login;

    static private String SUCESS_MESSAGE_WELCOME = "Bem-vindo ao TDC Floripa Online";
    static private String ERROR_MESSAGE_REQUIRED_FIELD = "Required fields.";
    static private String ERROR_MESSAGE_INVALID_USER = "Invalid username or password.";

    @BeforeMethod
    public void setUp() throws Exception {
        login = new LoginPage();
        String url = Paths.get( "C:/Users/arthur_bueno/Documents/tdc/LoginV2/Login/index.html" ).toUri().toURL().toString();
        getDriver().get(url);
    }

    @Test
    public void sucessLoginTest() {

        login.setUsername("tdcfloripa");
        login.setPassword("online");
        login.actionLogin();

        await().untilAsserted(() -> Assert.assertEquals(login.getSucessMessage(), SUCESS_MESSAGE_WELCOME));
    }

    @Test
    public void requiredFieldsTest() {

        login.setUsername("");
        login.setPassword("");
        login.actionLogin();

        await().untilAsserted(() -> Assert.assertEquals(login.getErrorMessage(), ERROR_MESSAGE_REQUIRED_FIELD));
    }

    @Test
    public void invalidLoginTest() {

        login.setUsername("tdc");
        login.setPassword("floripa");
        login.actionLogin();

        await().untilAsserted(() -> Assert.assertEquals(login.getErrorMessage(), ERROR_MESSAGE_INVALID_USER));
    }
}
