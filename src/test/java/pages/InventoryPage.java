package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By productAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartButton = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage selectMenu() {
        driver.findElement(menuButton).click();
        return this;
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }

    public InventoryPage addSauceLabsBackpackToCart() {
        driver.findElement(productAddToCartButton).click();
        return this;
    }

    public CartPage selectCartButton() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
