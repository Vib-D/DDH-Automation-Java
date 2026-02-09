package testcases;


import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;

import base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void doLogin(){
        Browser browser = getBrowser("chrome");
        navigate(browser, "https://google.com");
    }

}
