package tdc.core;

import org.testng.annotations.AfterMethod;
import static tdc.core.DriverFactory.killDriver;


public class BaseTest {

    @AfterMethod
    public void after() throws InterruptedException {
        //Thread.sleep(3000);
        //killDriver();
    }
}
