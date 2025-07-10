package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("div[class^='error-message-container']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage loginSuccessfully(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    public LoginPage loginUnsuccessfully(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return this;
    }


    public String getErrorMessage() {
        if (!driver.findElements(errorMessage).isEmpty()) {
            return driver.findElement(errorMessage).getText();
        } else return null;
    }

    public LoginPage load() {
        load("");
        return this;
    }
}
