package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationFormPage extends BasePage {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.xpath("//h3");

    public CheckoutInformationFormPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationFormPage enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public CheckoutInformationFormPage enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public CheckoutInformationFormPage enterPostalCode(String postalCode) {
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        return this;
    }

    public CheckoutInformationFormPage selectContinueButtonWhenMissingData() {
        driver.findElement(continueButton).click();
        return this;
    }

    public CheckoutOverviewPage selectContinueButton() {
        driver.findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

}
