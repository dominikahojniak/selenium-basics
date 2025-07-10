package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By productName = By.id("item_4_title_link");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By removeCartItemContainer = By.className("removed_cart_item");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public CartPage removeProductFromCart() {
        driver.findElement(removeButton).click();
        return this;
    }

    public boolean isRemovedCartItemContainerPresent() {
        return !driver.findElements(removeCartItemContainer).isEmpty();
    }

    public CheckoutInformationFormPage selectCheckoutButton() {
        driver.findElement(checkoutButton).click();
        return new CheckoutInformationFormPage(driver);
    }
}
