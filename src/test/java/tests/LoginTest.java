package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void should_login_with_valid_credentials_and_redirect_to_inventory() {
        LoginPage loginPage = new LoginPage(driver).load();
        loginPage.loginSuccessfully("standard_user", "secret_sauce");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/inventory.html", "Did not get expected URL");
    }

    @Test
    public void should_display_error_message_when_login_with_invalid_credentials() {
        LoginPage loginPage = new LoginPage(driver).load();
        String displayedMessage = loginPage.loginUnsuccessfully("test", "test")
                .getErrorMessage();

        Assert.assertEquals(displayedMessage, "Epic sadface: Username and password do not match any user in this service", "Did not get expected error message");
    }

    @Test
    public void should_logout_and_redirect_to_login_page() {
        LoginPage loginPage = new LoginPage(driver).load();
        loginPage.loginSuccessfully("standard_user", "secret_sauce")
                .selectMenu()
                .logout();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/", "Did not get expected URL");
    }

}
