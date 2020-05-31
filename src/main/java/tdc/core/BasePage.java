package tdc.core;

public class BasePage {

    protected SeleniumDSL dsl;

    public BasePage() {
        dsl = new SeleniumDSL();
    }
}
