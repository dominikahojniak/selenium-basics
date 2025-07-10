package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutInformationFormPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void should_add_product_to_the_cart() {
        LoginPage loginPage = new LoginPage(driver).load();
        String productName = loginPage.loginSuccessfully("standard_user", "secret_sauce")
                .addSauceLabsBackpackToCart()
                .selectCartButton()
                .getProductName();
        Assert.assertEquals(productName, "Sauce Labs Backpack", "Wrong product name");
    }

    @Test
    public void should_remove_product_from_the_cart() {
        LoginPage loginPage = new LoginPage(driver).load();
        boolean isCartEmpty = loginPage.loginSuccessfully("standard_user", "secret_sauce")
                .addSauceLabsBackpackToCart()
                .selectCartButton()
                .removeProductFromCart()
                .isRemovedCartItemContainerPresent();
        Assert.assertTrue(isCartEmpty, "Cart is not empty");
    }

    @Test
    public void should_move_forward_after_filling_mandatory_fields() {
        LoginPage loginPage = new LoginPage(driver).load();
        String productInCheckoutOverview = loginPage.loginSuccessfully("standard_user", "secret_sauce")
                .addSauceLabsBackpackToCart()
                .selectCartButton()
                .selectCheckoutButton()
                .enterFirstName("test")
                .enterLastName("test")
                .enterPostalCode("test")
                .selectContinueButton()
                .getProductName();

        Assert.assertEquals(productInCheckoutOverview, "Sauce Labs Backpack", "Wrong product name");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/checkout-step-two.html", "Did not get expected URL");
    }

    @Test
    public void should_display_error_message_when_missing_mandatory_fields() {
        LoginPage loginPage = new LoginPage(driver).load();
        CheckoutInformationFormPage checkoutInformationFormPage = loginPage.loginSuccessfully("standard_user", "secret_sauce")
                .addSauceLabsBackpackToCart()
                .selectCartButton()
                .selectCheckoutButton();
        String firstNameErrorMessage = checkoutInformationFormPage
                .selectContinueButtonWhenMissingData()
                .getErrorMessage();
        String lastNameErrorMessage = checkoutInformationFormPage
                .enterFirstName("test")
                .selectContinueButtonWhenMissingData()
                .getErrorMessage();
        String postalCodeErrorMessage = checkoutInformationFormPage
                .enterLastName("test")
                .selectContinueButtonWhenMissingData()
                .getErrorMessage();

        Assert.assertEquals(firstNameErrorMessage, "Error: First Name is required", "Missing error message about first name");
        Assert.assertEquals(lastNameErrorMessage, "Error: Last Name is required", "Missing error message about last name");
        Assert.assertEquals(postalCodeErrorMessage, "Error: Postal Code is required", "Missing error message about postal code");

    }

    @Test
    public void should_complete_placing_order() {
        LoginPage loginPage = new LoginPage(driver).load();
        String completeHeaderText = loginPage.loginSuccessfully("standard_user", "secret_sauce")
                .addSauceLabsBackpackToCart()
                .selectCartButton()
                .selectCheckoutButton()
                .enterFirstName("test")
                .enterLastName("test")
                .enterPostalCode("test")
                .selectContinueButton()
                .selectFinishButton()
                .getCompleteHeaderText();

        Assert.assertEquals(completeHeaderText, "Thank you for your order!", "Missing complete header text");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/checkout-complete.html", "Did not get expected URL");
    }
}
