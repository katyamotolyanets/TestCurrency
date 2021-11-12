package pageobject_model.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyTradeTab extends BasePage{

    @FindBy(xpath = "//div[@class='quantity']/input-number2[@class='input-number']/input")
    private WebElement quantityOfTokensField;

    @FindBy(xpath = "//button[@class='button-main button-main--positive ng-star-inserted']")
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
