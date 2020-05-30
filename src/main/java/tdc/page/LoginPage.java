package tdc.page;

import tdc.core.BasePage;

public class LoginPage extends BasePage {

    public void setUsername(String s){
        dsl.write("login-user", s);
    }

    public void setPassword(String s){
        dsl.write("login-pass", s);
    }

    public void actionLogin(){
        dsl.click("login-submit");
    }

    public String getSucessMessage(){
        return dsl.getElement("sucess-message");
    }

    public String getErrorMessage(){
        return dsl.getElement("login-error-message");
    }
}
