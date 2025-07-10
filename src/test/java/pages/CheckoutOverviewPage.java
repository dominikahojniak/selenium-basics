package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private final By productName = By.id("item_4_title_link");
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public CheckoutCompletePage selectFinishButton() {
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }
}
