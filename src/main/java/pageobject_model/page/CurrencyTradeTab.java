package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyTradeTab extends BasePage{

    @FindBy(xpath = "//ml-text[text()='Количество']/following-sibling::*[1]/div/input")
    private WebElement quantityOfTokensField;

    @FindBy(xpath = "//button[contains(@class, 'button-main--positive')]")
    private WebElement buttonBuyTokenInTradeTab;

    @FindBy(id = "popover-notification-0")
    private WebElement notificationAboutSuccessfulBuying;

    public CurrencyTradeTab(WebDriver driver) {
        super(driver);
    }

    public CurrencyTradeTab enterQuantityOfTokensForBuying(String quantity) {
        waitForVisibilityOfElement(driver, quantityOfTokensField);
        quantityOfTokensField.clear();
        quantityOfTokensField.sendKeys(Keys.BACK_SPACE + quantity);
        return this;
    }

    public CurrencyTradeTab confirmBuyingOfTokens() {
        waitForElementToBeClickable(driver, buttonBuyTokenInTradeTab);
        buttonBuyTokenInTradeTab.click();
        waitForVisibilityOfElement(driver, notificationAboutSuccessfulBuying);
        return this;
    }

    public boolean haveTokensBeenBought() {
        return notificationAboutSuccessfulBuying.isDisplayed();
    }
}
