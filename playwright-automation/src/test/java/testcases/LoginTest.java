package testcases;


import org.testng.annotations.Test;


import base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void doLogin(){
        getBrowser("chrome");
        navigate(browser, "https://google.com");
    }

}
